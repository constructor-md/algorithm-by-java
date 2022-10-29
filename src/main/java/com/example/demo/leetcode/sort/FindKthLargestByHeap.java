package com.example.demo.leetcode.sort;

/**
 * leetcode 215 数组中第k个最大元素
 * 面试高频TopK问题
 * 即升序排序后，不用去重的，倒数第k个元素
 * 要求算法时间复杂度O(n)
 * 堆排序解法
 *
 * ａ＾ｂ—— a的b的次方 （计算机常用，无需多言）
 * int_UP（）—— 向上取整（即去掉浮点数的小数部分，然后将整数部分加1）
 * int_DOWN（）—— 向下取整（即去掉浮点数的小数部分，只留整数部分）
 * log(a,b) —— 表示以a为底取b的对数
 *
 * 二叉树的性质：
 * 性质一：
 *  第i层上最多有2^(i - 1)个节点，i>=1
 *
 * 性质二：
 *  深度为k(k>=0)的二叉树最少有k个节点，最多有2^k - 1个节点
 *
 * 性质三：
 *  对于任一棵非空二叉树，若其节点数为n0，度为2的非叶节点数为n2，则n0 = n2 + 1
 *  (度为2指的是每个节点最多只能有两棵子树，并至少有一个节点有两棵子树。二叉树要求度不超过2，可以是0或1，即节点最多有两个叉)
 *
 * 性质四：
 *  具有n个节点的完全二叉树的深度为int_UP(log(2, n+1))
 *
 * 性质五：
 *  对一个有n个节点的完全二叉树的节点按层序编号(从1开始)，对任意节点i有：
 *      如果i = 1 节点i是完全二叉树的根节点，无父节点。如果 i > 1，其父节点为 i / 2
 *      如果2i < n 节点i的左子女为节点 2i,右子女为2i+1
 *      若i为奇数，且i!=1，它处于右兄弟位置，左兄弟节点为i-1
 *      若i为偶数，且i!=n，它处于左兄弟位置，左兄弟节点为i+1
 *      节点i所在层为：int_DOWN(log(2, i)) + 1
 *
 * 完全二叉树的定义：
 *  设二叉树的深度为h，除第h层外，其他各层的节点数都达到最大值，且h层的节点连续集中在左边
 *
 *  满二叉树则是把最后一层也填满
 *
 * 堆排序的过程：
 *  将输入的数组视为一个堆，即视为一个完全二叉树，最后一层不满也是完全二叉树
 *  堆排序的思路是，将整个堆调整为大顶堆，然后和最后一个节点交换，然后把剩下的调整为大顶堆，和最后一个节点交换。以此类推，得到降序排列的序列。
 *  最开始，从叶子节点开始。由于可以将叶子节点视为已经排好序的堆，所以可以什么也不做直接略过。
 *  于是从第一个非叶子节点开始。对于一颗完全二叉树来说，第一个非叶子节点是n / 2，第二个则是n / 2 - 1以此类推
 *  找到非叶子节点后，其左右节点分别为 2i和2i+1 根据大顶堆的要求，将父节点弄成最大。以此类推整理每个非叶子节点
 *
 */
public class FindKthLargestByHeap {

    public int findKthLargest(int[] nums, int k) {
        sort(nums);
        return nums[nums.length - k];
    }

    public void sort(int[] nums) {

        //第一次建堆,此后，数组头为最大值
        heapAdjust(nums, 1, nums.length);

        //最大值和末尾值交换位置，然后继续建立大根堆
        swap(nums, 0, nums.length - 1);

        //i为需要调整堆的末节点的序号，是数组的序号+1，因为堆从1开始计数
        for (int i = nums.length - 1; i >= 1; i--) {
            heapAdjust(nums, 1, i);
            swap(nums, 0, i - 1);
        }

    }


    //对数组建大根堆，使得数组的头为根节点  传入的start和end是从1开始的序号，start总是第一个，end直接代表长度
    public void heapAdjust(int[] nums, int start, int end) {
        //第一次建大根堆，从第一个非叶子节点开始逐步从后往前调整大根堆
        for (int i = end / 2; i >= start; i--) {
            //判断左右子节点存在，并调整位置
            int left = 2 * i;
            int right = 2 * i + 1;
            //如果右子节点存在，则判断左右子节点，否则仅判断左子节点
            if ( 2 * i + 1 <= end) {
                if (nums[right - 1] > nums[left - 1]) {
                    swap(nums, right - 1, left - 1);
                }
            }
            if (nums[left - 1] > nums[i - 1]) {
                swap(nums, left - 1, i - 1);
            }
        }
    }


    //交换数组中两个位置的元素
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        FindKthLargestByHeap findKthLargestByHeap = new FindKthLargestByHeap();
        int[] nums = {3,2,1,5,6,4};
        int result = findKthLargestByHeap.findKthLargest(nums, 2);
        System.out.println(result);
    }


}
