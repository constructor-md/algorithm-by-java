package com.example.demo.leetcode.normal;

/**
 * leetcode 1752 检查数组是否经排序和轮转得到
 *
 * 给定数组nums，它的源数组所有元素和nums相同，但是按非递减顺序排列
 * 如果nums能够由源数组轮转若干位置，包括0，得到，则返回true，否则返回false
 * 源数组可能存在重复项
 *
 * 数组A经过轮转x个位置后，可以得到长度相同的数组B，前提是满足A[i] = B[(i+x) % A.length]
 * 即轮转就是平移元素x位，遇到末尾就从头轮转
 *
 * 源数组是非严格递增的数组，只需要判断源数组是否能平移数据得到nums
 * 可以找到最小的数，然后从该处开始遍历数组全部元素，所有元素必须保持升序或相等
 *
 */
public class CheckNums {


    public boolean check(int[] nums) {


        //找到第一个表现出递减的索引
        int breakIndex = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                breakIndex = i;
                break;
            }
        }

        //从第一个递减索引开始判断有序
        for (int i = breakIndex; i < breakIndex + nums.length; i++) {
            int realIndex = i % nums.length;
            int realIndexNext = (i + 1) % nums.length;
            if (realIndexNext == breakIndex) {
                break;
            }
            if (nums[realIndex] > nums[realIndexNext]) {
                return false;
            }
        }
        return true;
    }

}
