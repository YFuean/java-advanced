package com.soft1841.designpatten.decorator;

/**
 * 装饰器模式
 */
public class LoggerTest {
    public static void main(String[] args) {
        Logger logger = new TimeLoggerDecorator(new LoggerFileSystem());
        logger.log("登录系统");
        Logger logger1 = new TimeLoggerDecorator(new LoggerCloud());
        logger1.log("登录系统");
    }
}
