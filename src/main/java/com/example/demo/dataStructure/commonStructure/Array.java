package com.example.demo.dataStructure.commonStructure;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Array {


    public static void main(String[] args) {

    }


    /**
     * 找出一维数组中的重复数字
     * 找出数组中重复数字，任意一个
     * 数组长度为n，数组内数大小为 0 ~ n-1 的整型
     * 输入数组，输出该重复数字
     */
    public static int findRepeatNumber(int[] nums) {


        //解法1，参考计数排序，通过题目设计中特定的数组下标和输入的关系，空间换时间找到该数
        //时间n，空间n
//        int[] bucket  = new int[nums.length];
//
//        for(int n : nums){
//
//            if(bucket[n] == 0){
//                bucket[n] = n;
//            }else{
//                return n;
//            }
//
//
//        }
//
//        return 0;


        //解法2，使用Array自带的contains方法判断是否存在，要说好处，List是动态数组实现，多数情况下空间上会少用一些
        //不会少用的时候：List默认初始化大小为10，如果达到最大容量，那么在插入新数据之前，初始化一个大小为原来1.5倍的数组，将当前数组值复制进去，再插入新值
        //但是contains方法实际上是通过遍历数组来判断是否有该对象的，时间复杂度高，且外层已经做了遍历，时间复杂度过高。LeeCode提示超出时间限制(输入了长达十万的数组)
        //时间n2，空间n？

//        List<Integer> num = new ArrayList<>();
//
//        for(Integer n : nums){
//
//            if(!num.contains(n)){
//                num.add(n);
//            }else{
//                return n;
//            }
//
//        }
//
//        return 0;


        //解法3,利用Hash优秀的查找效率，实质上和数组的差别在于，先计算了元素Hash来找到元素，判断是否存在，而数组直接根据下标来找到元素地址，底层实现上的效率应该不如数组
        //且空间复杂度和数组相比稍弱
        //执行结果证明：该方法空间略高于数组法，时间比数组法更慢，数组1ms，该方法7ms
        //该contains方法本质是使用了map的containKey，Set本质就是一个Map
        //时间n，空间n
//        Set<Integer> num = new HashSet<>();
//
//        for (Integer n : nums) {
//
//            if (!num.contains(n)) {
//                num.add(n);
//            } else {
//                return n;
//            }
//        }
//        return 0;


        //解法4，1的另一种，代码本身更简洁一点，但是效率不是很好
        //1采用foreach循环，本质上是使用了迭代器迭代，该方法使用了正常循环，但是速度不如迭代器（原因：）
        //该方法采用在新数组的对应数字位置上的数++的方式，如果数字重复，则该数字会在++后大于1（第二次++了）（非迭代器方法的放置思路，本质上是计数，而1法本质上是排序）
        //1法在逻辑上有缺陷，但是通过return 0弥补了：如果重复数字是0，则会被略过，如果存在其他重复数字，则不会返回重复的0，如果不存在则自然返回了0.实质上是钻了题目漏洞（只找一个）
        //4法的计数才是本质，4法完全可以通过遍历数组发现到底是哪个数重复了几次，而1法显然不行，0有缺漏，且不能发现全部数字及其重复次数
        //4法，值得记录

        //数组字典计数的缺陷：如果数据存在大量断层，则空耗大量数组空间，效率变得低下，题目中是可能出现该情况的，大量数据重复的情况下，不过最差空间复杂度就是n了

        //时间n，空间n
//        int[] bucket  = new int[nums.length];
//
//        for(int i = 0; i < nums.length; i++){
//
//            bucket[nums[i]]++;
//            if(bucket[nums[i]] > 1) return nums[i];
//
//        }
//        return 0;


        //待续

        return 0;

    }


    /**
     * 二维数组的查找
     *  在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     *  请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target){

        //解法1，遍历数组，转入HashSet，Hash查找
        //时间n，空间n





        //解法2，分析题目，数据增序排列
        //1.判断一维数组长度决定是否进入该数组查找
        //2.在一维数组内使用折半查找



        return false;
    }







}
