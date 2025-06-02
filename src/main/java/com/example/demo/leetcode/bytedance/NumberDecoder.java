package com.example.demo.leetcode.bytedance;

import java.util.ArrayList;
import java.util.List;

public class NumberDecoder {
    public static void main(String[] args) {
        String input = "113";
        List<String> result = decode(input);
        
        System.out.print("输入: \"" + input + "\", 返回值: ");
        for (int i = 0; i < result.size(); i++) {
            System.out.print("\"" + result.get(i) + "\"");
            if (i < result.size() - 1) {
                System.out.print("、");
            }
        }
    }
    
    public static List<String> decode(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }
    
    private static void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        // 处理单个数字
        int num1 = digits.charAt(index) - '0';
        if (num1 >= 1 && num1 <= 9) {
            current.append((char) ('a' + num1 - 1));
            backtrack(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
        
        // 处理两个数字
        if (index + 1 < digits.length()) {
            int num2 = (digits.charAt(index) - '0') * 10 + (digits.charAt(index + 1) - '0');
            if (num2 >= 10 && num2 <= 26) {
                current.append((char) ('a' + num2 - 1));
                backtrack(digits, index + 2, current, result);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }
}    