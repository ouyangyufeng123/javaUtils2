package com.yf.game.utils;

import com.yf.game.AbstractFactory;
import com.yf.game.DefaultFactory;
import com.yf.game.Game;
import com.yf.game.Play;
import com.yf.game.model.Enemies;
import com.yf.game.model.Friends;
import com.yf.game.model.Status;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 工具类
 * @author ouyangyufeng
 * @date 2019/4/18
 */
public class BaseService {

    /**
     * 定义Scanner扫描器
     */
    public final static Scanner SCANNER = new Scanner(System.in);

    /**
     * 创建工厂对象
     */
    public final AbstractFactory FACTORY = new DefaultFactory();

    /**
     * 定义出拳属性
     */
    public final String[] ATTRIBUTE = new String[]{Status.SCISSORS.getAttribute(), Status.STONE.getAttribute(), Status.CLOTH.getAttribute()};

    /**
     * 定义输赢胜负
     */
    public String[] RESULT = null;


    public static Play play = null;

    /**
     * 初始化对象
     */
    public Enemies enemies = null;

    public Friends friends = null;

    /**
     * 定义玩家得分
     */
    public int friendScore = 0;

    public String friendResult = "";

    /**
     * 定义电脑得分
     */
    public int enemieScore = 0;

    public String enemieResult = "";


    /**
     * 定义规则
     */
    public static void rule() {
        System.out.println("----------游戏规则如下----------");
        System.out.println("1.一局一胜或五局三胜");
        System.out.println("2.友方先出拳,电脑随机出拳");
        System.out.println("3.获胜方加一分,反之不加分");
        System.out.println("3.得分最多的一方获胜");
        System.out.println("--------------------------------");
    }

    //数据初始化
    public void setInit() {
        //创建友方玩家
        friends = FACTORY.createFriends();
        friends.setName("YF有点菜");
        friends.setAge(20);
        friends.setDuan("最强王者");
        friends.setRemarks("此人很强");
        //创建友方玩家
        enemies = FACTORY.createEnemies();
        enemies.setName("小佳楠鸭");
        enemies.setAge(18);
        enemies.setSex('女');
        enemies.setDuan("倔强青铜");

        RESULT = new String[]{enemies.getName()+"胜", friends.getName()+"胜", "平局"};

        System.out.println("-------玩家已就位-------");
        System.out.println(friends.getName() + " VS " + enemies.getName());
        System.out.println("------------------------");
    }

    /**
     * 选择游戏模式
     */
    public static void choiceMode() {
        System.out.println("*****请选择游戏模式*****");
        System.out.println("1.一局一胜");
        System.out.println("2.三局两胜");
        System.out.println("3.五局三胜");
        System.out.print("请选择:");
        int mode = SCANNER.nextInt();
        if (mode == 1 || mode == 2 || mode == 3) {
            System.out.println("自动匹配对手中,请稍等...");
            Timer timer = new Timer();
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    play.play(mode);
                }
            }, 3000);
        } else {
            System.out.println("选择错误,请重新选择!");
            choiceMode();
        }
    }

    /**
     * 输赢比较
     * @param boxing
     * @param value
     */
    public void show(String boxing, int value){
        switch (boxing) {
            case ("石头"):
                compare(boxing, value);
                break;
            case ("剪刀"):
                compare(boxing, value);
                break;
            case ("布"):
                compare(boxing, value);
                break;
            default:
                System.out.println("出拳错误!");
        }
    }


    /**
     * 动态改变输赢比较封装
     */
    public void compare(String name, int value) {
        if (ATTRIBUTE[0].equals(name)) {
            if (value == 0) {
                System.out.println(RESULT[2]);
            } else if (value == 1) {
                System.out.println(RESULT[0]);
                enemieScore += 1;
            } else if (value == 2) {
                System.out.println(RESULT[1]);
                friendScore += 1;
            }
        } else if (ATTRIBUTE[1].equals(name)) {
            if (value == 0) {
                System.out.println(RESULT[1]);
                friendScore += 1;
            } else if (value == 1) {
                System.out.println(RESULT[2]);
            } else if (value == 2) {
                System.out.println(RESULT[0]);
                enemieScore += 1;
            }
        } else if (ATTRIBUTE[2].equals(name)) {
            if (value == 0) {
                System.out.println(RESULT[0]);
                enemieScore += 1;
            } else if (value == 1) {
                System.out.println(RESULT[1]);
                friendScore += 1;
            } else if (value == 2) {
                System.out.println(RESULT[2]);
            }
        }

        if (friendScore == enemieScore) {
            friendResult = "平局";
            enemieResult = "平局";
        } else if (friendScore > enemieScore) {
            friendResult = "获胜";
            enemieResult = "败北";
        } else if (friendScore < enemieScore) {
            friendResult = "败北";
            enemieResult = "获胜";
        }
    }


    /**
     * 排行榜
     */
    public void rankingList() {
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("  ************************************************************************");
        System.out.println("   **********************************************************************");
        System.out.println("    ********************************************************************");
        System.out.println("     ******************************************************************");
        System.out.println("      ****************************************************************");
        System.out.println("       **************************************************************");
        System.out.println("        ************************************************************");
        System.out.println("        ************************************************************");
        System.out.println("        *           ***********************************            *");
        System.out.println("        *           ***********************************            *");
        System.out.println("        *           *          游戏结果公布           *            *");
        System.out.println("        *           ***********************************            *");
        System.out.println("        *           ***********************************            *");
        System.out.println("        ************************************************************");
        System.out.println("        *   姓名   *   年龄   *     段位     *  得分  *  最终结果  *");
        System.out.println("        ************************************************************");
        System.out.println("        * " + friends.getName() + " *   " + friends.getAge() + "     *   " + friends.getDuan() + "   *   " + friendScore + "    *   " + friendResult + "     *");
        System.out.println("        ************************************************************");
        System.out.println("        * " + enemies.getName() + " *   " + enemies.getAge() + "     *   " + enemies.getDuan() + "   *   " + enemieScore + "    *   " + enemieResult + "     *");
        System.out.println("        ************************************************************");
        System.out.println("        ************************************************************");
        System.out.println("       **************************************************************");
        System.out.println("      ****************************************************************");
        System.out.println("     ******************************************************************");
        System.out.println("    ********************************************************************");
        System.out.println("   **********************************************************************");
        System.out.println("  ************************************************************************");
    }
}
