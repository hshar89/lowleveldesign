package com.learning.lowleveldesign.logger.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import org.junit.jupiter.api.Test;

import static java.util.concurrent.CompletableFuture.runAsync;
import static java.util.concurrent.CompletableFuture.allOf;

import com.learning.lowleveldesign.logger.contract.Logger;

class LoggerImplTest {

  @Test
  public void testSetup() throws ExecutionException, InterruptedException {
    Logger logger = new LoggerImpl(10);
    logger.start("1");
    Thread.sleep(100);
    logger.start("2");
    Thread.sleep(100);
    logger.start("3");
    logger.end("3");
    logger.end("2");
    List<CompletableFuture<Void>> completableFutures = new ArrayList<>();
    //completableFutures.add(runAsync(()->logger.end("3")));
    //completableFutures.add(runAsync(()->logger.end("2")));
    completableFutures.add(runAsync(()->logger.poll()));
    completableFutures.add(runAsync(()->logger.poll()));
    completableFutures.add(runAsync(()->logger.end("1")));
    completableFutures.add(runAsync(()->logger.poll()));
    completableFutures.add(runAsync(()->logger.poll()));
    allOf(completableFutures.toArray(CompletableFuture[]::new)).get();
    Thread.sleep(4000);
  }

}