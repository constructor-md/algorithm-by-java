package com.example.demo.leetcode.doublepointer;

import java.util.Arrays;
import java.util.List;

/**
 * @author huangz
 * @date 2021/6/20 20:58
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] input = {1, 2, 3, 5, 5, 6, 7, 8};
        int length = removeDuplicates(input);
        System.out.println(length);
        System.out.println(Arrays.toString(input));
    }

    public static int removeDuplicates(int[] nums) {
        //从第一个开始判断，如果下一个不重复则跳到下一个继续判断
        //如果下一个重复，继续判断到下一个，直到出现不重复的那个，然后把后面的数覆盖到前面
        //判断数组的正负序，将判定重复的数设置为某个不可能的值，一次遍历将值全部设置成重复
        //第二次遍历将重复值找到并执行靠前的操作
        int maxIndex = nums.length - 1;
        if(maxIndex == -1) {
            return 0;
        }
        if(nums[0] == nums[maxIndex]) {
            return 1;
        }
        int startValue = nums[0];
        int increment = (nums[0] > nums[maxIndex]) ? 1 : -1;
        int errValue = startValue + increment;

        //将重复数清理为不可能值
        for(int i = 0; i <= maxIndex; ) {
            int value = nums[i];
            int n = i + 1;
            if(n > maxIndex) {
                break;
            }
            while(value == nums[n]) {
                if(value == nums[n]) {
                    nums[n] = errValue;
                }
                n++;
                if(n > maxIndex) {
                    break;
                }
            }
            i = n;
        }

        //跳过不可能值，将有效值逐一聚集在一起
        for(int i = 0; i <= maxIndex;i++) {
            int n = i + 1;
            if(n > maxIndex) {
                return i + 1;
            }
            while(nums[n] == errValue) {
                n++;
                //如果下一个值是错的，就继续往后。如果不能往后，直接返回当前有效数组长度
                if(n > maxIndex) {
                    return i + 1;
                }

                if(nums[n] != errValue) {
                    //如果可以继续往后，就继续判断
                    //并使外层继续遍历
                    //直到找到n的下一个值不是错值，赋给i的下一个值
                    nums[i + 1] = nums[n];
                    nums[n] = errValue;
                    break;
                }
            }

        }

        return 0;

    }

    //双指针直接解决
    public int removeDuplicates1(int[] nums) {
        //从第一个开始判断，如果下一个不重复则跳到下一个继续判断
        //如果下一个重复，继续判断到下一个，直到出现不重复的那个，然后把后面的数覆盖到前面
        //判断数组的正负序，将判定重复的数设置为某个不可能的值，一次遍历将值全部设置成重复
        //第二次遍历将重复值找到并执行靠前的操作
        int maxIndex = nums.length - 1;
        if(maxIndex == -1) {
            return 0;
        }
        if(nums[0] == nums[maxIndex]) {
            return 1;
        }
        int startValue = nums[0];
        int increment = (nums[0] > nums[maxIndex]) ? 1 : -1;
        int errValue = startValue + increment;

        //双指针在一次循环中解决
        int i = 0;
        //如果下一个重复，就继续判断下一个是否还重复
        //重复值设为不可能值，不重复值放到i的下一个值，n继续向后遍历，n的目的永远是增长i的有效长度，直到n遍历完自身
        int lastIValue = nums[i];
        for(int n = i + 1; n <= maxIndex; n++) {
            if(nums[i] != nums[n]) {
                i++;
                nums[i] = nums[n];
            }
        }
        return i + 1;

    }







}
