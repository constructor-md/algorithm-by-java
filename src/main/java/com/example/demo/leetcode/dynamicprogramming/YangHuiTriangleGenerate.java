package com.example.demo.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 118 杨辉三角
 * <p>
 * 要求生成杨辉三角的前numRows行
 * 杨辉三角中，每个数是它左上方和右上方的数的和
 */
public class YangHuiTriangleGenerate {


    public List<List<Integer>> generate(int numRows) {

        //每行数字的生成，依赖上一行数字的生成结果
        //每行的数字个数，等于行数
        List<List<Integer>> triangle = new ArrayList<>(numRows);
        //i为行数-1
        for (int i = 0; i <= numRows - 1; i++) {
            List<Integer> row = new ArrayList<>();
            if (i == 0) {
                row.add(1);
                triangle.add(i, row);
                continue;
            }
            List<Integer> lastRow = triangle.get(i - 1);
            //每行每列的元素，等于从上一行的最左边+0和最右边+0，逐一用长为2的窗口加和得到

            //j为下一行下标，根据上一行，逐一生成下一行
            for (int j = 0; j <= i; j++) {
                //遍历到本行的左右，自动设置为最顶上的值，因为必然相等
                if (j == 0 || j == i) {
                    row.add(j, 1);
                } else {
                    //本行的j索引值，等于上一行的j-1索引值j索引值
                    row.add(j, lastRow.get(j - 1) + lastRow.get(j));
                }
            }
            triangle.add(i, row);
        }
        return triangle;
    }

    public static void main(String[] args) {
        YangHuiTriangleGenerate yangHuiTriangleGenerate = new YangHuiTriangleGenerate();
        System.out.println(yangHuiTriangleGenerate.generate(5));
    }

}
