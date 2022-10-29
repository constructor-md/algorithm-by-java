package com.example.demo.leetcode.doublepointer;

/**
 * leetcode 合并两个有序数组
 * 给定两个数组为非递减顺序，可能升序，可能等
 * 两个数组元素量分别为m,n。
 * 要求将数组二合并到数组一，数组一长度为m+n
 *
 * 双指针遍历两个数组，遍历数组1时，如果发现当前数不如数组二当前数小，则交换位置，数组二的新数据需要冒泡到指定位置，复杂度变为m*n
 *
 * 将num1内容复制到数组末尾，然后开始双指针遍历两个有内容的区域，先放小的然后指针后退，复杂度则为m+n
 *
 */
public class MergeArrays {

    public void merge(int[] nums1, int m, int[] nums2, int n) {

        //将nums1有内容的部分复制到数组尾
        int tail = nums1.length - 1;
        for (int i = m - 1; i >= 0; i--) {
            nums1[tail] = nums1[i];
            tail--;
        }

        //双指针遍历两个内容区，放到数组头部，被放置的内容的指针移动
        int point1 = tail + 1;
        int point2 = 0;
        int content = 0;
        while (content < m + n && point1 < m + n && point2 < n) {
            if (nums1[point1] < nums2[point2]) {
                nums1[content] = nums1[point1];
                content++;
                point1++;
            } else if (nums1[point1] > nums2[point2]) {
                nums1[content] = nums2[point2];
                content++;
                point2++;
            } else if (nums1[point1] == nums2[point2]) {
                nums1[content] = nums1[point1];
                content++;
                point1++;

                nums1[content] = nums2[point2];
                content++;
                point2++;
            }
        }

        //如果其中一个被遍历完，则另一个直接加入

        //如果n被遍历完则不做变化，已经有序，因为m大的都在后面
        //如果m被遍历完，则把n剩下的内容放到现在的内容区后面
        if (point1 >= m + n) {
            while (point2 < n) {
                nums1[content] = nums2[point2];
                content++;
                point2++;
            }
        }


    }


    public static void main(String[] args) {

        MergeArrays mergeArrays = new MergeArrays();
        int[] nums1 ={1,2,3,0,0,0};
        int m = 3;
        int[] nums2 ={2,5,6};
        int n = 3;
        mergeArrays.merge(nums1, m, nums2, n);

        System.out.println();
    }


}
