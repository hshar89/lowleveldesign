package com.learning.lowleveldesign.logger.driver;

import com.learning.lowleveldesign.logger.contract.Logger;
import com.learning.lowleveldesign.logger.impl.LoggerImpl;

public class Application
{
  public static void main(String[] args){
    Logger logger = new LoggerImpl();
    logger.start("3");
    logger.poll();
    logger.start("1");
    logger.poll();
    logger.start("2");
    logger.end("1");
    logger.poll();
    logger.end("2");
    logger.poll();
    logger.end("3");
    logger.poll();
    logger.poll();
    logger.poll();
    logger.poll();
  }
}
