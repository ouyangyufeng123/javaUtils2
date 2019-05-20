package com.yf.thread;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author ouyangyufeng
 * @date 2019/4/24
 */
public class TestDome {

    //定义100张优惠券
    private static volatile int trainCount = 100;
    static Lock lock = new ReentrantLock();
    static Map map = new HashMap<>();

    // 卖票方法
    public static void sale() {
        //lock.lock();
        try {
            if (trainCount > 0) {
                System.out.println(Thread.currentThread().getName() + "还剩" + (trainCount) + "张优惠券");
                trainCount--;
            }else {
                System.out.println("活动已结束");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            //lock.unlock();
        }

    }


    public static void main(String[] args) {
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        int num = trainCount;
        for (int i = num; i >= 0; i--) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    //while (trainCount > 0) {
                        try { // 休眠50秒
                            Thread.sleep(50);
                            sale();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    //}
                    fixedThreadPool.shutdown();
                }
            });
        }

//        TestDome testDome = new TestDome();
//        Thread thread = new Thread(testDome, "窗口1");
//        Thread thread2 = new Thread(testDome, "窗口2");
//        Thread thread3 = new Thread(testDome, "窗口3");
//        thread.start();
//        thread2.start();
//        thread3.start();
    }
}

class MyThread extends Thread{
    public MyThread(){
        System.out.println("构造函数开始");
        System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
        System.out.println("this.Name=" + this.getName());
        System.out.println("构造函数结束");
    }
    @Override
    public void run(){
        System.out.println("run方法开始");
        System.out.println("Thread.currentThread().getName()=" + Thread.currentThread().getName());
        System.out.println("this.Name=" + this.getName());
        System.out.println("run方法结束");
    }
}