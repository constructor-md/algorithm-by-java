package com.example.demo.leetcode.slidingwindow;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * leetcode 76
 * 最小覆盖子串
 * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 ""
 * 返回s中的子串，子串的要求是：
 * 包含t中的所有字符
 * 可以由不在t中的字符
 * t中的字符重复多少个，s中也至少重复多少个
 * 找到s中满足要求的最小子串 -- 即使得结果唯一
 * <p>
 * 滑动窗口右边扫描s，直到第一次匹配上t的某个字符，就改变left，确定起点
 * 然后右边继续扫描，每次都判断是否满足要求，满足后，立即记录结果，并结束右边的遍历 保证每次都获得最小满足结果
 * 然后移动left，直到再次出现匹配t某个字符的起点，然后重复上述流程
 * <p>
 * 每次比较后，记录最小的子串
 * 最后返回结果
 *
 * 循环太多、超时了
 */
public class MinWindow {

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

        //记录t的情况 即字符和数量 用于判断结果
        Map<Character, Integer> map = analysis(t);
        //是否已经有第一个满足要求的结果
        boolean init = false;
        //起点坐标
        for (int i = 0; i < s.length(); i ++) {
            if (map.containsKey(s.charAt(i))) {
                //以j作为右边
                for (int j = i + 1; j <= s.length(); j++) {
                    String sub = s.substring(i, j);
                    if (init && sub.length() >= result.length()) {
                        continue;
                    }
                    if (judge(sub, map)) {
                        result = sub;
                        if (!init) {
                            init = true;
                        }
                    }
                }
            }
        }
        return result;
    }

    //解析字符和数量信息
    public static Map<Character, Integer> analysis(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            if (map.containsKey(str.charAt(i))) {
                map.put(str.charAt(i), map.get(str.charAt(i)) + 1);
            } else {
                map.put(str.charAt(i), 1);
            }
        }
        return map;
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

    public static void main(String[] args) {
        System.out.println(minWindow("cabwefgewcwaefgcf", "cae"));
    }


}
