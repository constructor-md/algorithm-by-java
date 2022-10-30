package com.example.demo.newcoder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * NC61 两数之和
 *
 * 给出一个数组和目标值，找到数组内两个数的和等于目标值
 * 返回两个数的下标，返回的下标从1开始算起
 * 返回的下标按升序排列
 * 允许空间复杂度O(n)，时间复杂度O(nlogn)
 *
 */
public class TwoNumSumIndex {

    public static int[] twoSum (int[] numbers, int target) {
        int[] result = new int[2];
        //记录数组中的数和所有的下标
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(numbers[i])) {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                map.put(numbers[i], list);
            } else {
                List<Integer> list = map.get(numbers[i]);
                list.add(i);
                map.put(numbers[i], list);
            }
        }
        for (int i = 0; i < numbers.length; i++) {
            int m = target - numbers[i];
            if (map.containsKey(m)) {
                //检查排除自身
                List<Integer> list = map.get(m);
                boolean has = false;
                for (Integer index: list) {
                    if (index != i) {
                        has = true;
                        result[1] = index + 1;
                        result[0] = i + 1;
                        break;
                    }
                }
                if (has) {
                    break;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        int[] nums = {3,2,4};
        twoSum(nums, 6);
    }
}
