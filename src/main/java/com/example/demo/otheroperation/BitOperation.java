package com.example.demo.otheroperation;



/**
 * 记录位运算操作和原理
 */
public class BitOperation {

    public static void main(String[] args) {

        int num = 32;

        //无符号左移 相当于除以2 ^ n
        System.out.println(num >>> 1);

        System.out.println(0>>>1);

        //加法溢出
        System.out.println(Integer.MAX_VALUE + (Integer.MAX_VALUE >> 2) - (Integer.MAX_VALUE >> 2));



    }








}
