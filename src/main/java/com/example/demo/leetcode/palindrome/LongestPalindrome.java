package com.example.demo.leetcode.palindrome;

/**
 * leetcode 5 最长回文子串
 * <p>
 * 给定字符串，返回其中最长回文子串
 * 中心扩展：找到所有长度为1或2的回文串，然后对其进行向两边扩展
 * 即遍历回文串中心，要求两边字母相同，如果相同即可扩展
 * <p>
 *     可能是单个字母的回文中心，也可能是两个字母的回文中心
 *     每次单个字母，都尝试看看和左边字母是否能组合成双字母回文中心
 *     然后把两种回文中心都进行尝试扩展，然后找到扩展能成的最长回文串，并更新最长的回文结果
 * 回文串要扩展，两边外面的字母必须相等
 */
public class LongestPalindrome {

    public String longestPalindrome(String s) {
        String result = s.substring(0, 1);
        for (int i = 1; i < s.length(); i++) {
            //先判断和左边的能否回文，如果可以，则以两个同样字母作为回文中心
            if (s.charAt(i - 1) == s.charAt(i)) {
                String temp = search(s, i - 1, i);
                if (temp.length() > result.length()) {
                    result = temp;
                }
            }
            //然后判断两边是否相等，以一个字母作为回文中心来找答案
            if (i + 1 < s.length() && s.charAt(i - 1) == s.charAt(i + 1)) {
                String temp = search(s, i - 1, i + 1);
                if (temp.length() > result.length()) {
                    result = temp;
                }
            }
        }
        return result;
    }

    //找到指定回文中心的最长回文串，传入参数是一个回文串的范围
    public String search(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            //如果不相等，则结果为前一个判断
            if (s.charAt(left) != s.charAt(right)) {
                left++;
                right--;
                return s.substring(left, right + 1);
            }
            //如果相等，则扩展两边
            left--;
            right++;
        }
        //如果扩展到其中一个边界，则恢复上一个结果
        left++;
        right--;
        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        String test = "babad";

        LongestPalindrome longestPalindrome = new LongestPalindrome();
        System.out.println(longestPalindrome.longestPalindrome(test));
    }


}
