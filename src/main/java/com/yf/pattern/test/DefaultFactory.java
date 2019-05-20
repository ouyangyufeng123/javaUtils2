package com.yf.pattern.test;

/**
 * Created by ouyangyufeng on 2019/4/25.
 */
public class DefaultFactory {

    public static Object create(Class<? extends RunFactory> clazz){
        Object object = null;
        try {
            object = clazz.newInstance();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return object;
    }


}
