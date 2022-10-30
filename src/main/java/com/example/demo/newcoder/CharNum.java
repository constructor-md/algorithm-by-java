package com.example.demo.newcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * HJ10 字符种数统计
 *
 * 计算字符串中不同字符的种数
 * 仅统计ASCⅡ范围内的字符（0~127，包含0和127）
 * 每种仅统计一个
 *
 */
public class CharNum {

    public static Map<Integer, Integer> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        int result = 0;
        for (int i = 0; i < str.length(); i++) {
            int charAsc = str.charAt(i);
            if (charAsc <= 127 && !map.containsKey(charAsc)) {
                map.put(charAsc, 0);
                result++;
            }
        }
        System.out.println(result);
    }



}
