package com.example.demo.newcoder;
import java.util.Scanner;

/**
 * 牛客编程题 空汽水瓶换水
 *
 * 给定一个空汽水瓶数量
 * 每三个空瓶换一瓶汽水，可以和老板借水瓶，但必须归还
 *
 * 可以直接换水，直到最后如果剩2个水瓶，即可再换一次汽水（此时可以和老板有借有还）
 *
 *
 *
 */
public class EmptyBottleForDrinks {




    public static void transfer(int n) {
        int result = 0;
        while (n > 2) {
            //已经换到的汽水数量
            result += n / 3;
            //当前的空瓶数量
            n = n / 3 + n % 3;
            //如果只剩2个，就和老板交换
            if (n == 2) {
                result++;
            }
        }
        System.out.println(result);
    }


    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {

            int n = in.nextInt();
            if (n == 0) {
                break;
            }
            transfer(n);

        }

        transfer(0);
    }
}
