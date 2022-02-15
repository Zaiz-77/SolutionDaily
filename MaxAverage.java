package com.solutionDiary;

/*
2022/2/15
求数组的长度为k的连续子数组的最大平均数
 */

public class MaxAverage {
    // 解法一：双指针 滑动窗口
    public static double slideWindow(int[] array, int k) {
        int left = 0;
        int right = k - 1;
        int temp = 0;
        // 计算第一个窗口的总和
        for (int i = left; i <= right; i++) {
            temp += array[i];
        }
        // 进入循环开始判断
        while (right < array.length - 1) {
            temp = Math.max(temp, temp + array[right + 1] - array[left]);
            right++;
            left++;
        }
        return (double) temp / k;
    }

    // 主程序
    public static void main(String[] args) {
        int[] array = {1, 12, -5, -6, 50, 9999};
        System.out.println(slideWindow(array, 4));
    }
}
