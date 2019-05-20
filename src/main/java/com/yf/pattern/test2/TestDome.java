package com.yf.pattern.test2;

/**
 *
 * @author ouyangyufeng
 * @date 2019/4/25
 */
public class TestDome {

    public static void main(String[] args){
        abstractFactory animalFactory = new CatFactory();
        animalFactory.getAnimal().getName();
        animalFactory.getCall().getCall();
    }

}
