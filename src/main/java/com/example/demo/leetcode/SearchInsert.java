package com.example.demo.leetcode;

/**
 * leetcode 35 搜索插入位置
 * 要求使用logn的算法，考虑二分查找
 * nums是无重复元素的升序数组，返回结果是数组下标
 */
public class SearchInsert {

    public int searchInsert(int[] nums, int target) {

        int i = 0;
        int j = nums.length - 1;
        while (i < j) {
            int mid = (i + j) / 2;
            if (target < nums[mid]) {
                j = mid;
            } else if (target > nums[mid]) {
                i = mid + 1;
            } else {
                //等于的情况下插到左边，即占据当前位置
                return mid;
            }
        }
        //没找到即跳出循环，此时 i == j，且不知道当前位置比所需数大还是小
        if (nums[i] < target) {
            //如果当前位置比target小，插入到右边
            return i + 1;
        } else {
            //否则插入到左边
            return i;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        SearchInsert searchInsert = new SearchInsert();
        System.out.println(searchInsert.searchInsert(nums, 7));
    }
}
