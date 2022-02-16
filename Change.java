package com.solutionDiary;

/*
2022/2/16
柠檬水找零问题
你是柠檬水的摊主，每杯5美元，顾客一次只买一杯，而且只会给你5，10，20美元
起初你没有任何零钱
对于一个购买者序列，如果能找零，返回true，否则返回false
 */

public class Change {
    // 解法：贪心，明确找钱只能用5或者10来找，所以最后判断是5和10是否非负
    public static boolean cupidity(int[] bills) {
        int fiveCount = 0;
        int tenCount = 0;
        // 第一张如果不是5，一定找不开
        if (bills[0] == 10 || bills[0] == 20) return false;
        // 如果不是 则进入循环
        for (int bill : bills) {
            // 收到5美元，只能收下，让5美元多一张
            if (bill == 5) {
                fiveCount++;
            }
            // 收到10美元，只能找5美元，一增一减
            else if (bill == 10) {
                fiveCount--;
                tenCount++;
            }
            // 收到20美元，首选用10美元和5美元找钱，否则用5美元找钱
            else {
                if (fiveCount > 0 && tenCount > 0) {
                    fiveCount--;
                    tenCount--;
                } else {
                    fiveCount -= 3;
                }
            }
        }
        return fiveCount >= 0 && tenCount >= 0;
    }

    // 主程序
    public static void main(String[] args) {
        int[] bills = {5, 5, 20};
        System.out.println(cupidity(bills));
    }
}
