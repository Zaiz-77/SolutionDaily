package com.solutionDiary;

/*
2022/2/13
给定一个有序数组，找到目标target可以被数组中哪两个数加和表示，返回这两数的下标
假设每一个输入的答案都唯一，而且不使用相同的元素
 */

import java.util.Arrays;

public class TargetOrdered {
    // 解法：双指针
    public static int[] doublePointer(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left < right) {
            if (array[left] + array[right] > target) {
                right--;
            } else if (array[left] + array[right] < target) {
                left++;
            } else {
                return new int[]{left, right};
            }
        }
        return new int[0];
    }

    // 主程序
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 15};
        System.out.println(Arrays.toString(doublePointer(array, 11)));
    }
}
