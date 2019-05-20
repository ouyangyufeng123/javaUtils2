package com.yf.utils;

import org.apache.poi.ss.formula.functions.T;

import java.util.Comparator;

/**
 * Created by ouyangyufeng on 2019/4/29.
 */
public class Sort implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        if((int)o1 > (int)o2){
            return 1;
        }else if((int)o1 < (int)o2){
            return -1;
        }else {
            return 0;
        }
    }
}
