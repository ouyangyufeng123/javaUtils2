package com.yf.pattern.factory;

import com.yf.model.Animal;
import com.yf.model.Car;
import com.yf.model.Student;

/**
 *
 * @author ouyangyufeng
 * @date 2019/4/15
 */
public abstract class AbstractFactory{

    /**
     * 定义抽象工厂对象
     */
    public abstract Animal createAnimal();

    public abstract Car createCar();

    public abstract Student createStudent();


}
