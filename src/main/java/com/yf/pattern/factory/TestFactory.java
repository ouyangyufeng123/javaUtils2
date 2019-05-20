package com.yf.pattern.factory;

import com.yf.model.Car;

/**
 *
 * @author ouyangyufeng
 * @date 2019/4/15
 */
public class TestFactory {

    public static void main(String[] args){
        AbstractFactory factory = new DefaultFactory();
        Car car = factory.createCar();
    }

}
