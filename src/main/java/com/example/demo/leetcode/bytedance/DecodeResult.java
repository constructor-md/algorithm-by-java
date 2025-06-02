package com.example.demo.leetcode.bytedance;


import java.util.*;

/**
 * 有一种将字母编码成数字的方式：'a'->1, 'b->2', ... , 'z->26'。
 * 现在给一串数字（数字长度不超过 20），请返回所有可能的译码结果，比如：
 * ● 输入："11"，返回值："aa"、“k”，
 * ● 输入：“113”，返回值：“aac”、“kc”、“am”
 */
public class DecodeResult {

    public static void main(String[] args) {

        Set<String> result = new HashSet<>();
        String str = "113";
        System.out.println(str.length());
        // 编码集合
        LinkedList<LinkedList<Integer>> list = encode(str);
        // 将编码集合输出控制台
        for (LinkedList<Integer> codeList: list) {
            String res = toString(str, codeList);
            result.add(res);
        }
        System.out.println(result);
    }

    // 将输入的 str 编码
    public static LinkedList<LinkedList<Integer>> encode(String str) {
        LinkedList<LinkedList<Integer>> result = new LinkedList<>();
        int n = str.length();
        // 返回相加为n 的 1、2序列组合
        if (n == 1) {
            LinkedList<Integer> list = new LinkedList<>();
            list.add(1);
            result.add(list);
            return result;
        }
        if (n == 2) {
            LinkedList<Integer> list2 = new LinkedList<>();
            list2.add(1);
            list2.add(1);
            result.add(list2);

            // 判断能否一次性取2以剪枝
            int code = Integer.decode(str);
            if (code <= 26 && code > 0) {
                LinkedList<Integer> list3 = new LinkedList<>();
                list3.add(2);
                result.add(list3);
            }
            return result;
        }
        // 最左边取1，拼接上右边的编码
        List<LinkedList<Integer>> tempResult1 = encode(str.substring(1));
        tempResult1.forEach(l -> {
            l.addFirst(1);
            result.add(l);
        });

        // 判断最左边能否一次性取 2 以剪枝
        int code = Integer.decode(str.substring(0, 2));
        if (code <= 26 && code > 0) {
            // 最左边取2，拼接上右边的编码
            List<LinkedList<Integer>> tempResult2 = encode(str.substring(2));
            tempResult2.forEach(l -> {
                l.addFirst(2);
                result.add(l);
            });
        }
        return result;
    }

    // 根据编码列表得到编码结果
    public static String toString(String str, List<Integer> list) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer window: list) {
            int code = Integer.decode(str.substring(0, window));
            char c = (char) ((int) 'a' + code - 1);
            stringBuilder.append(c);
            str = str.substring(window);
        }
        return stringBuilder.toString();
    }


}
