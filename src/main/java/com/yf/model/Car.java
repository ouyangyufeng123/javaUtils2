package com.yf.model;


import com.yf.reflect.Play;
import lombok.Data;

/**
 *
 * @author ouyangyufeng
 * @date 2019/4/1
 */
@Data
public class Car implements Play<Integer>{

    private String carName;

    private String carColor;

    @Override
    public Integer doPlay() {
        System.out.println("车类");
        return 1234;
    }


}
