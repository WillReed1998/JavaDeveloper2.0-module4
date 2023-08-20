package org.example;

import org.apache.log4j.Level;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public class LoggingControl implements LoggingControlMBean {

    private static final Logger logger = Logger.getLogger(LoggingControl.class);
    @Override
    public void enableLogging() {
        LogManager.getRootLogger().setLevel(Level.DEBUG);
        logger.info("DEBUG");
    }

    @Override
    public void disableLogging() {
        LogManager.getRootLogger().setLevel(Level.OFF);
        logger.info("OFF");
    }
}