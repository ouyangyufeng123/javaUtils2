package com.yf.game;

import com.yf.game.model.Enemies;
import com.yf.game.model.Friends;
import com.yf.model.Animal;
import com.yf.model.Car;
import com.yf.model.Student;

/**
 * 定义抽象工厂对象
 * @author ouyangyufeng
 * @date 2019/4/15
 */
public abstract class AbstractFactory {

    public abstract Enemies createEnemies();

    public abstract Friends createFriends();

}
