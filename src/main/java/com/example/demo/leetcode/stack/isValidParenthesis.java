package com.example.demo.leetcode.stack;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * leetcode 20
 * 有效括号
 *
 * 这题要求的有效括号为：
 *  括号正确闭合，即闭合括号内只能有已经闭合的括号或没有东西
 *  每个括号都要闭合
 *
 * ()[]{} true
 * ([]) true
 * (} false
 *
 * 字符总数必须为偶数
 *
 * 用栈来做：
 *  遍历字符串，后遇到的左括号先闭合
 *  如果遇到左括号，就入栈，如果遇到左括号，就让栈顶弹出，要求两者必须匹配
 *  这解决了(){}[]的问题，也包含了嵌套的情况。
 *  遍历完毕后，存储左括号的栈必须空。
 *
 */
public class isValidParenthesis {

    public static boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        LinkedList<Character> stack = new LinkedList<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(' || s.charAt(i) == '[' || s.charAt(i) == '{') {
                //如果是左括号，push从头推入
                stack.push(s.charAt(i));
            } else if (stack.isEmpty() || stack.peek() != map.get(s.charAt(i))){
                //如果栈空，而此时显然未遍历完字符串，则返回false
                //如果是右括号，查看对应的左括号是否就是栈顶的左括号，如果不是，则返回false
                return false;
            } else {
                //如果栈顶不为空且匹配上了，就弹出栈顶
                stack.pop();
            }

        }
        if (!stack.isEmpty()) {
            //如果遍历完栈不为空，则不合法
            return false;
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(isValid("{}"));
    }


}
