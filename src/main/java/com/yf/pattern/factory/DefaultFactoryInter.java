package com.yf.pattern.factory;

import com.yf.model.Animal;
import com.yf.model.Car;
import com.yf.model.Student;

/**
 *
 * @author ouyangyufeng
 * @date 2019/4/15
 */
public interface DefaultFactoryInter {

    Animal createAnimal();

    Car createCar();

    Student createStudent();

}
