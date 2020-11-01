package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }


    public static void main(String[] args) {

        int i = 10;
        int j = 20;
        int k ;

        //位运算优先级较低，建议加上括号方便阅读
        k = i + (j - i)>>>1;
        System.out.println(k);
        k = i + ((j - i)>>>1);
        System.out.println(k);

        //位运算 求两数平均值 安全防溢出
        int x = 10;
        int y = 20;
        int result;
        result = (x & y) + ((x ^ y) >> 1);
        System.out.println(result);

    }

}
