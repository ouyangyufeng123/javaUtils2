package com.yf.impl;

/**
 *
 * @author ouyangyufeng
 * @date 2019/5/9
 */
public class FirstStudent implements Student{

    @Override
    public void sing() {
        System.out.println("第一个学生在唱歌");
    }

    @Override
    public void play() {
        System.out.println("第一个学生在玩");
    }

}
