package com.comenie.pattern.creational.factory;

/**
 * Created by 波 on 2017/2/4.
 */
public class FileLoggerFactory implements LoggerFactory {
    public Logger createLogger() {
        return new FileLogger();
    }
}
