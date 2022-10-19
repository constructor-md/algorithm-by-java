package com.example.demo.leetcode.slidingwindow;

import java.util.*;
import java.util.stream.Collectors;

import static com.example.demo.leetcode.slidingwindow.MinWindow.analysis;
import static com.example.demo.leetcode.slidingwindow.MinWindow.judge;

/**
 * leetcode 76
 * 最小覆盖子串
 * <p>
 * 讨论后的新解法，基本概念是采样，只关注必要的那些
 * <p>
 * 只关注感兴趣的内容/样本
 * 首先记录下s中所有t中字母的位置
 * 仅遍历这些位置，并裁剪字符串判断结果是否正确
 * 去除了很多无效的遍历内容
 *
 * 超时了
 */
public class MinWindowChange {

    public static String minWindow(String s, String t) {
        String result = "";
        //t长度为0，则返回不存在
        if (t.length() == 0) {
            return result;
        }
        //长度超过s，必然不存在
        if (t.length() > s.length()) {
            return result;
        }

        //记录t中的字母在s中的位置
        List<Integer> indexList = record(s, t);
        //记录t的情况 即字符和数量 用于判断结果
        Map<Character, Integer> map = analysis(t);

        //仅遍历有效的索引

        //是否已经有第一个满足要求的结果
        boolean init = false;
        //起点坐标
        for (int i = 0; i < indexList.size(); i++) {
            for (int j = i; j < indexList.size(); j++) {
                String sub = s.substring(indexList.get(i), indexList.get(j) + 1);
                if (init && sub.length() >= result.length()) {
                    continue;
                }
                if (sub.length() < t.length()) {
                    continue;
                }
                if (judge(sub, map)) {
                    result = sub;
                    if (result.length() == t.length()) {
                        break;
                    }
                    if (!init) {
                        init = true;
                    }
                }

            }
        }
        return result;
    }

    //记录t中的字母在s中的位置
    public static List<Integer> record(String s, String t) {
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            if (t.contains(String.valueOf(s.charAt(i)))) {
                indexList.add(i);
            }
        }
        return indexList;
    }

    public static void main(String[] args) {
//        while (true) {
//            System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
//        }
        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
    }

}
