package com.yf.game.model;

import lombok.Data;

/**
 * 友方实体
 * @author ouyangyufeng
 * @date 2019/4/15
 */
@Data
public class Friends extends GamePlayer{

    private String remarks;

    @Override
    public String toString() {
        return "Friends{" +
                "remarks='" + remarks + '\'' +","+
                "name='" + name + '\'' +","+
                "age='" + age + '\'' +
                '}';
    }
}
