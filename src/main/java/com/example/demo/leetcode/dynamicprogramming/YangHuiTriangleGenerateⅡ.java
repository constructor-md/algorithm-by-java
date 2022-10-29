package com.example.demo.leetcode.dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

/**
 * leetcode 119 杨辉三角Ⅱ
 *
 * 给定一个非负索引rowIndex，要求返回杨辉三角的第rowIndex行，即仅生成其中一行
 *
 * 尽量减少空间消耗，当前行仅与上一行有关，仅用上一行即可
 * 当前行第i项仅与上一行第i-1和第i有关，可以得到一行后，从后往前遍历生成数据
 *
 */
public class YangHuiTriangleGenerateⅡ {


    public List<Integer> getRow(int rowIndex) {

        List<Integer> row = new ArrayList<>();
        List<Integer> lastRow = new ArrayList<>();
        //每行每列的元素，等于从上一行的最左边+0和最右边+0，逐一用长为2的窗口加和得到

        //j为下一行下标，根据上一行，逐一生成下一行
        for (int i = 0; i <= rowIndex; i++) {
            for (int j = 0; j <= i; j++) {
                //遍历到本行的左右，自动设置为最顶上的值，因为必然相等
                if (j == 0 || j == i) {
                    row.add(j, 1);
                } else {
                    //本行的j索引值，等于上一行的j-1索引值j索引值
                    row.add(j, lastRow.get(j - 1) + lastRow.get(j));
                }
            }
            lastRow.clear();
            lastRow.addAll(row);
            row.clear();
        }
        return lastRow;
    }

    public static void main(String[] args) {
        YangHuiTriangleGenerateⅡ yangHuiTriangleGenerate = new YangHuiTriangleGenerateⅡ();
        System.out.println(yangHuiTriangleGenerate.getRow(5));
    }

}
