package com.example.demo.leetcode.arr;

import java.util.Arrays;

public class RemoveArrDuplicated2 {


    public static void main(String[] args) {
        // 删除有序数组中的重复项 II
        int[] arr = new int[]{1,2,2};

        // 双指针
        int i = 0;
        int num = 1;
        for (int j = 1; j < arr.length; j++) {
            if (arr[i] == arr[j]) {
                if (num < 2) {
                    num++;
                    i++;
                    arr[i] = arr[j];
                }
            } else {
                num = 1;
                i++;
                arr[i] = arr[j];
            }
        }

        System.out.println(i);
        System.out.println(Arrays.toString(arr));
    }
}
