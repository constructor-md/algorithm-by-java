package com.example.demo.leetcode.bytedance;

import java.util.*;

public class CombinationResult {


    public static void main(String[] args) {
        // 假设桶身 + 桶盖一共 n 个，从 0 编号到 n - 1
        int count = 3;
        // 存储所有的历史结果
        List<List<Integer>> result = new LinkedList<>();
        for (int i = 0; i < count; i ++) {
            // 新生结果
            List<List<Integer>> newResult = new LinkedList<>();
            newResult.add(Collections.singletonList(i));
            // 用历史结果与新的数字生成新生结果
            for (List<Integer> list: result) {
                List<Integer> list1 = new ArrayList<>(list);
                list1.add(i);
                newResult.add(list1);
            }
            // 存储新生结果
            result.addAll(newResult);
        }

        System.out.println(result);
        System.out.println(result.size());
    }

}
