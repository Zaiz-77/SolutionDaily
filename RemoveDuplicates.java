package com.solutionDiary;

/*
2022/2/12
删除有序数组中的重复项目，并返回不重复部分的长度
要求在原地实现
例如：
输入：1 2 2 3 6 7
输出：5
 */

public class RemoveDuplicates {
    // 解法：双指针
    public static int removeDuplicate(int[] array) {
        int n = array.length;
        int i = 0, j = 1;
        while (j < n) {
            // 如果不重复，就把快指针的值给到慢指针的下一个
            if (array[i] != array[j]) {
                array[i + 1] = array[j];
                //迭代 + 计数
                i++;
            }
            j++;
        }
        return i + 1;
    }

    // 主程序
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 3, 6, 7};
        int answer = removeDuplicate(arr);
        System.out.println(answer);
    }
}
