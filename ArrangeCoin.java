package com.solutionDiary;

/*
2022/2/14
总共有n枚硬币，将他们排成阶梯状，第k行必须要有k枚硬币
找出可形成完整阶梯行的总行数
 */

public class ArrangeCoin {
    // 解法：也即求 (1 + m) m / 2 = n 方程的最大整数解
    public static int function(int n){
        return (int) ((Math.sqrt(1 + 8 * n) - 1) / 2);
    }

    // 主程序
    public static void main(String[] args) {
        System.out.println(function(10));
    }
}
