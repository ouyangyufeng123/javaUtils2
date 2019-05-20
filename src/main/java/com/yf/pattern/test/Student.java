package com.yf.pattern.test;

/**
 * Created by ouyangyufeng on 2019/4/25.
 */
public class Student implements RunFactory{
    @Override
    public void run() {
        System.out.println("学生在跑");
    }
}
