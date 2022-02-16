package com.solutionDiary;

/*
2022/2/16
最长连续递增序列
给定一个未经排序的数组，返回最长且连续递增的子序列，并返回该序列的长度
注意：序列的下标是连续的
 */

public class IncrementingSequence {
    // 解法：贪心算法
    public static int cupidity(int[] array) {
        int start = 0;
        int max = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] >= array[i + 1]) {
                max = Math.max(max, i - start + 1);
                start = i + 1;
            }
        }
        // 防止指针跑到最后依然是递增，那就无法进入if,最大值也无法改变
        max = Math.max(max, array.length - 1 - start + 1);
        return max;
    }

    // 主程序
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 2, 5, 6, 7, 8, 1, 2, 3, 4, 5, 6, 7};
        System.out.println(cupidity(array));
    }
}
