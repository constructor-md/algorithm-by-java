package com.example.demo.leetcode.doublepointer;

/**
 * leetcode 1 两数之和
 * 给定值和无序数组，找到数组中符合两数之和位给定值的两个数
 */
public class TwoNums {

    public int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        //枚举
        for (int i = 0; i <= nums.length - 1; i++) {
            for (int j = i + 1; j <= nums.length - 1; j++) {
                if (nums[i] + nums[j] == target) {
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }
        return arr;
    }
}
