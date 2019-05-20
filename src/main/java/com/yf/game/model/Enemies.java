package com.yf.game.model;

import lombok.Data;

/**
 * 敌方实体
 * @author ouyangyufeng
 * @date 2019/4/15
 */
@Data
public class Enemies extends GamePlayer{

    private char sex;

    @Override
    public String toString() {
        return "Enemies{" +
                "sex=" + sex +","+
                "name='" + name + '\'' +","+
                "age='" + age + '\'' +
                '}';
    }
}
