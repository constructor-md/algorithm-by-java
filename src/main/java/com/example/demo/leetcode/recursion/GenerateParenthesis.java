package com.example.demo.leetcode.recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 22
 * 括号生成
 * <p>
 * 括号生成的合法性校验：
 * 设置一个变量b=0，从左到右遍历字符序列，遇见(就+1，遇见)就-1，过程中，只要b<0则不合法，最后如果b!=0也不合法
 * <p>
 * 输入n为括号的对数，即左括号和右括号的数量
 * 规律是，剩余左括号总数要小于等于右括号
 * 递归思路：
 *  递归生成字符串，每个递归方法为字符串添加一个字符，(或)
 *  进入方法判断左右字符串总数是否都等于0，
 *      是则符合要求，加入结果集，退出递归
 *      不是则判断当前字符串有效性，
 *          如果剩余左括号数小于剩余右括号，则结果无效，退出递归
 *          如果剩余右括号数大于剩余左括号，则可以加左括号或者右括号 都加并进入下一个递归。加括号的前提是有剩余
 *          如果剩余右括号数等于剩余左括号，则只能加左括号，并进入下一个递归
 *
 *   一切的前提，是左右括号总数均为n，剩余数量为0后退出递归
 */
public class GenerateParenthesis {

    public static List<String> resultList = new ArrayList<>();

    public static List<String> generateParenthesis(int n) {
        if (n > 0) {
            getParenthesis("", n, n);
        }
        return resultList;

    }

    public static void getParenthesis(String str, int left, int right) {
        if (left == 0 && right == 0) {
            resultList.add(str);
            return;
        } else if (right > left) {
            if (left > 0) {
                getParenthesis(str + "(", left - 1, right);
                getParenthesis(str + ")", left, right - 1);
            } else if (left == 0) {
                getParenthesis(str + ")", left, right - 1);
            }
        } else if (right == left) {
            getParenthesis(str + "(", left - 1, right);
        }
    }

    public static void main(String[] args) {
        generateParenthesis(1);
        System.out.println(resultList);
    }


}
