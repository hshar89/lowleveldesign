package com.learning.lowleveldesign.logger.impl;

import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

import com.learning.lowleveldesign.logger.contract.Logger;
import com.learning.lowleveldesign.logger.model.LoggerProcess;

public class LoggerImpl implements Logger {

  private final Map<String, LoggerProcess> processMap;
  private final Queue<LoggerProcess> processQueue;
  private final Lock lock;
  private final List<CompletableFuture> futures;
  private final ExecutorService[] executorServices;

  private static final Logger INSTANCE = new LoggerImpl();

  private LoggerImpl() {
    this.processQueue = new LinkedBlockingQueue<>();
    this.processMap = new ConcurrentHashMap<>();
    this.lock = new ReentrantLock();
    this.futures = new CopyOnWriteArrayList<>();
    this.executorServices = new ExecutorService[10];
  }

  public static Logger getInstance() {
    return INSTANCE;
  }

  @Override
  public void start(String processId) {
    executorServices[processId.hashCode()%executorServices.length].execute(()->{
      LoggerProcess process = new LoggerProcess(processId, System.currentTimeMillis());
      processMap.put(processId, process);
      processQueue.add(process);
    });
  }

  @Override
  public void end(String processId) {
    executorServices[processId.hashCode()%executorServices.length].execute(()->{
      lock.lock();
      try {
        processMap.get(processId).setEndTime(System.currentTimeMillis());
        if (!futures.isEmpty() && processQueue.peek().getProcessId().equalsIgnoreCase(processId)) {
          pollProcess();
          CompletableFuture completableFuture = futures.get(0);
          futures.remove(0);
          completableFuture.complete(null);
        }
      } finally {
        lock.unlock();
      }
    });
  }

  @Override
  public String poll() {
    lock.lock();
    try {
      CompletableFuture future = new CompletableFuture<String>();
      if (!processQueue.isEmpty() && processMap.get(processQueue.peek().getProcessId()).getEndTime() != -1) {
        pollProcess();
      } else {
        futures.add(future);
      }
      future.get(3, TimeUnit.SECONDS);
    } catch (ExecutionException | InterruptedException | TimeoutException e) {
      throw new RuntimeException(e);
    } finally {
      lock.unlock();
    }
    return null;
  }

  private String pollProcess() {
    LoggerProcess loggerProcess = processQueue.poll();
    System.out.println(
        "Process " + loggerProcess.getProcessId() + " started at " + loggerProcess.getStartTime() + " ended at " +
            loggerProcess.getEndTime());
    processMap.remove(loggerProcess.getProcessId());
    return loggerProcess.getProcessId();
  }
}
