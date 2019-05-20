package com.yf.generic;

import java.util.*;

/**
 * Created by ouyangyufeng on 2019/5/13.
 */
public class Test {

    public static void main(String[] args) {
        Set set = new HashSet<>();
        set.add(3);
        set.add(2);
        set.add(1);
        set.add(5);
        set.add(4);
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }


}
