package com.example.demo.leetcode.math;

/**
 * leetcode 7 整数反转
 *
 * 基本的反转方法是取最后一位数，最后组合成新的数字
 * 返回的值必须用int存储，int的最大值为-2147483648 ~ 2147483647
 * 需要对入参进行判断，对于反转后会越界的，就要返回0
 *
 * 怎么样的数反转后会越界？
 *     边反转边检查，如果一个数绝对值反转中途结果大于214748364，则后面不用判断，必然溢出
 *                                           等于214748364，则判断后面的数，如果是正数且后面的数大于7，则移除，如果负数且后面大于8则溢出
 *                                           如果小于，则必然不溢出
 *
 */
public class IntReverse {


    public int reverse(int x) {
        //第一次取余是首位、第二次是次位...故每次取余数都加上原数字乘10，就可以拼接得到新数字
        int result = 0;
        boolean pos = true;
        //如果让负数*-1就可能越界，故只能以负数进行计算，到中途判断越界时，根据负数标识符来判断
        //中间反转过程不会涉及符号位，所以正负都可以进入
        if (x < 0) {
            pos = false;
        }

        while (x != 0) {
            if (Math.abs(result) > 214748364) {
                return 0;
            }
            if (Math.abs(result) == 214748364 && pos && x % 10 > 7) {
                return 0;
            }
            if (Math.abs(result) == 214748364 && !pos && (x * -1) % 10 > 8) {
                return 0;
            }
            result = result * 10 + x % 10;
            x /= 10;
        }
        return result;
    }


    public static void main(String[] args) {
        IntReverse intReverse = new IntReverse();
        System.out.println(intReverse.reverse(-2147483648));
    }
}
