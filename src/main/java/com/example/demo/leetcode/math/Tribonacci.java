package com.example.demo.leetcode.math;

/**
 * 1137 第N个泰波那契数
 * 泰波那契序列 Tn 定义如下：
 *
 * T0 = 0, T1 = 1, T2 = 1, 且在 n >= 0 的条件下 Tn+3 = Tn + Tn+1 + Tn+2
 *
 * 给你整数 n，请返回第 n 个泰波那契数 Tn 的值。
 */
public class Tribonacci {

    public static void main(String[] args) {
        System.out.println(tribonacci(25));
    }


    public static int tribonacci(int n) {
        // 递归会出现重复计算。浪费时间
        if (n < 2) return n;
        if (n == 2) return 1;
        int pre2 = 1;
        int pre1 = 1;
        int now = 2;
        for(int i = 4; i <= n; i++) {
            int temp = now;
            now = pre1 + pre2 + now;
            pre2 = pre1;
            pre1 = temp;
        }
        return now;
    }

}
