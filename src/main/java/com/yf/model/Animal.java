package com.yf.model;


import com.yf.reflect.Play;
import lombok.Data;

/**
 *
 * @author ouyangyufeng
 * @date 2019/4/1
 */
@Data
public class Animal implements Play<Double> {

    private String name;

    private int age;

    @Override
    public Double doPlay() {
       return 1.0;
    }
}
