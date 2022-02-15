package com.solutionDiary;

/*
2022/2/13
给定一个整型数组，返回由数组中的三个数的乘积的最大值
提示：乘积不会越界
 */

public class MaxProduct {
    // 解法一：随便找到可以排出前三位最大值的排序算法即可，然后直接相乘
    // 自己想到的，但是只针对全是正数或者全是负数的数组
    // 优化：再补充两趟排序即可,找到最小的两项
    public static int sort(int[] array) {
        int temp;
        int n = array.length;
        int max1, max2, max3, min1, min2;
        // 冒泡排序进行三趟,将最大的先置于队尾
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        max3 = array[n - 1];
        max2 = array[n - 2];
        max1 = array[n - 3];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
        min1 = array[n - 1];
        min2 = array[n - 2];
        return Math.max(max3 * min2 * min1, max3 * max1 * max2);
    }

    // 解法二：线性扫描,类似于选择排序的贴标签
    public static int linearSweep(int[] array) {
        // 先随便指定两个最小的和三个最大的
        int min1 = array[0], min2 = array[1];
        int max1 = array[0], max2 = array[1], max3 = array[2];
        // 进行更新
        for (int x : array) {
            // 找最小的两个数
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }
            // 找最大的三个数
            if (x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max3 = max2;
                max2 = x;
            } else if (x > max3) {
                max3 = x;
            }
        }
        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    // 主程序
    public static void main(String[] args) {
        int[] array = {1, 2, 6, -9, -6, -6};
        System.out.println(sort(array));
        System.out.println(linearSweep(array));
    }
}
