package com.example.demo.leetcode.slidingwindow;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static com.example.demo.leetcode.slidingwindow.MinWindow.analysis;
//import static com.example.demo.leetcode.slidingwindow.MinWindow.judge;

/**
 * leetcode 76
 * 最小覆盖子串
 * <p>
 * 讨论后的新解法，基本概念是采样，只关注必要的那些
 * <p>
 * 只关注感兴趣的内容/样本
 * 首先记录下s中所有t中字母的位置
 * 仅遍历这些位置，并裁剪字符串判断结果是否正确
 * <p>
 * <p>
 * 去除了很多无效的遍历内容
 * <p>
 * 考虑通过查找右边，找到结果后，立即收缩左边，找到当前结果的最小结果
 * 然后以当前位置重新循环
 *
 * 最后最后的十万量级超时了。。。
 */
public class MinWindowBetter {


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

        //左边坐标
        int left = 0;
        //右边坐标
        int right = 0;

        boolean init = false;
        int idxSize = indexList.size();
        int tLen = t.length();

        //右边的扩张要求
        while (right < idxSize) {
            String sub = s.substring(indexList.get(left), indexList.get(right) + 1);
            if (judge(sub, map)) {
                if (init) {
                    result = result.length() < sub.length() ? result : sub;
                } else {
                    result = sub;
                    init = true;
                }
                //如果符合要求，尝试收缩左边
                left++;
                while (idxSize > 1 && (indexList.get(right) - indexList.get(left) + 1) >= tLen) {
                    String subLeft = s.substring(indexList.get(left), indexList.get(right) + 1);
                    if (judge(subLeft, map)) {
                        result = result.length() < subLeft.length() ? result : subLeft;
                        left++;
                    } else {
                        break;
                    }
                }
            }
            right++;
        }
        return result;
    }

    //判断子串是否有效
    public static boolean judge(String sub, Map<Character, Integer> tMap) {
        Map<Character, Integer> subMap = analysis(sub);
        //如果tMap内容为空，则s必满足
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            //要求tMap中的每个参数都必须在subMap中有对应并且值合理
            Integer num = entry.getValue();
            //如果sub中不存在t中的某个字符，或者存在的数量少于t值，则子串无效  允许有多的其他字符
            if (!subMap.containsKey(entry.getKey()) || subMap.get(entry.getKey()) < num) {
                return false;
            }

        }
        return true;
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
        StringBuilder s = new StringBuilder();
        StringBuilder t = new StringBuilder();
        minWindow(s.toString(), t.toString());

    }



}
