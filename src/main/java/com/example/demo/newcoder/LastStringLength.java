package com.example.demo.newcoder;

import java.util.Scanner;

public class LastStringLength {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        String str = in.nextLine();
        char[] strArr = str.toCharArray();
        int length = 0;
        for (int i = strArr.length - 1; i >= 0; i--) {
            length = strArr.length - 1 - i;
            if (strArr[i] == ' ') {
                break;
            }
            if (i == 0) {
                length++;
            }
        }
        System.out.println(length);
    }


}
