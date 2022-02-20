package com.solutionDiary;

/*
2022/2/20
最大周长三角形
给定一个数组，在其中选择能形成的最大三角形的周长
如果无法形成，返回0
 */

import java.util.Arrays;

public class Triangle {
    // 解法一：贪心,每一次都选最大的三条边
    public static int cupidity(int[] array) {
        Arrays.sort(array);
        for (int i = array.length - 1; i >= 2; i--) {
            if (array[i] < array[i - 1] + array[i - 2]) {
                return array[i] + array[i - 1] + array[i - 2];
            }
        }
        return 0;
    }

    // 主程序
    public static void main(String[] args) {
        int[] array = {1563, 4116, 851, 3541, 3541};
        System.out.println(cupidity(array));
    }
}
