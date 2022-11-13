package com.example.demo.leetcode.palindrome;

/**
 * leetcode 647 统计回文子串的数目
 *
 * 以中心扩展法，扫描所有回文子串，并计数
 */
public class CountSubstrings {

    public int countSubstrings(String s) {
        //第一个必回文，且不能作为中心
        int result = 1;
        //从第二个字母做中心找起
        for (int i = 1; i < s.length(); i++) {
            //单字母必回文
            result++;
            //先判断和左边的能否回文，如果可以，则以两个同样字母作为回文中心
            if (s.charAt(i - 1) == s.charAt(i)) {
                int temp = search(s, i - 1, i);
                result+=temp;
            }
            //然后判断两边是否相等，以一个字母作为回文中心来找答案
            if (i + 1 < s.length() && s.charAt(i - 1) == s.charAt(i + 1)) {
                int temp = search(s, i - 1, i + 1);
                result+=temp;
            }
        }
        return result;
    }


    //找到指定回文中心的回文串总数，传入参数是一个回文串的范围，且外面没有计数，所以里面一进入就计数
    public int search(String s, int left, int right) {
        int result = 0;
        while (left >= 0 && right < s.length()) {
            result++;
            //如果不相等，则退出 并取消计数
            if (s.charAt(left) != s.charAt(right)) {
                result--;
                break;
            }
            //如果相等，则扩展两边
            left--;
            right++;
        }
        return result;
    }

    public static void main(String[] args) {
        CountSubstrings countSubstrings = new CountSubstrings();
        System.out.println(countSubstrings.countSubstrings("hello"));

    }
}
