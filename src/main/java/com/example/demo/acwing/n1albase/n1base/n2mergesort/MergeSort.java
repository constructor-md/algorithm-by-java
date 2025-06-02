package com.example.demo.acwing.n1albase.n1base.n2mergesort;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {


    public static void main(String[] args) {
//        int[] q = new int[]{2, 5, 7, 0, 1, 4};
//        System.out.println(Arrays.toString(q));
//        mergeSort(q, 0, 5);
//        System.out.println(Arrays.toString(q));

//        int[] q = new int[]{1, 2, 2, 3, 3, 4};



        int[] q = new int[]{1, 5, 6};
        int[] p = new int[]{4, 5, 6, 7, 8};
        System.out.println(Arrays.toString(mergeArrayByDoublePointer(p, q)));
    }



    public static void mergeSort(int[] q, int l, int r) {
        if (l >= r) return;

        int mid = l + r >> 1;
        mergeSort(q, l, mid);
        mergeSort(q, mid + 1, r);


        // 本次合并结果的数组
        int[] tmp = new int[r - l + 1];
        // 结果数组的索引
        int k = 0;
        // 两数组双指针
        int i = l, j = mid + 1;
        // 左右各自边界
        while (i <= mid && j <= r) {
            if (q[i] <= q[j]) tmp[k++] = q[i ++];
            else tmp[k++] = q[j++];
        }
        // 可能是左可能是右还有剩余数据，都判断并直接复制
        while (i <= mid) tmp[k++] = q[i++];
        while (j <= r) tmp[k++] = q[j++];

        // 把tmp中的合并结果复制到原数组 此时把i作为原数组下标范围在l - r，j作为合并结果数组下标
        for (i = l, j = 0; i <= r; i++, j++) {
            q[i] = tmp[j];
        }

    }



    // 双指针合并数组
    public static int[] mergeArrayByDoublePointer(int[] q, int[] p) {
        int[] result = new int[q.length + p.length];
        int qIndex = 0;
        int pIndex = 0;
        int rIndex = 0;
        while (qIndex <= q.length - 1 && pIndex <= p.length - 1) {
            if (p[pIndex] <= q[qIndex]) result[rIndex++] = p[pIndex++];
            else result[rIndex++] = q[qIndex++];
        }
        while (pIndex <= p.length - 1) result[rIndex++] = p[pIndex++];
        while (qIndex <= q.length - 1) result[rIndex++] = q[qIndex++];
        return result;
    }

    // 二分查找
    public static int bSearch1(int l, int r) {
        while (l < r) {
            int mid = l + r >> 1;
            if (check(mid)) r = mid;
            else l = mid + 1;
        }
        return l;
    }

    public static int bSearch2(int l, int r) {
        while (l < r) {
            int mid = l + r + 1 >> 1;
            if (check(mid)) l = mid;
            else r = mid - 1;
        }
        return l;
    }

    public static boolean check(int mid) {
        return true;
    }

}
