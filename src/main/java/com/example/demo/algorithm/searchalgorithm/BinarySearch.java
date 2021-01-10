package com.example.demo.algorithm.searchalgorithm;

/**
 * 二分查找
 * 要求待查为有序序列，顺序存储结构（数组）
 * 时间复杂度：log2n   n（2^x） = 1
 */
public class BinarySearch {

    public static void main(String[] args) {


        int[][] n = new int[0][0];

        System.out.println(n.length);


    }


    /**
     * 非递归实现
     *
     * 基本思想：输入为有序序列。使用low和high记录数组首尾索引。
     * 因为是 特性1 ： 有序序列，故输入key若大于数组最大值或小于数组最小值，亦或数组长度为0，则序列内无key值
     * 开始查找，根据low和high获取中间索引middle，利用特性1，只需判断middle处的值与key的大小关系，可知key值可能在左侧或者右侧，从而选择变更low和high的值
     * 如果不大也不小，即为等于，则返回该值
     * 以此类推，不断变化low和high的值，缩小查找范围，最终找到。
     * 如果high = low时仍找不到，则数组中无该值，且high和low的值有一个会变化，从而不会死循环。
     *
     * 注意：如果使用（low + high）/ 2 的写法，low和high很大时会造成溢出（int 类型 4个字节存储，32位有符号数，最大值为2^31-1 , 最小值为-2^31,超出则溢出。31是因为符号位占一位，-1是因为0也占一个数）
     * 使用位运算代替除以，位运算直接操作二进制，对计算机更友好
     *
     * 空间复杂度算的是完成算法使用的辅助空间，此处只有常数级的常量存储空间，空间复杂度为 1
     *
     * @param nums
     * @param key
     * @return
     */
    public static boolean commonBinarySearch(int[] nums, int key) {

        int low = 0;
        int high = nums.length - 1;
        int middle = 0;

        //数组长度为0时直接判断，且应该写在最前面，使用短路判断使得不会报数组越界
        if (high == -1 || low > high || key < nums[low] || key > nums[high]) {
            return false;
        }

        //数组长度为1时直接判断
        if (high == 0){
            return nums[high] == key;
        }

        while (low <= high) {
            middle = low + ((high - low) >>> 1);

            if (nums[middle] > key) {
                //
                high = middle - 1;
            } else if (nums[middle] < key) {
                //
                low = middle + 1;
            }else {
                return true;
            }

        }

        //无则返回
        return false;
    }



    /**
     * 递归实现
     * 基本思想与非递归一致，但是使用了递归的思想
     * 一方面代码更加简洁，一方面实现的空间复杂度与递归使用的栈深度相关，升高为 n
     * 时间复杂度却没变
     *
     * @param nums
     * @param key
     * @return
     */
    public static int recursionBinarySearch(int[] nums, int key ,int low ,int high) {

        if (key < nums[low] || key > nums[high] || low > high) {
            return -1;
        }

        int middle = low + ((high - low) >>> 1);

        if (nums[middle] > key ){
            return recursionBinarySearch(nums, key, low, middle - 1);
        }else if (nums[middle] < key){
            return recursionBinarySearch(nums, key, middle + 1, high);
        }else {
            return middle;
        }

    }



    /**
     * 二维数组实现
     */
    public static int commonBinarySearchIn2DArray(int[][] matrix, int target){

        //数据增序排列，在二维数组内折半查找
        //使用非递归形式减少空间消耗
        //时间log2n，空间1  --未完成，未通过测试 ， 问题可能出在转换二维数组坐标的公式不完全正确
        int low = 0;
        int inLength = matrix[0].length;
        int outLength = matrix.length;

        System.out.println(inLength + " " + outLength);

        int high = outLength  * inLength - 1;
        int middle ;

        if (matrix[0][0] > target || matrix[outLength -1][inLength -1] < target || low >= high){
            return -1;
        }

        int in ;
        int out ;

        while (low <= high) {

            middle = low + 1 + ((high  - low) >>> 1);

            System.out.println(middle);

            //转换成二维数组坐标
            //如取 4 * 5 的二维数组的第16个数，位置在 16 / 5  = 3 行 ，16 % 5  - 1 = 0 列 （数组索引从0开始 ，从1开始则是 4行1列）

            out = middle / inLength;
            in = middle % inLength ;

            if (in == 0){
                in = inLength - 1;
                out -- ;
            }

            System.out.println("out : " + out + " in : " + in);

            System.out.println("num : " + matrix[out][in]);

            System.out.println("low : " + low + " high : " + high + " middle : " + middle);

            if (matrix[out][in] > target) {
                high = middle - 1;
            } else if (matrix[out][in] < target) {
                low = middle + 1;
            } else {
                return out * in;
            }

            System.out.println("low : " + low + " high : " + high + " middle : " + middle);

        }

        return -1;

    }






}
