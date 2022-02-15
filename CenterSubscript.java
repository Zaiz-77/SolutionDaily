package com.solutionDiary;

/*
2022/2/13
给定一个数组，返回该数组的中心下标；若不存在，则返回-1
中心下标是数组的一个下标，它左侧所有元素的和等于右侧所有元素的和
注意：可以出现在数组两端
 */

public class CenterSubscript {
    // 解法：双指针，左右同时遍历
    public static int centerSubscript(int[] array) {
        // 定义两个指针 和两侧的求和
        int left = 0, right = array.length - 1;
        int leftSum = array[left], rightSum = array[right];
        // 左右指针没相遇之前，进行循环
        while (left < right) {
            if (leftSum > rightSum) {
                right -= 1;
                rightSum += array[right];
            } else if (leftSum < rightSum) {
                left += 1;
                leftSum += array[left];
            } else {
                right -= 1;
                left += 1;
                rightSum += array[right];
                leftSum += array[left];
            }
        }
        // 判断是否有中心下标
        if (leftSum == rightSum && left <= right) return left;
        else return -1;
    }

    // 解法二：加到总和的一半就退出循环
    public static int mathSolution(int[] array) {
        // 求总和
        int sum = 0;
        for (int i : array) {
            sum += i;
        }
        // 求解问题
        int tempSum = 0;
        for(int j = 0; j < array.length - 1; j++){
            tempSum += array[j];
            if(tempSum * 2 == sum - array[j + 1]){
                return j + 1;
            }
        }
        return -1;
    }

    // 主程序
    public static void main(String[] args) {
        int[] array = {1, 7, 3, 8, 3, 6};
        System.out.println(centerSubscript(array));
        System.out.println(mathSolution(array));
    }
}
