package com.learning.lowleveldesign.logger.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.learning.lowleveldesign.logger.contract.Logger;
import com.learning.lowleveldesign.logger.model.LoggerProcess;

public class LoggerImpl implements Logger {

  private final Map<String, LoggerProcess> processMap;
  private final ConcurrentSkipListMap<Long, List<LoggerProcess>> processMapByTime;
  private final Lock lock;
  private final BlockingQueue<CompletableFuture<String>> futuresBlockingQueue;
  private final ExecutorService[] executorServices;

  public LoggerImpl(int threads) {
    this.processMapByTime = new ConcurrentSkipListMap<>();
    this.processMap = new ConcurrentHashMap<>();
    this.lock = new ReentrantLock();
    this.futuresBlockingQueue = new LinkedBlockingQueue<>();
    this.executorServices = new ExecutorService[threads];
    for (int i = 0; i < 10; i++) {
      executorServices[i] = Executors.newSingleThreadExecutor();
    }
  }

  @Override
  public void start(String processId) {
    executorServices[processId.hashCode() % executorServices.length].execute(() -> {
      long startTime = System.currentTimeMillis();
      LoggerProcess process = new LoggerProcess(processId, startTime);
      processMap.put(processId, process);
      processMapByTime.computeIfAbsent(startTime, k -> new ArrayList<>()).add(process);
    });
  }

  @Override
  public void end(String processId) {
    executorServices[processId.hashCode() % executorServices.length].execute(() -> {
      lock.lock();
      try {
        processMap.get(processId).setEndTime(System.currentTimeMillis());
        String result;
        while (!futuresBlockingQueue.isEmpty() && (result = pollProcess()) != null) {
          futuresBlockingQueue.take().complete(result);
        }
      } catch (InterruptedException e) {
        //e.printStackTrace();
        System.out.println("interupted while take from queue");
      } finally {
        lock.unlock();
      }
    });
  }

  @Override
  public String poll() {
    lock.lock();
    CompletableFuture future = new CompletableFuture<String>();
    try {
      String result;
      if (!futuresBlockingQueue.isEmpty()) {
        futuresBlockingQueue.offer(future);
      } else if ((result = pollProcess()) != null) {
        return result;
      } else {
        futuresBlockingQueue.add(future);
      }
    } finally {
      lock.unlock();
    }
    try {
      future.get(10, TimeUnit.SECONDS);
    } catch (ExecutionException | InterruptedException | TimeoutException e) {
      //throw new RuntimeException(e);
      System.out.println("throwing exception on future wait");
    }
    return null;
  }

  private String pollProcess() {
    if (!processMapByTime.isEmpty()) {
      for (LoggerProcess loggerProcess : processMapByTime.firstEntry().getValue()) {
        if (loggerProcess.getEndTime() != -1) {
          processMapByTime.firstEntry().getValue().remove(loggerProcess);
          if (processMapByTime.firstEntry().getValue().isEmpty()) {
            processMapByTime.pollFirstEntry();
          }
          String template =
              "Process " + loggerProcess.getProcessId() + " started at " + loggerProcess.getStartTime() + " ended at " +
                  loggerProcess.getEndTime();
          System.out.println(template);
          processMap.remove(loggerProcess.getProcessId());
          return template;
        }
      }
    }
    return null;
  }
}
