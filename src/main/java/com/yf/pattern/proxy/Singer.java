package com.yf.pattern.proxy;

/**
 *
 * @author ouyangyufeng
 * @date 2019/4/15
 */
public class Singer implements ISinger{

    @Override
    public void sing(){
        System.out.println("唱一首歌");
    }

    @Override
    public void show(){
        System.out.println("show");
    }

}
