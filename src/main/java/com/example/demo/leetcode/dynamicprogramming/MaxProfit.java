package com.example.demo.leetcode.dynamicprogramming;

/**
 * leetcode 121 买卖股票的最佳时机
 *
 * 数组内是每一天某只股票的价格
 * 要求只能某天买入，另一天卖出。计算最大利润
 *
 * 注意，此题仅要求买入一次，卖出一次
 *
 * 遍历数组，假设每天都卖出，意味着每天都认为自己持有的股票是在最低点买入。则得到每天的最大利润
 * 最后得到利润最大值
 *
 * 这题描述虽然好像很现实，但不一定意味着就要模拟一遍现实操作来思考答案。可以考虑从某些角度阐述、简化问题
 *
 */
public class MaxProfit {


    public int maxProfit(int[] prices) {

        //记录当前股票的最低价
        int minPrice = prices[0];
        int max = 0;
        //第一天不能买卖，直接跳过
        for (int i = 1; i < prices.length; i++) {
            //第一天不能买卖
            if (i == 0) {
                continue;
            }
            //第二天开始考虑买卖
            int profit = prices[i] - minPrice;
            max = Math.max(max, profit);

            //不能又买又卖，所以在买卖完后更新价格最低点
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            }
        }
        return max;
    }

}
