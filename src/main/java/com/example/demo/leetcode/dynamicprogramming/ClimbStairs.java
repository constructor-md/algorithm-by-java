package com.example.demo.leetcode.dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

/**
 * leetcode 70 爬楼梯
 *
 * 爬到x级，只能从x-1或x-2到达
 * 爬到x级的方案，是爬到x-1级的方案和爬到x-2级的方案的和，因为爬到倒数第二步或者倒数第一步，最后一步都是显然的仅一种
 * 总数必然是两者的和
 * f(n) = f(n-1)+f(n-2)
 *
 */
public class ClimbStairs {

    public Map<Integer, Integer> map = new HashMap<>();

    public int climbStairs(int n) {
        //n为0不用爬，n为1仅一种一步，n为2仅1+1和2两种
        if (n <= 2) {
            return n;
        }
        if (map.get(n) != null) {
            return map.get(n);
        }
        int result = climbStairs(n - 1) + climbStairs(n - 2);;
        map.put(n, result);
        return result;
    }


    //超时了，需要对重复子问题做记忆化处理
    public int climbStairs1(int n) {
        //n为0不用爬，n为1仅一种一步，n为2仅1+1和2两种
        if (n <= 2) {
            return n;
        }
        return climbStairs1(n - 1) + climbStairs1(n - 2);
    }


}
