package com.example.demo.leetcode;

import java.util.Arrays;

/**
 * @author huangz
 * @date 2021/6/20 21:27
 */
public class RemoveElement {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 5, 5, 6, 7, 8};
        int length = removeElement(input, 3);
        System.out.println(length);
        System.out.println(Arrays.toString(input));
    }

    public static int removeElement(int[] nums, int val) {
        //与移出重复元素的题相似，一次遍历双指针即可解决

        int maxIndex = nums.length - 1;
        if(maxIndex == -1) {
            return 0;
        }
        int i = 0;
        for(int n = 0; n <= maxIndex; n++) {
            if(val != nums[n]) {
                if ((i + 1) > maxIndex) {
                    return i + 1;
                }
                if (i == n) {
                    nums[i] = nums[n];
                } else {
                    nums[i+1] = nums[n];
                }

                i ++;
            }
        }
        return i + 1;
    }


}
