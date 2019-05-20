package com.yf.impl;

/**
 *
 * @author ouyangyufeng
 * @date 2019/5/9
 */
public class StudentFactoryImpl implements StudentFactory{
    @Override
    public Student getFirstStudent() {
        return new FirstStudent();
    }

    @Override
    public Student getSecondStudent() {
        return new SecondStudent();
    }
}
