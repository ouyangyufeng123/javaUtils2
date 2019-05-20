package com.yf.reflect;

import com.yf.model.Car;
import com.yf.model.Student;
import org.apache.poi.ss.formula.functions.T;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author ouyangyufeng
 * @date 2019/4/12
 */
public class TestDome {

    public static void main(String[] args) throws Exception {
//        Play stu = (Student)getInstance(Student.class);
//        System.out.println(stu.doPlay());

        //stu.setName("张三");
        //System.out.println(stu.toString());

//        Student stu = new Student();
//        List<Student> list = select(Student.class);
//        for (Student stu :list){
//            System.out.println(stu);
//        }

//        Student stu = new Student("aaa",20);
//        System.out.println(stu.toString());

        print("1111","aa",1,1.0,true);
    }


    /**
     * 运用反射机制动态创建对象
     *
     * @param clazz
     * @return
     * @throws Exception
     */
    public static Object getInstance(Class clazz) throws Exception {
        return clazz.newInstance();
    }


    public static <T> List<T> select(Class<T> clazz) {
        List list = new ArrayList<>();
        list.add(new Student("aa",20));
        System.out.println(list);
        System.out.println(clazz.getName());
        return list;
    }


    public static void print(String name,Object... args){
        System.out.println(name);
        for (Object obj:args) {
            System.out.println(obj);
        }
    }

}
