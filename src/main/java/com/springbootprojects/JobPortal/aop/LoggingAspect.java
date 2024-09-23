package com.springbootprojects.JobPortal.aop;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class LoggingAspect {
    private static final Logger LOGGER = LoggerFactory.getLogger(LoggingAspect.class);

    public void logMethodCall(){
        LOGGER.info("Method called");
    }
}
