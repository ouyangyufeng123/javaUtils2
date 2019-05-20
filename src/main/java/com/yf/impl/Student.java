package com.yf.impl;

/**
 *
 * @author ouyangyufeng
 * @date 2019/5/9
 */
public interface Student {

    public static final String name = "张三";

    public abstract void sing();

    void play();

    static void setName(){
        System.out.println("aaa");
    };

}
