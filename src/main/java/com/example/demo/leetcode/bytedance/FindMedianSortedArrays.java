package com.example.demo.leetcode.bytedance;

import java.util.LinkedList;

/**
 * leetcode 4 寻找两个正序数组的中位数
 * <p>
 * 给定两个元素量分别为m和n的正序数组，找到两个数组的中位数
 * 中位数：顺序排列中处于中间位置的数，如果总数是偶数，中位数是中间两数的平均值
 * <p>
 * 求出合并数组后的中位数下标
 * 双指针合并数组，直到下标位置，可得中位数
 * 如果是偶数，求mid和mid+1的中位数
 * 如果是奇数，mid所在就是中位数
 */
public class FindMedianSortedArrays {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        //排除总元素填不满temp的位置导致越界的情况
        if (m == 0 && n == 1) {
            return nums2[0];
        }
        if (n == 0 && m == 1) {
            return nums1[0];
        }

        boolean even = false;
        int mid = (m + n) / 2 + 1;
        if ((m + n) % 2 == 0) {
            even = true;
            mid--;
        }
        //数组最多合并到mid+1即可，甚至不用存，最多只记录前一个数
        int i = 0, j = 0, num = 0;
        LinkedList<Integer> temp = new LinkedList<>();
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                temp.add(nums1[i]);
                i++;
            } else {
                temp.add(nums2[j]);
                j++;
            }
            if (temp.size() > 2) {
                temp.removeFirst();
            }
            num++;
            //如果是奇数，mid + 1所在就是中位数
            if (!even && num == mid) {
                return temp.get(1);

            } else if (even && num == mid + 1) {
                //如果是偶数，求mid和mid+1的中位数
                return (double) (temp.get(1) + temp.get(0)) / 2;
            }
        }

        //i到头，继续遍历j
        if (i == m) {
            for (int index = j; index < n; index++) {
                temp.add(nums2[index]);
                num++;
                if (temp.size() > 2) {
                    temp.removeFirst();
                }
                //如果是奇数，mid所在就是中位数
                if (!even && num == mid) {
                    return temp.get(1);
                } else if (even && num == mid + 1) {
                    //如果是偶数，求mid和mid+1的中位数
                    return (double) (temp.get(1) + temp.get(0)) / 2;
                }
            }
        }
        //i到头，继续遍历i
        if (j == n) {
            for (int index = i; index < m; index++) {
                temp.add(nums1[index]);
                num++;
                if (temp.size() > 2) {
                    temp.removeFirst();
                }
                //如果是奇数，mid所在就是中位数
                if (!even && num == mid) {
                    return temp.get(1);
                } else if (even && num == mid + 1) {
                    //如果是偶数，求mid和mid+1的中位数
                    return (double) (temp.get(1) + temp.get(0)) / 2;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        FindMedianSortedArrays findMedianSortedArrays = new FindMedianSortedArrays();
        int[] nums1 = {1};
        int[] nums2 = {3, 4};
        System.out.println(findMedianSortedArrays.findMedianSortedArrays(nums1, nums2));
    }


}
