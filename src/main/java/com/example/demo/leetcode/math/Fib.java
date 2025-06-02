package com.example.demo.leetcode.math;

/**
 * 509
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 */
public class Fib {

    public static void main(String[] args) {
        System.out.println(fib(8));
    }

    public static int fib(int n) {
        // 递归会出现重复计算。浪费时间
        if(n < 2) return n;
        if(n == 2) return 1;
        int pre1 = 0;
        int pre2 = 1;
        int now = 1;
        for(int i = 3; i <= n; i++) {
            int temp = now;
            now = pre2 + now;
            pre1 = pre2;
            pre2 = temp;
        }
        return now;
    }
}
