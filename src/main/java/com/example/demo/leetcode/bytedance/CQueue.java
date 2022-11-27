package com.example.demo.leetcode.bytedance;

import java.util.LinkedList;

/**
 * 剑指offer09 用两个栈实现队列
 * 给定队列的声明，实现两个函数appendTail和deleteHead
 * 分别完成在队尾插入整数和在队头删除整数
 * 删除时没有元素则返回-1
 *
 * 实现队列可以通过链表，实现尾部的插入和头部的删除
 * 如果使用栈来做，栈的特性是后入先出，队列的特性是先入先出
 * 一个栈作为输入栈，一个作为输出栈
 * 插入时插入输入栈，获取时从输出栈获取
 * 如果输出栈没有内容，则获取全部输入栈的内容
 * 输入栈后入先出，输出栈也后入先出，两者倒灌后变为先入先出
 * 如同把一串输入1-9（9在栈尾1在栈顶）放进输入栈，然后放入输出栈9-1（9在栈顶1在栈尾部）
 * 从而实现队列
 *
 *
 *
 */
public class CQueue {

    //输入输出栈，且只能从尾部加入，从头部输出
    private LinkedList<Integer> input;
    private LinkedList<Integer> output;

    public CQueue() {
        input = new LinkedList<>();
        output = new LinkedList<>();
    }

    public void appendTail(int value) {
        //加入栈尾
        input.add(value);
    }

    public int deleteHead() {

        if (input.size() == 0 && output.size() == 0) {
            return -1;
        }

        if (output.size() != 0) {
            //从栈顶移除
            return output.removeFirst();
        } else {
            //将input元素全部出栈到output
            for (int i = 0; i < input.size(); i++) {
                output.add(input.removeFirst());
            }
            return output.removeFirst();
        }
    }

}
