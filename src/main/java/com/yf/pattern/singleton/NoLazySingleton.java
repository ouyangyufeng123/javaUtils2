package com.yf.pattern.singleton;

/**
 * 饿汉式单例类
 * @author ouyangyufeng
 * @date 2019/4/25
 */
public class NoLazySingleton {

    //私有化构造函数，防止在该类外部通过new的形式创建实例
    private NoLazySingleton(){
        System.out.println("创建NoLazySingleton实例一次！");
    }

    //私有的、静态的实例，设置为私有的防止外部直接访问该实例变量，设置为静态的，说明该实例是LazySingleton类型的唯一的
    //当系统加载NoLazySingleton类文件的时候，就创建了该类的实例
    private static NoLazySingleton instance = new NoLazySingleton();

    //公有的访问单例实例的方法
    public static NoLazySingleton getInstance(){
        return instance;
    }

}
