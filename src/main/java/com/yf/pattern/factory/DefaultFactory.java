package com.yf.pattern.factory;

import com.yf.model.Animal;
import com.yf.model.Car;
import com.yf.model.Student;

/**
 *
 * @author ouyangyufeng
 * @date 2019/4/15
 */
public class DefaultFactory extends AbstractFactory{

    @Override
    public Animal createAnimal() {
        return new Animal();
    }

    @Override
    public Car createCar() {
        return new Car();
    }

    @Override
    public Student createStudent() {
        return new Student();
    }

}
