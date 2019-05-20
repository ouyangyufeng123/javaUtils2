package com.yf.model;


import com.yf.reflect.Play;
import lombok.Data;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author ouyangyufeng
 * @date 2019/4/1
 */
@Data
public class Student{

    private String name;

    private int age;

    public Student(String name, int age){
        this.name = name;
        this.age = age;
    }

    public Student(){

    }
}
