package com.yf.pattern.proxy;

/**
 *
 * @author ouyangyufeng
 * @date 2019/4/15
 */
public class SingerProxy implements ISinger{

    private ISinger target;

    public SingerProxy(ISinger target){
        this.target = target;
    }

    @Override
    public void sing() {
        System.out.println("向观众问好");
        target.sing();
        System.out.println("谢谢大家");
    }

    @Override
    public void show() {
//        System.out.println("向观众问好");
//        target.show();
//        System.out.println("谢谢大家");
    }

}
