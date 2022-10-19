package com.example.demo.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * leetcode 3
 * 找出无重复字符最长子串
 * 用队列做滑动窗口，找到队列最长时的状态
 * 直到遍历完字符串
 *
 * 看题解后改良版
 *
 */
public class LengthOfLongestSubstringBetter {

    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        //使用s.charAt直接遍历字符串
//        char[] strArr = s.toCharArray();
        //使用指针标识队列上下界，避免额外内存消耗
        int left = 0;
        //i为右边，不断向右 内部则调整left的位置，并不断更新最新的result

        //使用一个Map记录字符和最右下标，辅助left的更新
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                //如果i存在于map，但是最新下标已经小于left，则left位置不变。此时i正常进入队列
                //如果i存在于map，但是最新下标大于left，则left直接更新到新的i的位置，中间不会出现更长的无重复子串
                left = Math.max(left, map.get(s.charAt(i)) + 1);
            }
            //如果不存在，则直接进入map，并记录元素的最新下标
            map.put(s.charAt(i), i);
            result = Math.max(result, i - left + 1);
        }

        return result;
    }


    public static void main(String[] args) {

    }
}
