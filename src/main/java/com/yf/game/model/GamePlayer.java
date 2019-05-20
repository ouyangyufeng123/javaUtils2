package com.yf.game.model;

import lombok.Data;

/**
 * 玩家实体
 * @author ouyangyufeng
 * @date 2019/4/15
 */
@Data
public class GamePlayer {

    /**
     * 姓名
     */
    String name;

    /**
     * 年龄
     */
    int age;

    /**
     * 段位
     */
    String duan;

}
