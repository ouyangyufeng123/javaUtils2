package com.yf.reptile;

import java.math.BigDecimal;
import java.util.*;

public class TestMain {

    /**
     * 定义红包个数
     */
    private static int redPackNum = 5;

    /**
     * 定义红包总金额
     */
    private static int redPackMoney = 1;


    public static void main(String[] args) {
        List<BigDecimal> moneys = math(BigDecimal.valueOf(redPackMoney), redPackNum);
        System.out.println(redPackNum+"个红包已发出,总金额"+redPackMoney+"!请输入1开始抢红包");
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        int money2 = rand.nextInt(redPackNum);
        scan.nextInt();
        System.out.println("支付宝到账"+moneys.get(money2)+"元!还剩金额:"+(redPackMoney-moneys.get(money2).intValue()));
//        if (moneys != null) {
//            BigDecimal b = new BigDecimal(0);
//            for (BigDecimal bigDecimal : moneys) {
//                System.out.print(bigDecimal + "元    ");
//                b = b.add(bigDecimal);
//            }
//            System.out.print("   总额：" + b + "元 ");
//            System.out.println();
//        }
    }

    /**
     * 计算每人获得红包金额;最小每人0.01元
     *
     * @param mmm    红包总额
     * @param number 人数
     * @return
     */
    public static List<BigDecimal> math(BigDecimal mmm, int number) {
        if (mmm.doubleValue() < number * 0.01) {
            return null;
        }
        Random random = new Random();
        // 金钱，按分计算 10块等于 1000分
        int money = mmm.multiply(BigDecimal.valueOf(100)).intValue();
        // 随机数总额
        double count = 0;
        // 每人获得随机点数
        double[] arrRandom = new double[number];
        // 每人获得钱数
        List<BigDecimal> arrMoney = new ArrayList<BigDecimal>(number);
        // 循环人数 随机点
        for (int i = 0; i < arrRandom.length; i++) {
            int r = random.nextInt((number) * 99) + 1;
            count += r;
            arrRandom[i] = r;
        }
        // 计算每人拆红包获得金额
        int c = 0;
        for (int i = 0; i < arrRandom.length; i++) {
            // 每人获得随机数相加 计算每人占百分比
            Double x = new Double(arrRandom[i] / count);
            // 每人通过百分比获得金额
            int m = (int) Math.floor(x * money);
            // 如果获得 0 金额，则设置最小值 1分钱
            if (m == 0) {
                m = 1;
            }
            // 计算获得总额
            c += m;
            // 如果不是最后一个人则正常计算
            if (i < arrRandom.length - 1) {
                arrMoney.add(new BigDecimal(m).divide(new BigDecimal(100)));
            } else {
                // 如果是最后一个人，则把剩余的钱数给最后一个人
                arrMoney.add(new BigDecimal(money - c + m).divide(new BigDecimal(100)));
            }
        }
        // 随机打乱每人获得金额
        return arrMoney;
    }
}
