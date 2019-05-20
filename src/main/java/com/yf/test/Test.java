package com.yf.test;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.sun.org.apache.xpath.internal.operations.Equals;
import org.apache.commons.lang.StringUtils;

import java.awt.*;
import java.util.*;
import java.util.List;

/**
 * Created by ouyangyufeng on 2019/3/12.
 */
public class Test extends Frame {

    public static void main(String[] args) {
//        String a = "{enterpriseCode=E180001, vehicleList=[{\"vin\":\"1\",\"carModel\":\"1\",\"makeDate\":\"Mar 23, 2019 12:00:00 AM\",\"carType\":\"1\",\"vehUse\":\"1\",\"engineNo\":\"1\"}]}";
//        Gson gson = new Gson();
//        Map<String, Object> map = new HashMap<String, Object>();
//        map = gson.fromJson(a, map.getClass());
//        System.out.println(map.get("vehicleList"));
//        a();
    }

    /**
     * Map转String
     *
     * @param map
     * @return
     */
    public static String getMapToString(Map<String, Object> map) {
        Set<String> keySet = map.keySet();
        //将set集合转换为数组
        String[] keyArray = keySet.toArray(new String[keySet.size()]);
        //给数组排序(升序)
        Arrays.sort(keyArray);
        //因为String拼接效率会很低的，所以转用StringBuilder
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < keyArray.length; i++) {
            // 参数值为空，则不参与签名 这个方法trim()是去空格
            if ((String.valueOf(map.get(keyArray[i]))).trim().length() > 0) {
                sb.append(keyArray[i]).append(":").append(String.valueOf(map.get(keyArray[i])).trim());
            }
            if (i != keyArray.length - 1) {
                sb.append(",");
            }
        }
        return sb.toString();
    }

    /**
     * String转map
     *
     * @param str
     * @return
     */
    public static Map<String, Object> getStringToMap(String str) {
        //根据逗号截取字符串数组
        String[] str1 = str.split(",");
        //创建Map对象
        Map<String, Object> map = new HashMap<>();
        //循环加入map集合
        for (int i = 0; i < str1.length; i++) {
            //根据":"截取字符串数组
            String[] str2 = str1[i].split(":");
            //str2[0]为KEY,str2[1]为值
            map.put(str2[0], str2[1]);
        }
        return map;
    }

    public static void a(){
//        Equals e1 = new Equals();
//        Equals e2 = new Equals();
//        Test t1 = new Test();
//        Test t2 = new Test();
//        System.out.println(t1.toString() == t2.toString());
//        System.out.println(t1.equals(t2));
        String s1 = "321";
        String s2 = "123";
        System.out.println(s1.isEmpty());
    }



    @Override
    public boolean equals(Object anObject) {
        System.out.println(anObject.toString());
        return true;
    }
}
