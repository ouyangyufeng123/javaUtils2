package com.yf.pattern.test;

/**
 * Created by ouyangyufeng on 2019/4/25.
 */
public class TestDome {

    public static void main(String[] args){
        RunFactory runFactory = (Car)DefaultFactory.create(Car.class);
        runFactory.run();
    }
}
