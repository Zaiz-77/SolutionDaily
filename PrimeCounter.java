package com.solutionDiary;

/*
2022/2/12
统计n以内素数的个数
素数：除了1和自身没有别的因数的数
例如：
n = 100
输出：25
说明：1 - 100以内有25个素数
 */

public class PrimeCounter {
    // 方法一： 暴力求解法
    // 判断是否是素数
    public static boolean isPrime(int x) {
        boolean flag = true;
        for (int i = 2; i <= Math.sqrt(x); i++) {
            if (x % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    // 计数
    public static int counter(int n) {
        int count = 0;
        if (n == 1) return 0;
        // 暴力筛选如果是 则＋1
        for (int i = 2; i <= n; i++) {
            if (isPrime(i)) count++;
        }
        return count;
    }

    // 方法二： 埃氏筛选法
    public static int Eratosthenes(int n) {
        if (n == 1) return 0;
        int count = 0;
        // 申请多一个空间就可以判断n是不是，题解认为不包含n，本人包含n，所以加1
        boolean[] notPrime = new boolean[n + 1]; //false代表素数
        for (int i = 2; i <= n; i++) {
            if (!notPrime[i]) {
                count++;
                for (int j = 2 * i; j <= n; j += i) {
                    notPrime[j] = true;
                }
            }
        }
        return count;
    }

    // 主程序
    public static void main(String[] args) {
        int num = 100;
        System.out.println(counter(num));
        System.out.println(Eratosthenes(num));
    }
}
