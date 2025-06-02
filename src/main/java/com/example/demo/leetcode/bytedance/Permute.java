package com.example.demo.leetcode.bytedance;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * leetcode 46 全排列
 * 给定一个不含重复数字的数组，返回其所有可能的全排列
 * 全排列：包含全部元素，但是元素位置各不相同
 * 每一次都从剩下部分任取一个数字，应该不会重复吧
 * 但是需要遍历 n! 次 时间复杂度很高
 * <p>
 * [1] 的全排列 是 1
 * [1, 2] 的全排列是 12 21
 * [1, 2, 3] 的全排列是 123 132 213 231 312 321
 * 即以每个元素为头部，后面遍历拼接剩余元素的全排列
 * <p>
 * 时间复杂度必然是 n!
 */
public class Permute {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2};
        System.out.println(permute(nums));
        System.out.println(permute1(nums));
    }


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 1) {
            List<Integer> list = new ArrayList<>();
            list.add(nums[0]);
            result.add(list);
        } else {
            for (int i = 0; i < nums.length; i++) {
                // 取得剩余元素  -- 每次都需要创建新数组 空间复杂度为O(n2)
                int[] temp = new int[nums.length - 1];
                int tempI = 0;
                for (int j = 0; j < nums.length; j++) {
                    if (j != i) {
                        temp[tempI] = nums[j];
                        tempI++;
                    }
                }
                List<List<Integer>> tempList = permute(temp);
                for (List<Integer> tempResult : tempList) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.addAll(tempResult);
                    result.add(list);
                }
            }
        }
        return result;
    }

    public static List<List<Integer>> permute1(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        backTrack(nums, new LinkedList<>(), new boolean[nums.length], result);
        return result;
    }

    // 回溯算法实现
    // 不需要每次创建新数组，仅需将结果容器传入下一层递归，让下一层直接在上一层结果上拼接每一种情况
    // 在最底层将一个排列结果加入结果集
    // 不需要返回参数 结果由每一次遍历加入到入参容器中
    public static void backTrack(int[] nums, LinkedList<Integer> path, boolean[] used, List<List<Integer>> result) {
        // path 带有上一层遍历到的结果
        // used 维护了上一层遍历过的对象索引
        // result 便于在最低层将结果加入结果集
        // 当长度达到所需长度时加入结果集
        if (path.size() == nums.length) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 每次遍历取一个上层结果中没有选择的值，交付给下一层继续选择
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                path.add(nums[i]);
                used[i] = true;
                backTrack(nums, path, used, result);
                // 撤销这次选择，下一个遍历选择另外一个数据
                path.removeLast();
                used[i] = false;
            }
        }
    }


}
