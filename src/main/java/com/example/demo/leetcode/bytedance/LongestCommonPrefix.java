package com.example.demo.leetcode.bytedance;

/**
 * leetcode 14 最长公共前缀
 * 查找一个字符串数组中的各字符串的最长公共前缀
 * 不存在则返回空串
 *
 * 最长公共前缀一定产生于具有公共前缀的字符串之间
 * 两个字符串之间有公共前缀长为2，必然会有长为1 的公共前缀
 * 所以在具有公共前缀的字符串间查找，不断缩小范围
 *
 * 找到最短字符串长度，设置为最多遍历的次数m
 * 设置一个Map存储已存在的公共前缀
 * 遍历字符串数组，第一次将各自的第一个字母加入其中，重复的自然略过
 * 第二次遍历字符串数组，判断当前字符串的前缀是否在Map中，是则将新前缀放入Map，以此类推
 * 如果某次遍历，没有产生新的前缀，则字符串公共前缀不会再增加，退出循环
 * 时间上m*n，空间上则是存了所有公共前缀 类似m+m-1+m-2 ... m的二次方
 *
 * 优化：仔细读题，问的不是某几个字符串之间存在最长公共前缀，而是字符串数组全员的最长公共前缀
 * 这个公共前缀必然包含在前两个字符串内，根据前两个字符串得到公共前缀，向后遍历，找公共前缀和当前字符串的公共前缀，某次变成空串则直接返回
 *
 *
 */
public class LongestCommonPrefix {

    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }
        if (strs.length == 1) {
            return strs[0];
        }
        String prefix = getCommonPrefix(strs[0], strs[1]);
        for (int i = 2; i < strs.length; i++) {
            prefix = getCommonPrefix(prefix, strs[i]);
            if ("".equals(prefix)) {
                return prefix;
            }
        }
        return prefix;
    }

    public String getCommonPrefix(String prefix, String str2) {
        StringBuilder stringBuilder = new StringBuilder();
        int length = Math.min(prefix.length(), str2.length());
        for (int i = 0; i < length; i++) {
            if (prefix.charAt(i) != str2.charAt(i)) {
                return stringBuilder.toString();
            }
            stringBuilder.append(prefix.charAt(i));
        }
        return stringBuilder.toString();
    }



}
