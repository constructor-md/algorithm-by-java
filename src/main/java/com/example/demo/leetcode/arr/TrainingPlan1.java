package com.example.demo.leetcode.arr;

import java.util.Arrays;

/**
 * 将所有奇数训练编号调整到偶数训练编号前面
 */
public class TrainingPlan1 {
    // 双指针前后遍历互换位置
    public static void main(String[] args) {
        int[] actions = new int[]{2, 2, 3, 4, 5};
        int i = 0;
        int j = actions.length - 1;
        while (i < j) {
            if (actions[i] % 2 == 0 && actions[j] % 2 == 1) {
                int temp = actions[i];
                actions[i] = actions[j];
                actions[j] = temp;
                i++;
                j--;
                continue;
            }
            if (actions[i] % 2 == 1) {
                i++;
            }
            if (actions[j] % 2 == 0) {
                j--;
            }
        }

        System.out.println(Arrays.toString(actions));
    }


}
