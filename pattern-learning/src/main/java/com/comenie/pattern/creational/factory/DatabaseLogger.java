package com.comenie.pattern.creational.factory;

/**
 * Created by 波 on 2017/2/4.
 */
public class DatabaseLogger implements Logger {
    public void writeLog() {
        System.out.println("database logger writer");
    }
}
