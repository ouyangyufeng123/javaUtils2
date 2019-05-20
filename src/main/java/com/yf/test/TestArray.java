package com.yf.test;

import java.util.*;

/**
 *
 * @author ouyangyufeng
 * @date 2019/4/23
 */
public class TestArray {


    public static void main(String[] args){

        Vector list = new Vector<>();
        list.add("a");
        list.add("b");
        list.add("c");

        list.forEach(e ->{
            System.out.println(e);
        });
//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()){
//            System.out.println(iterator.next());
//        }

    }


}
