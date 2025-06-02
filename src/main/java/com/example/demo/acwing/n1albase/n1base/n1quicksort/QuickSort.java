package com.example.demo.acwing.n1albase.n1base.n1quicksort;

import java.util.Arrays;

/**
 * 快速排序
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] q = new int[]{2, 5, 7, 0, 1, 4};
        System.out.println(Arrays.toString(q));
        quickSort(q, 0, 5);
        System.out.println(Arrays.toString(q));
    }

    public static void quickSort(int[] q, int l, int r) {
        if (l >= r) return;
        // 任意边界点
        int x = q[l];
        // 外扩一个，便于先++取第一个
        int i = l - 1, j = r + 1;
        while (i < j) {
            // 一直跳，直到找到符合条件的
            do i++; while (q[i] < x);
            do j--; while (q[j] > x);
            if (i < j) swap(q, i, j);
        }
        // 左边继续调整
        quickSort(q, l, j);
        // 右边继续调整
        quickSort(q, j + 1, r);

    }




    // 做算法操作组件化拆解，达到理解算法思想 记住边界情况，就能写出算法的地步


    // 数据值交换
    public static void swap(int[] q, int i, int j) {
        int tmp = q[i];
        q[i] = q[j];
        q[j] = tmp;
    }

    // 双指针遍历数组
    // 相同步进
    public static void doublePointerTraverse1(int[] q) {
        // 外扩一个，便于先++取第一个
        int i = -1;
        int j = q.length;
        while (i < j) {
            i++;
            j--;
            if (i < j) {
                System.out.println(q[i]);
                System.out.println(q[j]);
            }
        }
    }

    // 条件步进
    public static void doublePointerTraverse2(int[] q) {
        // 外扩一个，便于先++取第一个
        int i = -1;
        int j = q.length;
        boolean condition = false;
        while (i < j) {
            // 一直跳，直到找到符合条件的
            do i++; while (condition);
            do j--; while (condition);
            if (i < j) swap(q, i, j);
        }
    }

    // 打印数组
    public static void printArray(int[] q) {


    }


}
