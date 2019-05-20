package com.yf.game;


import com.yf.game.model.Enemies;
import com.yf.game.model.Friends;

/**
 *
 * @author ouyangyufeng
 * @date 2019/4/15
 */
public class DefaultFactory2 implements AbstractFactory2 {
    
    @Override
    public Play getGame() {
        return new Game();
    }

}
