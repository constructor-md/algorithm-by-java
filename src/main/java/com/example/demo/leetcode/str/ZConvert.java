package com.example.demo.leetcode.str;

/**
 * leetcode 6 Z字形变换
 *
 * 竖向的Z字型，告知行数为3则第一列三个字母，第二列中间一个字母，第三列三个字母
 * 最后输出从上到下从左到右组合成的字符串
 *
 * 如果行数是4，则第二列第三位和第三列第二位都要是字符，保持完美Z型
 *
 * 可以加入一个行数增长方向的标识符，增长到末尾后减回来，反向增长时，每次都换列
 * 组装好二维数组，然后每行输出即可
 * char的默认值为'\u0000'
 *
 *
 */
public class ZConvert {

    public String convert(String s, int numRows) {
        //快速排除一行的情况，避免后面-2出错
        if (numRows == 1) {
            return s;
        }

        char[][] collection = new char[numRows][s.length()];
        int row = 0, column = 0;
        //行数增长的方向
        boolean direction = true;
        //将字符串以Z型写入数组
        for(int i = 0; i < s.length(); i++) {
            collection[row][column] = s.charAt(i);
            if (direction) {
                row++;
            } else {
                row--;
                column++;
            }

            //正向增长到行末，则-2修正到下一个行位置，并换列，同时后续操作均为--并换列
            if ((row == numRows && direction)) {
                column++;
                row -= 2;
                direction = false;
            } else if (row == -1 && !direction) {
                //反向减到-1，则+2修正到下一个行位置，并换列，由于前面已经换列，此处仅修正前面的换行
                row += 2;
                direction = true;
            }
        }

        //重新组装字符串，遍历二维数组
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for(int j = 0; j < s.length(); j++) {
                if (collection[i][j] != '\u0000') {
                    stringBuilder.append(collection[i][j]);
                }
            }
        }

        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        ZConvert zConvert = new ZConvert();
        System.out.println(zConvert.convert("AB", 1));
    }

}
