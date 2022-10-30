package com.example.demo.newcoder;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 牛客编程题 进制转换
 * 输入一个十六进制数字符串，转换成十进制数输出字符串
 *
 */
public class DecimalConversion {

    public static Map<Character, Integer> hexCarry = new HashMap<>();
    static {
        hexCarry.put('0', 0);
        hexCarry.put('1', 1);
        hexCarry.put('2', 2);
        hexCarry.put('3', 3);
        hexCarry.put('4', 4);
        hexCarry.put('5', 5);
        hexCarry.put('6', 6);
        hexCarry.put('7', 7);
        hexCarry.put('8', 8);
        hexCarry.put('9', 9);
        hexCarry.put('A', 10);
        hexCarry.put('B', 11);
        hexCarry.put('C', 12);
        hexCarry.put('D', 13);
        hexCarry.put('E', 14);
        hexCarry.put('F', 15);
    }


    public static void transfer() {
        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            String input = in.nextLine();
            String hex = input.replaceAll("0x", "");
            char[] hexArr = hex.toCharArray();
            int result = 0;
            int carry = 0;
            for (int i = hexArr.length - 1; i >= 0; i--) {
                char now = hexArr[i];
                int a = hexCarry.get(now);
                result += a * Math.pow(16, carry);
                carry++;
            }
            System.out.println(result);
        }
    }

    public static void main(String[] args) {
        transfer();
    }


}
