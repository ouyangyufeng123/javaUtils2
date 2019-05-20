package com.yf.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author ouyangyufeng
 * @date 2019/3/12
 */
public class ThreadPoolExecutorTest {

    public static void main(String[] args) {
//        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(5);
//        int num = 100;
//        for (int i = num; i >= 0; i--) {
//            final int index = i;
//            fixedThreadPool.execute(new Runnable() {
//                @Override
//                public void run() {
//                    //倒计时开始
//                   // System.out.println("倒计时开始:"+num);
//
//                    System.out.println(Thread.currentThread().getName()+"正在被执行:"+index);
//
//                    fixedThreadPool.shutdown();
////                    for (int i = 34560; i >= 0; i--) {
////                        try {
////                            System.out.println(i + "秒");
////                            Thread.sleep(1000);
////                        } catch (InterruptedException e) {
////                            e.printStackTrace();
////                        }
////                    }
//                    //倒计时结束
//                    //System.out.println("已结束!");
//                }
//            });
//        }
        String a = "123456789123456789";
        System.out.println(a.substring(0,16));

    }

}
