package com.example.demo.newcoder;

import java.util.Scanner;

public class MingMingRandom {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] nums = new int[num];
        int arrIndex = 1;
        while ( arrIndex <= num && in.hasNextInt()){
            nums[arrIndex - 1] = in.nextInt();
            arrIndex ++;
        }
        //先排序后遍历
        mergeSort(nums, 0, nums.length - 1);
        int nowNum = 0;
        int nowPoint = 0;
        int[] result = new int[num];
        int resultNum = 0;
        for (int i = 0; i < num; i++) {
            if (nums[i] > nowNum) {
                result[nowPoint] = nums[i];
                nowPoint++;
                nowNum = nums[i];
                resultNum++;
            }
        }
        for (int i = 0; i < resultNum; i++) {
            System.out.println(result[i]);
        }

//        int[] arr = {5,5,6,3,3,2,2,1};
//        mergeSort(arr, 0, arr.length - 1);
//        for (int i = 0; i < arr.length; i++) {
//            System.out.println(arr[i]);
//        }


    }

    //归并排序
    public static void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + ((right - left) >> 1);
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }


    }

    public static void merge(int[] nums, int left, int mid, int right) {
        //定义一个临时数组
        int[] tempArr = new int[right - left + 1];
        //按mid分割数组，定义两个从左到右的指针
        int temp1 = left, temp2 = mid + 1;
        int index = 0;
        //比较两个数组的值，并把小的先放进大集合，合并两个数组
        while (temp1 <= mid && temp2 <= right) {

            if (nums[temp1] <= nums[temp2]) {
                tempArr[index] = nums[temp1];
                temp1++;
            } else {
                tempArr[index] = nums[temp2];
                temp2++;
            }
            index++;


        }

        //上述while可能遗漏元素，将剩余元素放入数组。因为该方法不能确定mid就是中间
        if (temp1 <= mid) {
            //将tempArr中从index到mid - temp + 1的内容放入nums中temp1的后面
            System.arraycopy(nums, temp1, tempArr, index, mid - temp1 + 1);
        }
        if (temp2 <= right) {
            System.arraycopy(nums, temp2, tempArr, index, right - temp2 + 1);
        }

        //将临时集合的元素复制回原数组
        System.arraycopy(tempArr, 0, nums, left, right - left + 1);

    }
}
