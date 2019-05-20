package com.yf.test;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author ouyangyufeng
 * @date 2019/4/1
 */
public class Student {

    private static Student student;

    private static Lock lock = new ReentrantLock();

    private String name;

    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Student() {
        System.out.println("无参构造");
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    /**
     * 单例
     */
    public static Student getSingle(){
        //System.out.println("创建对象...");
        //if(lock.tryLock()) {
        lock.lock();
        try {
            if (student == null) {
                System.out.println("新对象");
                student = new Student();
            }
            System.out.println("旧对象");
            //}
        }finally {
            lock.unlock();
        }

        return student;
    }

}
