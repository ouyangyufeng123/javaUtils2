package com.yf.pattern.test2;

/**
 * Created by ouyangyufeng on 2019/4/25.
 */
public class CatFactory extends abstractFactory{
    @Override
    public abstractAnimal getAnimal() {
        return new Cat();
    }

    @Override
    public abstractCall getCall() {
        return new CatCall();
    }
}
