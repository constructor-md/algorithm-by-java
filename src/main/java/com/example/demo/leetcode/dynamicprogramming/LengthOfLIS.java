package com.example.demo.leetcode.dynamicprogramming;

/**
 * leetcode 300 最长递增子序列
 * <p>
 * 定义f(n)
 * 找出状态转移方程
 * <p>
 * 递归+记忆化
 * <p>
 * i和n均为索引，以索引i为尾数的序列的最长上升子序列满足下述关系式
 * 每次求解子序列的最优解，最后能+1的前提是，nums[n]>nums[i]，才能在子序列最优解的基础上+1长度
 * <p>
 * f(n) = maxf(i) + 1 i<n且a[i]<a[n]
 * 通过找规律得出
 * <p>
 *
 */
public class LengthOfLIS {

    public int lengthOfLIS(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int result = 1;
        //问题的答案肯定是每个子序列中得出，由于前面先遍历过的子序列一定是后面遍历子序列的子序列
        //所以可以考虑获取前面的子序列的解，来构造后面的解。满足构造条件的是，前面的解的子序列尾数小于后面的解的子序列的尾数，思路清晰，直接判断，可以则直接+1
        //由于是从前面开始出结果，而不是从后面开始形成算式，相比下面的方法，避免了从后面开始形成算式时排除子序列的可能
        //前面的结果求出来后，只需要按条件形成后面的结果即可
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }

    //递归求解nums序列中，以index为结尾的数组的最长上升子序列
    //该方法没有解决int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};情况的问题，原因是在循环中判断子序列是否满足条件的过程中，将可能得出结果的子序列排除了
    //和上述方法的比较暂未得出...
    public int function(int[] nums, int index, int[] dp) {


        //缓存某长度的解，避免重复计算
        if (dp[index] != 0) {
            return dp[index];
        }

        //以index为尾数的数组，遍历每个子序列，后续每个子序列又遍历
        //每次仅对满足num[j] < nums[index]的结果求解，以保证能够在基础上最长（满足最优子结构才能这么做）
        //最终先求解最小长度的序列的解，最小长度的解必为1
        //最小长度解得出后，递归退出到次小长度的方法中
        //当前长度的最优解
        int result = 1;
        for (int j = 0; j < index; j++) {
            if (nums[j] < nums[index]) {
                result = Math.max(result, function(nums, j, dp) + 1);
            }
        }
        dp[index] = result;
        return result;
    }

    public static void main(String[] args) {
        LengthOfLIS lengthOfLIS = new LengthOfLIS();
        int[] nums = {1, 3, 6, 7, 9, 4, 10, 5, 6};
        System.out.println(lengthOfLIS.lengthOfLIS(nums));
    }


}
