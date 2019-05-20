package com.yf.game;


import com.yf.game.model.Enemies;
import com.yf.game.model.Friends;

/**
 *
 * @author ouyangyufeng
 * @date 2019/4/15
 */
public class DefaultFactory extends AbstractFactory {


    @Override
    public Enemies createEnemies() {
        return new Enemies();
    }

    @Override
    public Friends createFriends() {
        return new Friends();
    }
}
