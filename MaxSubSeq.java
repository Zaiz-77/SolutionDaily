package com.solutionDiary;

/*
2022/2/19
最大子序列和
返回给定数组的最大子序列和
子序列：下标需要连续
 */

import java.util.Arrays;

public class MaxSubSeq {
    // 解法一：数学
    public static int math(int[] array) {
        // 只要大于零，说明它对我们求和就是有贡献的
        int[] temp = new int[array.length];
        temp[0] = array[0];
        for (int i = 1; i < array.length; i++) {
            if (temp[i - 1] >= 0) {
                temp[i] = temp[i - 1] + array[i];
            } else {
                temp[i] = array[i];
            }
        }
        return Arrays.stream(temp).max().getAsInt();
    }

    // 解法二：贪心
    public static int cupidity(int[] array) {
        int ans = 0;
        int temp = 0;
        for (int x : array) {
            temp += x;
            // 也就是说，如果加完结果变大了，那我就把它先给ans
            // 但也不是说不大于就直接否定，因为后面还有可能加上变大的，只有它小于0时，才直接否定
            if (temp >= ans) {
                ans = temp;
            } else if (temp < 0) {
                temp = 0;
            }
        }
        return ans;
    }

    // 主程序
    public static void main(String[] args) {
        int[] array = {-2, 11, -4, 13, -2, -3};
        System.out.println(math(array));
        System.out.println(cupidity(array));
    }
}
