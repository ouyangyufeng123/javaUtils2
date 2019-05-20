package com.yf.pattern.test2;

/**
 * Created by ouyangyufeng on 2019/4/25.
 */
public class DogFactory extends abstractFactory{
    @Override
    public abstractAnimal getAnimal() {
        return new Dog();
    }

    @Override
    public abstractCall getCall() {
        return new DogCall();
    }
}
