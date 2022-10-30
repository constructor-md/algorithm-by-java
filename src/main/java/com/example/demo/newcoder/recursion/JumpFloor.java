package com.example.demo.newcoder.recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * NC68 跳台阶
 *
 * 动态规划问题，最后一级的到达方案，是倒数第二级到达方案和倒数第一级到达方案的和
 *
 * f(n) = f(n - 1) + f(n - 2)
 */
public class JumpFloor {

    public Map<Integer, Integer> map = new HashMap<>();

    public int jumpFloor(int target) {
        if (target <= 2) {
            return target;
        }
        if (map.containsKey(target)) {
            return map.get(target);
        }
        int result = jumpFloor(target - 1) + jumpFloor(target - 2);
        map.put(target, result);
        return result;
    }





}
