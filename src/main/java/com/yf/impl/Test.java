package com.yf.impl;

/**
 *
 * @author ouyangyufeng
 * @date 2019/5/9
 */
public class Test extends TestAbstract{

    private static StudentFactory studentFactory = new StudentFactoryImpl();

    public static void main(String[] args){
        System.out.println(Student.name);

        Student student = new SecondStudent();
        student.play();

        Student student2 = studentFactory.getFirstStudent();
        student2.play();

        TestAbstract.show();






    }

}
