package com.yf.pattern.singleton;

/**
 * 懒汉式单例类
 * @author ouyangyufeng
 * @date 2019/4/25
 */
public class LazySingleton {

    //私有化构造函数，防止在该类外部通过new的形式创建实例
    public LazySingleton() {
        System.out.println("生成LazySingleton实例一次！");
    }

    //私有的、静态的实例，设置为私有的防止外部直接访问该实例变量，设置为静态的，说明该实例是LazySingleton类型的唯一的
    //若开始时，没有调用访问实例的方法，那么实例就不会自己创建
    private static LazySingleton lazyInstance = null;

    //公有的访问单例实例的方法，当外部调用访问该实例的方法时，实例才被创建(非线程安全)
    public LazySingleton getLazyInstance() {
        //若实例还没有创建，则创建实例；若实例已经被创建了，则直接返回之前创建的实例,即不会返回2个实例
        if (lazyInstance == null) {
            System.out.println("实例化对象");
            lazyInstance = new LazySingleton();
        }else {
            System.out.println("对象已实例");
        }
        return lazyInstance;
    }

    /**
     * (synchronized---线程安全(效率低))
     * @return
     */
    public static LazySingleton getLazyInstance2() {
        //若实例还没有创建，则创建实例；若实例已经被创建了，则直接返回之前创建的实例,即不会返回2个实例
        synchronized (LazySingleton.class){
            if (lazyInstance == null) {
                System.out.println("实例化对象");
                lazyInstance = new LazySingleton();
            }else {
                System.out.println("对象已实例");
            }
        }
        return lazyInstance;
    }

}
