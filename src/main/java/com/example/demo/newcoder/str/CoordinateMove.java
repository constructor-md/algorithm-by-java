package com.example.demo.newcoder.str;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * HJ17 坐标移动
 * ADWS左右上下，从(0,0)开始
 * 输入字符串为 字母+数字 以;分隔
 * 需要排除无效输入
 * 输出为最终坐标
 *
 *
 *
 */
public class CoordinateMove {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] strArr = input.split(";");
        Map<Character, Boolean> map = new HashMap<>();
        map.put('A', true);
        map.put('D', true);
        map.put('W', true);
        map.put('S', true);
        int x = 0;
        int y = 0;
        for (String move : strArr) {
            if ("".equals(move)) {
                continue;
            }
            //第一个字符必须是ADWS，其他字符必须是数字
            char first = move.charAt(0);
            if (!map.containsKey(first)) {
                continue;
            }
            int moveStep = 0;
            String step = move.substring(1);
            if (!step.matches("\\d+")) {
                continue;
            }
            moveStep = Integer.parseInt(step);
            switch (first) {
                case 'A': x -= moveStep;break;
                case 'D': x += moveStep;break;
                case 'W': y += moveStep;break;
                case 'S': y -= moveStep;break;
            }
        }

        System.out.println(x + "," + y);
    }


}
