package com.yf.annotation;

/**
 *
 * @author ouyangyufeng
 * @date 2019/4/16
 */

public class AnnotationUse {

    public static void main(String[] args)throws Exception{
        Class clazz = Class.forName("com.yf.annotation.AnnotationUse");
        if(clazz.getMethod("show",new Class[]{String.class,String.class}).isAnnotationPresent(MyAnnotation.class)){
            MyAnnotation annotation = (MyAnnotation) clazz.getMethod("show",String.class,String.class).getAnnotation(MyAnnotation.class);
            System.out.println(annotation.name());
            clazz.getMethod("show",String.class,String.class).invoke(new AnnotationUse(),"a","b");
        };
    }

    @MyAnnotation
    public void show(String a, String b){
        System.out.println("1");
        System.out.println(Thread.currentThread().getStackTrace()[1].getMethodName());
    }
}
