package com.example.demo.leetcode.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * leetcode 17
 * 电话号码的字母组合
 *
 * 给定数字和字母序列的对应关系
 * 输入一串数字
 * 输出所有可能的字母组合
 *
 * 字母组合为从每个数字的对应字母序列中取出一个组成
 * 结果必须保持数字的顺序，每一位都是对应数字的字母序列值之一
 *
 */
public class LetterCombinations {

    public List<String> resultList = new ArrayList<>();
    public Map<String, String> map = new HashMap<>();
    {
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
    }


    public List<String> letterCombinations(String digits) {
        if (digits.length() > 0) {
            //递归生成所有的字符串，入参为当前的数字状态和当前的结果
            generate(digits, "");
        }
        return resultList;
    }

    public void generate(String digits, String nowResult) {
        //如果数字已经被消耗完，则当前结果加入结果集，退出递归
        if (digits.length() == 0) {
            resultList.add(nowResult);
            return;
        }
        String sc = String.valueOf(digits.charAt(0));
        //获取当前数字对应的字母序列，使其与每个当前结果进行组合成为新的结果，并消耗数字后进入下一个递归
        String mapStr = map.get(sc);
        //消耗数字，设置初始为无数字，如果当前数字长度为1，则消耗后即为无数字，下个递归将其放入结果集
        String nowDigits = "";
        if (digits.length() > 1) {
            nowDigits = digits.substring(1);
        }
        for (int i = 0; i < mapStr.length(); i++) {
            generate(nowDigits, nowResult + mapStr.charAt(i));
        }
    }



    public static void main(String[] args) {
        LetterCombinations letterCombinations = new LetterCombinations();
        System.out.println(letterCombinations.letterCombinations("23"));
    }
}
