package com.yf.pattern.singleton;

/**
 *
 * @author ouyangyufeng
 * @date 2019/4/25
 */
public class TestSingleton {

    public static void main(String[] args){
        for (int i=0;i<10;i++){
            new Thread() {
                @Override
                public void run() {
//                    LazySingleton.getLazyInstance();
                    SingletonDemo.ADMIN.login("admin","123456");
                }
            }.start();
        }


    }

}
