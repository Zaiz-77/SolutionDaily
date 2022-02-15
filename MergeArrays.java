package com.solutionDiary;

/*
2022/2/15
合并两个有序数组，给定两个有序数组num1和num2，将后者合并到前者
使num1成为一个新的有序数组,这里表明不能开辟新空间
假设num1的空间足够大能够容纳两者的全部元素 而且初始化时 num1的元素多余num2
 */

import java.util.Arrays;

public class MergeArrays {
    // 解法一：无脑暴力算法：合并加排序
    public static void violent(int[] num1, int m, int[] num2, int n) {
        // 这里涉及到一个API：数组拷贝，（待拷贝数组，初始位置，拷贝目标数组，目标数组开始拷贝的位置，元素数量）
        System.arraycopy(num2, 0, num1, m, n);
        Arrays.sort(num1);
    }

    // 解法二：双指针 空间换时间 最差最后一点的优化问题
    public static void doublePointer(int[] num1, int m, int[] num2, int n) {
        int[] temp = new int[m + n];
        int ptr1 = 0, ptr2 = 0;
        int i = 0;
        while (ptr1 < m && ptr2 < n) {
            if (num1[ptr1] < num2[ptr2]) {
                temp[i] = num1[ptr1];
                ptr1++;
            } else {
                temp[i] = num2[ptr2];
                ptr2++;
            }
            i++;
        }
        // 使用到这些拷贝的方法
        if(ptr1 < m) System.arraycopy(num1, ptr1, temp, ptr1 + ptr2, m + n - ptr1 - ptr2);
        if(ptr2 < n) System.arraycopy(num2, ptr2, temp, ptr1 + ptr2, m + n - ptr1 - ptr2);

        System.arraycopy(temp, 0, num1, 0, m + n);
    }

    // 解法三：原地双指针,理解起来比上一个方便太多，而且不需要任何API
    public static void inPlaceDouble(int[] num1, int m, int[] num2, int n){
        // 反向遍历，因为考虑到第二种方法是因为原来的地方有值，才不可以直接赋值，而是拷贝数组，这里避免了这个问题
        int ptr1 = m - 1, ptr2 = n - 1;
        int temp = m + n - 1;
        while (ptr1 >= 0 && ptr2 >= 0){
            if(num1[ptr1] > num2[ptr2]){
                num1[temp] = num1[ptr1];
                ptr1--;
            }else {
                num1[temp] = num2[ptr2];
                ptr2--;
            }
            temp--;
        }
    }

    // 主程序
    public static void main(String[] args) {
        int[] num1 = new int[]{1, 3, 6, 7, 9, 19, 0, 0, 0, 0};
        int[] num2 = new int[]{12, 14, 16, 18};
        violent(num1, 6, num2, 4);
        doublePointer(num1, 6, num2, 4);
        inPlaceDouble(num1, 6, num2, 4);
        System.out.println(Arrays.toString(num1));
    }
}
