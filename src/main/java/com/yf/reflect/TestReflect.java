package com.yf.reflect;

import com.alipay.api.AlipayClient;
import com.yf.test.Student;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.*;

/**
 * @author ouyangyufeng
 * @date 2019/3/27
 */
public class TestReflect {


    public static void main(String[] args) throws Exception {
//        //第一种方式获取Class对象
//        Student stu = new Student();

//        Class clazz = stu.getClass();
//        //第二种方式获取Class对象
//        //Class clazz = Student.class;
//        //第三种方式获取Class对象
//        //Class clazz = Class.forName("com.yf.test.Student");
//
//
//        /*
// * 通过Class对象可以获取某个类中的：构造方法、成员变量、成员方法；并访问成员；
// *
// * 1.获取构造方法：
// *      1).批量的方法：
// *          public Constructor[] getConstructors()：所有”公有的”构造方法
//            public Constructor[] getDeclaredConstructors()：获取所有的构造方法(包括私有、受保护、默认、公有)
//
// *      2).获取单个的方法，并调用：
// *          public Constructor getConstructor(Class… parameterTypes):获取单个的”公有的”构造方法：
// *          public Constructor getDeclaredConstructor(Class… parameterTypes):获取”某个构造方法”可以是私有的，或受保护、默认、公有；
// *
// *          调用构造方法：
// *          Constructor–>newInstance(Object… initargs)
// */
//        Constructor[] constructors = clazz.getConstructors();
//        for (Constructor c : constructors) {
//            System.out.println("获取公有的构造方法: " + c);
//        }
//
//        constructors = clazz.getDeclaredConstructors();
//        for (Constructor c : constructors) {
//            System.out.println("获取所有的构造方法: " + c);
//        }
//
//        Constructor cons = clazz.getConstructor(String.class, int.class);
//        System.out.println("获取单个公有的构造方法: " + cons);
//
//        Constructor cons2 = clazz.getDeclaredConstructor();
//        System.out.println("获取单个所有的构造方法: " + cons2);
//
//        //调用构造函数
//        cons.newInstance("张三", 20);
//        cons2.newInstance();
//
//        System.out.println("---------------------------------------------------");
//
//
//
//
//        //调用toString()方法
//        Method toString =clazz.getMethod("toString");
//        System.out.println(toString.invoke(stu));
//
//        Method m = clazz.getMethod("getSingle");
//        System.out.println(m);
//        m.invoke(stu);


        //通过反射获取Class对象
        Class stuClass = Class.forName(getValue("className"));//"cn.fanshe.Student"
        //2获取show()方法
        Method m = stuClass.getMethod(getValue("methodName"));//show
        //3.调用show()方法
        m.invoke(stuClass.getConstructor().newInstance());

    }

    //此方法接收一个key，在配置文件中获取相应的value
    public static String getValue(String key) throws IOException {
        Properties pro=new Properties();
        InputStream in = Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties");
        pro.load(in);
        System.out.println(pro.toString());
        in.close();
        return pro.getProperty(key);
    }

}
