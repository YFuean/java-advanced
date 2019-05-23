package com.soft1841.designpatten.decorator;

import java.util.Calendar;

public class TimeLoggerDecorator implements Logger {
    private Logger decoratorLogger;
    public  TimeLoggerDecorator(Logger decoratorLogger){
        this.decoratorLogger = decoratorLogger;
    }
    @Override
    public void log(String message) {
        decoratorLogger.log(message);
        logTime();
    }

    private void logTime() {
        System.out.println(Calendar.getInstance().getTime());
    }
}
