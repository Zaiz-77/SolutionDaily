package com.solutionDiary;

/*
2022/2/13
在不使用sqrt(x)函数的情况下，求得x的平方根的整数部分
 */

public class SqrtX {
    // 方法一：暴力检索
    public static int sqrt(double x) {
        if (x < 4) return 1;
        for (int i = 2; i < x; i++) {
            if (i * i == x) return i;
            else if (i * i < x && (i + 1) * (i + 1) > x) return i;
        }
        return 0;
    }

    // 方法二：二分法
    public static int binary(double x) {
        if (x < 4) return 1;
        double left = 2, right = x - 1;
        // 如果右侧比左侧大 就一直找
        while (right - left > 0) {
            double mid = (left + right) / 2;
            if (mid * mid == x) return (int) mid;
            if (mid * mid > x) right = mid;
            if (mid * mid < x) left = mid;
        }
        return (int) left;
    }

    // 方法三：牛顿迭代法
    public static int newton(double x) {
        if (x == 0) return 0;
        return (int) iterate(x, x);
    }

    public static double iterate(double i, double x) {
        double temp = (i + x / i) / 2;
        if (temp == i) {
            return i;
        } else {
            return iterate(temp, x);
        }
    }

    // 主程序
    public static void main(String[] args) {
        double x = 161;
        System.out.println(sqrt(x));
        System.out.println(binary(x));
        System.out.println(newton(x));
    }
}
