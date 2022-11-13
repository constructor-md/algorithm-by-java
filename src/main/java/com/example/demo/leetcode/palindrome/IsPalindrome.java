package com.example.demo.leetcode.palindrome;

/**
 * 判断回文数
 */
public class IsPalindrome {

    public static void main(String[] args) {

        System.out.println(isPalindrome2(10));

    }


    //转为字符串解
    public static boolean isPalindrome1(int x) {

        String num = String.valueOf(x);
        if (num.length() <= 1) {
            return true;
        }
        char[] str = num.toCharArray();
        int j = str.length - 1;
        for (int i = 0; i * 2 <= str.length; ) {
            if (str[i] != str[j]){
                return false;
            }
            i++;
            j--;
        }


        return true;
    }

    //不转字符串，数字计算，节省字符串存储空间  -- 寄了，最大int下超时了
    public static boolean isPalindrome2(int x) {

        //处理负数 -号不可能回文，所以返回false
        if (x < 0) {
            return false;
        }

        //获得总位数
        int mod = getNum(x);
        if (x < 10) {
            return true;
        }
        if (mod == 1){
            if ((x / 10) == (x % 10)){
                return true;
            } else {
                return false;
            }
        }

        for (int i = 1; i <= mod / 2 + 1;i++) {

            //通过除法获取左边的数 不是第一个的时候，取余获取最后一个数
            int left = (int )(x / Math.pow(10, mod - i + 1)) ;
            if (left > 9) {
                left = left % 10;
            }
            //通过取余获取右边的数，不是第一个的时候，除法获取最前面的数
            int right = (int ) (x % Math.pow(10, i));
            //需要判断取余后第一个数是否是0
            if (right < Math.pow(10, i - 1)) {
                //如果余数不能大于10的i - 1次方，则第一个数为0
                right = 0;
            }

            if (right > 9) {
                right = right / (int) Math.pow(10, i - 1);
            }
            if (left != right) {
                return false;
            }

        }

        return true;
    }

    //获取十进制数的最大位数
    public static int getNum(int num) {

        int i = 1;
        for (; (int) Math.pow(10, i) <= num ; i++);

        return i - 1;

    }

    //改进上面的方法 反转后一半数字和前一半比较，即对后一半数字从右到左取数，然后按十进制规则加和

}
