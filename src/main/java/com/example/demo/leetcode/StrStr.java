package com.example.demo.leetcode;

public class StrStr {


    public static void main(String[] args) {
        System.out.println(strStr("ewqe", "ewqr"));
    }

    public static int strStr(String haystack, String needle) {

        if (needle.length() == 0) {
            return 0;
        }
        int needleLength = needle.length();
        int haystackLength = haystack.length();

        if (needleLength > haystackLength) {
            return -1;
        }
        char[] strHaystack = haystack.toCharArray();
        char[] strNeedle = needle.toCharArray();

        for (int i = 0; i < haystackLength; i++) {
            if (strHaystack[i] == strNeedle[0]) {
                //如果needle长度为1，则直接返回
                if (needleLength == 1) {
                    return i;
                }
                //找到第一个相等后，判断最后一个是否相等，以快速跳过一些情况
                if ((i + needleLength) > haystackLength) {
                    return -1;
                }
                if (strHaystack[i + needleLength - 1] != strNeedle[needleLength - 1]) {
                    continue;
                }
                //都相等则具备向下判断条件，循环n，判断i的后续是否逐一相等，不相等则返回
                int m = i;
                for (int n = 0; n < needleLength; n++) {
                    if (strNeedle[n] != strHaystack[m]) {
                        break;
                    } else {
                        if (n == (needleLength - 1)) {
                            return i;
                        }
                        m++;
                    }
                }

            }
        }

        return -1;
    }



}
