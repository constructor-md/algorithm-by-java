package com.example.demo.leetcode.doublepointer;

import java.util.*;

/**
 * leetcode 15 三数之和
 * <p>
 * 给定一个数组，求三元组，每个元素互不相等，且和为0
 * 求出所有的三元组，且三元组互不重复
 * 0，-1，1和0，1，-1重复
 * <p>
 * 为了进行不重复的判断，可以考虑枚举到的三元组内部有序
 * 可以先让数组内部排好序，然后三重循环遍历数组元素得到三元组
 * 第一重循环得到i，第二重循环得到j，第三重循环得到 0 - j - i
 * 每一重循环的值不能和上一次循环相同，否则就会重复 -- 有序数组造成的遍历特征 不好理解的话就使用Map在最后的循环对结果去重
 *
 * 三种循环会导致超时，需要排除一些情况
 * 利用排序好后的一些性质，第一重循环值大于0则不用再找，后面不可能求和得0
 * 第二重循环和第一重循环值得和大于0，其中一个肯定大于0，后面第三重循环也必然大于0，所以也不用找
 *
 * 也可以在两重循环中解决
 * 第一重循环选定一个元素，第二重循环使用双指针去找两数之和
 * 第二个数自然循环递增，第三个数仅存在一个值满足要求
 * 每当选定第一个值，找到第一个三元组，就记录第一个三元组的索引，下次第二重循环继续时，从该索引开始往回找
 * 每次找到一个三元组，就更新索引
 * 通过双指针来减少循环
 *
 *
 *
 */
public class ThreeNums {

    //虽然前两层循环减少了一些次数，但是还是超时了
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<String> map = new HashSet<>();
        //枚举向后递增
        for (int i = 0; i < nums.length; i++) {
            int iNum = nums[i];
            if (iNum > 0) {
                break;
            }
            for (int j = i + 1; j < nums.length; j++) {
                int jNum = nums[j];
                if (iNum + jNum > 0) {
                    //跳出本层循环
                    break;
                }
                for (int k = j + 1; k < nums.length; k++) {
                    int kNum = nums[k];
                    if (iNum + jNum + kNum == 0) {
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append(iNum).append(jNum).append(kNum);
                        if (map.contains(stringBuilder.toString())) {
                            continue;
                        }
                        map.add(stringBuilder.toString());

                        List<Integer> result1 = Arrays.asList(iNum, jNum, kNum);
                        result.add(result1);
                    }
                }
            }
        }
        return result;
    }

    //通过第二层循环选定值，第三层循环能够根据第二重循环的三元组进行递减来找到答案，又减少了一些次数 通过
    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        Set<String> map = new HashSet<>();
        //枚举向后递增
        for (int i = 0; i < nums.length; i++) {
            int iNum = nums[i];
            if (iNum > 0) {
                break;
            }
            int k = nums.length - 1;
            for (int j = i + 1; j < nums.length; j++) {
                int jNum = nums[j];
                if (iNum + jNum > 0) {
                    //跳出本层循环
                    break;
                }
                int tempK = k;
                while (iNum + jNum + nums[k] > 0 && k > j) {
                    k--;
                }
                if (j == k) {
                    continue;
                }
                //直到n不大于0，就判断是否等于0
                if (iNum + jNum + nums[k] == 0) {
                    StringBuilder stringBuilder = new StringBuilder();
                    stringBuilder.append(iNum).append(jNum).append(nums[k]);
                    if (map.contains(stringBuilder.toString())) {
                        continue;
                    }
                    map.add(stringBuilder.toString());
                    List<Integer> result1 = Arrays.asList(iNum, jNum, nums[k]);
                    result.add(result1);
                } else {
                    k = tempK;
                }
            }
        }
        return result;
    }


}
