package com.yf.pattern.test;

/**
 * Created by ouyangyufeng on 2019/4/25.
 */
public class Animal implements RunFactory{
    @Override
    public void run() {
        System.out.println("动物在跑");
    }
}
