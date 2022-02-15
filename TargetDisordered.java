package com.solutionDiary;

/*
2022/2/13
给定一个无序数组，找到目标target可以被数组中哪两个数加和表示，返回这两数的下标
假设每一个输入的答案都唯一，而且不使用相同的元素
 */

import java.util.Arrays;

public class TargetDisordered {
    // 方法：暴力求解
    public static int[] violent(int[] array, int target) {
        for (int i = 0; i < array.length; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i] + array[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[0];
    }

    // 主程序
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6};
        System.out.println(Arrays.toString(violent(array, 11)));
    }
}
