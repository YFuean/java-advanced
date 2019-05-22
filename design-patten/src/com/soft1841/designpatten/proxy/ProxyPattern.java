package com.soft1841.designpatten.proxy;

/**
 * 代理模式 客户端
 */
public class ProxyPattern {
    public static void main(String[] args) {
        Subject proxy = new Proxy();
        proxy.buyMac();
    }
}
