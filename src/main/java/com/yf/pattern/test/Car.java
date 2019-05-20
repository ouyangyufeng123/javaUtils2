package com.yf.pattern.test;

/**
 * Created by ouyangyufeng on 2019/4/25.
 */
public class Car implements RunFactory{
    @Override
    public void run() {
        System.out.println("汽车在跑");
    }
}
