package com.example.demo.leetcode.doublepointer;

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
        //双指针
        int maxIndex = nums.length - 1;
        if(maxIndex == -1) {
            return 0;
        }
        int i = 0;
        //i指向最后不是的那个索引的后面，n向前遍历。n找到不是的数，就把这个数给i，然后i++，n遍历完后
        //输出i作为有效长度，因为i已经在上次经历了++
        for(int n = 0; n <= maxIndex; n++) {
            //如果是则n往后，不是则两者往后
            if(val != nums[n]) {
                nums[i] = nums[n];
                i++;
            }
        }
        return i;
    }


}
