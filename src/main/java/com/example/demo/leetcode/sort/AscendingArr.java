package com.example.demo.leetcode.sort;

/**
 * 将给定的数组升序排列
 */
public class AscendingArr {

    public static void main(String[] args) {

        int[] nums = {2,3,4,1,3};
        mergeSort(nums, 0, nums.length - 1);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }

    public static void mergeSort(int[] nums, int left, int right){

        if (left < right) {
            int mid = left + ((right - left) >> 1);
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }

    }

    public static void merge(int[] nums, int left, int mid, int right) {
        //right - left是元素的差，+1才包含开头元素 成为数组的长度
        int[] tempArr = new int[right - left + 1];
        int temp1 = left, temp2 = mid + 1;
        int index = 0;
        while(temp1 <= mid && temp2 <= right) {

            if (nums[temp1] >= nums[temp2]) {
                tempArr[index] = nums[temp1];
                temp1++;
            } else {
                tempArr[index] = nums[temp2];
                temp2++;
            }
            index++;
        }

        //=防止遗漏
        if (temp1 <= mid) {
            System.arraycopy(nums, temp1, tempArr, index, mid - temp1 + 1);
        }
        if (temp2 <= right) {
            System.arraycopy(nums, temp2, tempArr, index, right - temp2 + 1);
        }

        System.arraycopy(tempArr, 0, nums, left, right - left + 1);


    }


}
