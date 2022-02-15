package com.solutionDiary;

/*
2022/2/14
返回斐波那契数列第N位的数值
 */

public class Fibonacci {
    // 解法一： 递归
    public static int recursion(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        return recursion(n - 1) + recursion(n - 2);
    }

    // 解法二：递推
    public static int loop(int n){
        if(n == 0) return 0;
        if(n == 1) return 1;
        int a = 0, b = 1, temp = 0;
        for (int i = 2; i <= n; i++){
            temp = a + b;
            a = b;
            b = temp;
        }
        return temp;
    }

    // 主程序
    public static void main(String[] args) {
        System.out.println(recursion(10));
        System.out.println(loop(10));
    }
}
