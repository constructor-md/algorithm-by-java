package com.example.demo.leetcode.sort;

/**
 * TopK问题
 * 快速排序解法
 *
 * 快速排序思路：
 * 将数组分成两半，一半均大于a[i]，另一半均小于a[i]，a[i]可随机取一般取第一个
 * 递归调用快排，分别对两个数组进行排序
 * 直到最后两个数组自然有序，不需要合并
 */
public class FindKthLargestByQuickSort {

    public int findKthLargest(int[] nums, int k) {
        quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }
    public void quickSort(int[] nums, int left, int right) {

        if (left < right) {
            //数组分块
            int aIndex = partition(nums, left, right);
            //将基准元素左边的内容递归排序 基准元素自身不参与，已经有序
            quickSort(nums, left, aIndex - 1);
            //将基准元素右边的内容递归排序 基准元素自身不参与，已经有序
            quickSort(nums, aIndex + 1, right);
        }


    }

    public static int partition(int[] nums, int left, int right) {

        //选取第一个作为基准元素
        int a = nums[left];

        while (left < right) {
            //向右移动，直到遇见小于a的元素
            while (left < right && nums[right] >= a) {
                right--;
            }
            //右指针停下，将值交给左指针 挖空法，现在右指针值可以为空，等待移交
            nums[left] = nums[right];

            //向左移动，直到遇见大于a的元素
            while (left < right && nums[left] < a) {
                left++;
            }
            //左指针停下，将值交给右指针，左指针挖空，等待移交
            nums[right] = nums[left];
        }
        //左右指针相遇，即相等  将最开始丢失了的基准元素，交给中间的位置，因为每一步的结果都是留下一个空位，所以可以直接赋值
        nums[left] = a;
        //返回区分点的索引
        return left;
    }

    public static void main(String[] args) {
        FindKthLargestByQuickSort findKthLargestByQuickSort = new FindKthLargestByQuickSort();
        int[] nums = {3,2,1,5,6,4};
        int result = findKthLargestByQuickSort.findKthLargest(nums, 2);
        System.out.println(result);
    }


}
