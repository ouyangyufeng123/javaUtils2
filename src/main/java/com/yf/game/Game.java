package com.yf.game;

import com.yf.game.utils.BaseService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Random;

/**
 * @author ouyangyufeng
 * @date 2019/4/15
 */
public class Game extends BaseService implements Play {

    /**
     * 当前对象单例（饿汉式）
     */
    private static Game game = new Game();

//    public static Game getInstance() {
//        if (game == null) {
//            game = new Game();
//        }
//        return game;
//    }

    public static void main(String[] args) {
        //game = getInstance();
        //定义出拳规则
        rule();
        //开始游戏
        game.dynamicProxy();
        //选择游戏模式
        choiceMode();

    }


    /**
     * -------------------代码封装区域-------------------------
     */


    /**
     * 游戏逻辑判断
     */
    int i = 1;
    @Override
    public void play(int mode) {
        //友方先出拳
        System.out.print("轮到你啦,请出拳:");
        String boxing = SCANNER.next();

        //电脑出拳
        Random random = new Random();
        int value = 0;
        System.out.println(enemies.getName()+"出拳----->" + ATTRIBUTE[value = random.nextInt(3)]);

        //输赢比较（一局一胜）
        if (mode == 1) {
            show(boxing, value);
        } else if(mode == 2){
            //三局两胜
            show(boxing, value);
            while (i < 3) {
                i += 1;
                play(2);
            }
        }else {
            //五局三胜
            show(boxing, value);
            while (i < 5) {
                i += 1;
                play(3);
            }
        }
    }


    /**
     * 动态代理
     */
    public void dynamicProxy() {
        play = (Play) Proxy.newProxyInstance(
                game.getClass().getClassLoader(),
                game.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        //数据初始化
                        setInit();
                        //执行目标对象方法
                        Object returnValue = method.invoke(game, args);
                        //排行榜
                        rankingList();
                        return returnValue;
                    }
                });
    }
}
