package com.example.demo.leetcode.bytedance;

import java.util.LinkedList;

/**
 * leetcode 415 字符串相加
 * 给定两个字符串形式的非负整数num1，num2
 * 计算和并一同样的字符串形式返回，不可以使用大整数库
 * <p>
 * 求和，从字符串尾部开始，全是正数求和
 * 尾部相加，记录进位，下一位相加加上进位
 * 最后进位不为零则进位称为最高位
 */
public class AddStrings {

    public static String addStrings(String num1, String num2) {

        //用一个栈不断入尾部数据，然后从头部出栈来组装结果字符串
        LinkedList<String> resultStack = new LinkedList<>();
        int carry = 0;
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        while (i >= 0 && j >= 0) {
            int n1 = Character.getNumericValue(num1.charAt(i));
            int n2 = Character.getNumericValue(num2.charAt(j));
            int sum = n1 + n2 + carry;
            if (sum > 9) {
                carry = 1;
            } else {
                carry = 0;
            }
            sum = sum % 10;
            resultStack.add(Integer.toString(sum));
            i--;
            j--;
        }



        //遍历剩余元素
        if (i >= 0 || j >= 0) {
            num1 = i >= 0 ? num1 : num2;
            int k = i >= 0 ? i : j;
            for (; k >= 0; k--) {

                int n1 = Character.getNumericValue(num1.charAt(k));
                int sum = n1 + carry;
                if (sum > 9) {
                    carry = 1;
                } else {
                    carry = 0;
                }
                sum = sum % 10;
                resultStack.add(Integer.toString(sum));
            }
        }

        //处理剩余carry
        if (carry != 0) {
            resultStack.add(String.valueOf(carry));
        }

        //出栈组装字符串
        StringBuilder stringBuilder = new StringBuilder();
        int size = resultStack.size();
        for (int k = 0; k < size; k++) {
            stringBuilder.append(resultStack.removeLast());
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(addStrings("9", "1"));
    }


}
