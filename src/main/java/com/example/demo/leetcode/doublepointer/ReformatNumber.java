package com.example.demo.leetcode.doublepointer;

public class ReformatNumber {


    public static void main(String[] args) {
        System.out.println(ReformatNumber.reformatNumber("1-23-45 6"));
    }

    public static String reformatNumber(String number) {
        char blank = ' ';
        char mine = '-';
        char[] chars = number.toCharArray();
        //去除空格和破折号 一次遍历解决
        char[] result = new char[chars.length];
        //已经计数的数量
        int j = 0;
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == blank || chars[i] == mine) {
                continue;
            } else {
                //如果j处于应该插入-的位置，先插入-，并自增
                if (((j + 1) % 3) == 0) {
                    result[j] = mine;
                    j++;
                }
                result[j] = chars[i];
                j++;


            }
        }

        String resultString = String.copyValueOf(result);

        return resultString;
    }

}
