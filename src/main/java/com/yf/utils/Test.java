package com.yf.utils;

import com.yf.model.Car;
import com.yf.model.Student;
import org.apache.commons.lang.ClassUtils;
import org.apache.commons.lang.StringUtils;

import java.util.*;

/**
 * 29579
 * 20339
 * 26976
 *
 * @author ouyangyufeng
 * @date 2019/4/16
 */
public class Test {

    public static void main(String[] args) throws Exception {
        int[] arr = new int[]{2, 1, 4, 5, 3};

        System.out.println("排序前: ");
        for (int value : arr) {
            System.out.println(value);
        }

        int tmp;
        for (int i = 0, n = arr.length; i < n; i++) {
            for (int j = i+1, n2 = arr.length; j < n2; j++) {
                if (i != arr.length - 1) {
                    if (arr[i] > arr[j]) {
                        tmp = arr[i];
                        arr[i] = arr[j];
                        arr[j] = tmp;
                    }
                }
            }
        }


        System.out.println();
        System.out.println("排序后: ");
        for (int value : arr) {
            System.out.println(value);
        }
    }

}
