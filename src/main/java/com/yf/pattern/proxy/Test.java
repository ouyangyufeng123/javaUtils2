package com.yf.pattern.proxy;

import org.springframework.aop.framework.ProxyFactory;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 *
 * @author ouyangyufeng
 * @date 2019/4/15
 */
public class Test implements MethodInterceptor {

    private Singer target = null;

    private Test(Singer target){
        this.target = target;
    }

    private static ISinger proxy;

    public static void main(String[] args){
        //静态代理
//        ISinger iSinger = new SingerProxy(new Singer());
//        iSinger.sing();

        //动态代理
//        new Test(new Singer()).dynamicProxy();
//        proxy.sing();

        //Cglib代理
        //目标对象
        Singer target = new Singer();
        //代理对象
        Singer proxy = (Singer)new Test(target).getProxyInstance();
        //执行代理对象的方法
        proxy.sing();
    }


    /**
     * 动态代理
     */
    public void dynamicProxy(){
        proxy  = (ISinger) Proxy.newProxyInstance(
                target.getClass().getClassLoader(),
                target.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("向观众问好");
                        //执行目标对象方法
                        Object returnValue = method.invoke(target, args);
                        System.out.println("谢谢大家");
                        return returnValue;
                    }
                });
    }



    /**
     * Cglib代理
     */
    // 给目标对象创建一个代理对象
    public Object getProxyInstance(){
        //1.工具类
        Enhancer en = new Enhancer();
        //2.设置父类
        en.setSuperclass(target.getClass());
        //3.设置回调函数
        en.setCallback(this);
        //4.创建子类(代理对象)
        return en.create();
    }

    @Override
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("向观众问好");
        //执行目标对象的方法
        Object returnValue = method.invoke(target, args);
        System.out.println("谢谢大家");
        return returnValue;
    }

}
