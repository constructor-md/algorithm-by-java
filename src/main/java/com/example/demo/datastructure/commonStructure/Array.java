package com.example.demo.datastructure.commonStructure;

import java.util.ArrayList;
import java.util.List;

public class Array {


    public static void main(String[] args) {

//        int[][] matrix = {
//            {1,2,3,4,6},
//            {10,23,56,86,99},
//            {101,103,127,187,188},
//            {222,333,444,555,666}
//        };
//
//        System.out.println(findNumberIn2DArray(matrix,101));


        int k = 10;

//        System.out.println(Integer.toBinaryString(((k << 10) + k)>>10));
        int m = k << 10;
//        System.out.println((((k << 10) + k) << 22) >> 22);
        k = (k << 10) + k;
        System.out.println(k);
        System.out.println(Integer.toBinaryString(k));
        System.out.println((k << 22) >>> 22);
        System.out.println(k >> 10);


    }


    /**
     * 剑指 Offer 03. 数组中重复的数字
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
     * 面试题4. 二维数组中的查找
     * 二维数组的查找
     *  在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
     *  请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
     */
    public static boolean findNumberIn2DArray(int[][] matrix, int target){

        /**
         * 解法1：对每一行进行折半查找，非递归实现
         * 时间复杂度：n*log2m，速度较快，运行时间0ms，2020-11-1击败100%，但是内存占用多，44.4M，只击败60%
         * 结果：0ms 100%  44.4M，66.7%
         *
         * 理论时间复杂度：nlog2m ，空间复杂度 1
         */

//        //判断外层长度并无必要，因为长度为0自动不执行遍历，返回false了
//
//        for (int[] n : matrix){
//
//            if (BinarySearch.commonBinarySearch(n,target)){
//                return true;
//            }else continue;
//
//        }
//
//        return false;


        /**
         * 解法2：标志数法
         * 强行便利法没有利用数组的递增特点，而遍历行再二分查找，则没有兼顾列的增长特性
         * 如果将矩阵左到右增大，上到下增大的特性考虑。将矩阵左旋90°成为矩形，则类似二叉搜索树。
         * 即：左分支元素更小，右分支元素更大，从根节点开始搜索，直到找到，如国行或列越界则无
         * （越界表示本行/本列无要求的值，而之所以在行/列找，本就是因为大小关系，对方不可能有值）
         * 此处标志数指的就是根节点，其实就是二叉搜索的使用，从另一个角度看待了这个数组结构
         *
         * 从右上角开始查找，通过判断行列值，决定变化i/j的值，从而循环改变判断的根节点，直到找到想要的点
         * 注意输入空数组的情况，一维空数组实际上也是二维空数组
         *
         * 如果从左下角开始查找，则i=matrix.length - 1 j = 0;
         * 在下面判断中对空数组直接不进入循环，而且因为一开始就没有涉及到内部数组的操作，所以不会在空数组情况下报内部数组越界 -- 更为简洁，从操作上更适合这个数据结构和目的 讲真有点叹为观止
         *
         * 结果：0ms 100%  44.4M，66.7%
         *
         * 理论时间复杂度 n * m 空间复杂度 1
         *
         */


        if (matrix.length == 0){
            return false;
        }

        int i = 0;
        int j = matrix[0].length - 1;

        while ( j >= 0 && i < matrix.length){

            //如果大于，则向小的方向找，小于则向大的方向找
            if (matrix[i][j] > target) j--;
            else if (matrix[i][j] < target) i++;
            else return true;

        }

        return false;





    }


    /**
     * 剑指 Offer 11. 旋转数组的最小数字
     * 把一个数组的最开始若干个元素搬到数组末尾，称为数组的旋转。
     * 输入一个增序数组的一个旋转，要求输出旋转数组的最小元素。
     * 如[3,4,5,1,2]是[1,2,3,4,5]的一个旋转，最小元素为1
     */
    public static int minArray(int[] numbers){

        //解法1：直接排序法，使用性能良好的排序方式
        /**
         * 已知元素组是增序数组
         * 使用时间复杂度相对好的计数排序，但是在分布不均匀时会导致占用空间过大
         * 注意：应该以数列的最小值为起始点，最大值和最小值的差 + 1（最小值本身也在数组中），转化index
         */
//        int[] bucket = new int[numbers.length-1];
//
//        //首先遍历一次，找出最小值...cao，遍历找到最小值不就有结果了吗，排序个屁啊
//        //解法1甚至不如叫直接遍历法
//
//
//        for (int n : numbers) {
//            bucket[n]++;
//        }
//        //找到第一个计数为1的下标即可
//        for (int i = 0 ; i < bucket.length ; i++) {
//            if (bucket[i] == 1){
//                return i;
//            }
//        }


        /**
         * 解法2：遍历法
         * 由题可见，输入为一个增序数组的一个旋转
         * 则该数组前若干内容为增序（可能为0）
         * 则遍历数组，找到相比下一个值大的数组，则下一个值最小
         * 最坏时间复杂度为 n ，即为0的情况，遍历了整个数组，发现第一个最棒
         * 空间复杂度 1
         *
         * LeetCode 2020-11-03 时间0ms，击败100%，内存38.3M,击败87.64%
         *
         */
//
//        for (int i = 0;i < numbers.length ; i++) {
//
//            if (i == numbers.length - 1) {
//                return numbers[0];
//            }
//
//            if (numbers[i] > numbers[i + 1]) {
//                return numbers[i + 1];
//            }
//
//        }


        /**
         * 解法3：双指针 二分查找
         * 题目目标是找数组中的旋转点，即将数组以旋转点二分，找到右排序数组中的第一个元素
         * 将遍历法的线性时间复杂度降低到对数级别
         *
         * 左右指针均比较相邻数值，最差直到相遇才找到交换点，少了一半的路程
         * 最好是在一开始就发现了情况，相当于避免了直接遍历法的最坏
         *
         *
         * 时间复杂度 log n
         * 空间复杂度 1
         *
         */

        int j ;

        for (int i = 0;i < numbers.length ; i++) {
            j = numbers.length - 1 - i;

            //还需要考虑更多边界情况，包括相遇、在两头
            if (numbers[j] < numbers[j-1]) return numbers[j];            if (numbers[j] < numbers[j-1]) return numbers[j];
            if (numbers[i] > numbers[i+1]) return numbers[i+1];
            if (numbers[j] < numbers[j-1]) return numbers[j];

        }






        /**
         * 解法4：堆排序
         *
         * 手写小顶堆
         *
         */




        return 0;
    }


    /**
     * 力扣1480：一维数组动态和
     * 给出一个数组nums 动态和计算公式为：runningSum[i] = sum(nums[0]...nums[i])
     * 如输入数组nums = [1,2,3,4],输出为[1,1+2,1+2+3,1+2+3+4]
     * 数组内值在-10^6-10^6 数据量较大
     *
     */
    public int[] runningSum(int[] nums){

        //可知结果数组长度与原数组一样
        //数组的取用十分快
        //遍历一次长度，取值相加，每次取值为一次操作的话，可见每次操作都要取之前的值，时间和空间复杂度都高
        //观察可见，每个操作的值都是前一次操作加本次操作，所以记录前一次的值不需要重头算起，时间复杂度省下
        //观察可见，既然每次都不需要从头算起，那么之前的数就没意义，意义聚焦在前一个算数上，所以可以直接操作原数组，空间复杂度省下

        //结果：2020/11/17 0ms 击败100% ， 38.5m，击败90.36%
        for (int i = 0 ; i < nums.length ; i++){
            if (i == 0){
                continue;
            }
            nums[i] = nums[i-1] + nums[i];
        }

        return nums;
    }


    /**
     * 力扣1470：重新排列数组
     * 给出一个数组nums 元素2n个 按[x1,x2...xn,y1,y1...yn]格式排列
     * 将数组按照[x1,y1,x2,y2...xn.yn]格式排列
     * 数组长度恒等于2n
     *
     */
    public int[] shuffle(int[] nums,int n){

        //如果使用新数组放置元素，则空间复杂度n
        //且遍历数组需要至少一次，使用双指针时间复杂度也为n
        //如果在原数组插入元素，数组插入元素困难，时间更为漫长
        //考虑在原数组替换元素则与插入类似，如果直接替换则会覆盖导致错误，替换前面的会导致后面的需要替换

        //法一，新数组双指针法
        //结果：2020/11/17 耗时1ms 击败21.47%， 内存38.7M，击败76.91%
        //从性能上看，还有很大提升空间
//        int[] result = new int[2*n];
//        int j = n;
//        int i = 0;
//        boolean k = true;
//        for (int m = 0 ; m < 2 * n ; m ++){
//
//            //交替
//            if (k){
//                result[m] = nums[i];
//                i++;
//            }else {
//                result[m] = nums[j];
//                j++;
//            }
//            k = !k;
//        }


        //法2：新数组数学规律法（关注奇偶）
        //结果：2020/11/17 0ms 击败100% ， 38.6M，击败84.21%
        //其敏锐发现了奇偶和前后半部分位置的关系，虽然这一点其实显而易见，但是仔细观察最后付诸实践，逻辑精炼
        // 虽然很不服气，但是没做到的就是没练好，必须记下思维特点，另外还要更有耐性，把思考精简，归纳。
        // 要知道，问题必然有着优雅的解法，不要放过优雅的开发自己的机会！
//        int[] result = new int[2*n];
//        for (int i = 0 ; i < n ; i ++ ){
//            result[i*2] = nums[i];
//            result[i*2+1] = nums[n+i];
//        }
        //每个偶数位置存原来的前半部分数，每个计数位置存原来的后半部分数，且顺序不变（头脑）

        //法3：利用int字节法，节省空间
        //int 数字存储32个字节，而题目中数字的范围只在1000以内，最多占用(2^10 - 1 = 1023 > 1000),10个字节
        //利用剩下中的10个字节做存储
        //具体实现中,每个数字都默认用最低10位存储，则使用再高的10位存储正应该排在这个位置的数字，最后再将这玩意遍历出来
        //并结合法2，尽量降低时间
        for (int i = 0; i < n ; i ++){

            //不要改变待改变的值
            //每次赋值使用低10位的值，每次接收值都使用高了10位值
            nums[i*2] = (nums[i] << 10) + ((nums[i*2] << 22) >> 22);
            nums[i*2+1] = (nums[n+i] << 10) + ((nums[i*2+1] << 22) >> 22);
        }

        for (int i :nums) {
            i = i >> 10;
        }

        return nums;
    }


    /**
     * 力扣1512：好数对的数目
     * 给出一个数组nums，如果里面有一组数字满足 nums[i] = nums[j] 且i < j 就是一个好数对
     * 要求给出好数对的数目
     */
    public int numIdenticalPairs(int[] nums){

        /**
         * 暴力遍历法
         * 2020/11/18 1ms，击败82.41% 38.1M 击败59.43%
         *
         */
        //计数器
        int result = 0;

        for (int i = 0; i < nums.length ; i ++){

            for (int j = i + 1 ; j < nums.length ; j ++){
                if (nums[j] == nums[i]){
                    result++;
                }
            }
        }
        return result;
    }

    /**
     * 力扣1431：拥有最多糖的小孩
     * 给出一个数组candies和一个整数extraCandies ，数组中candies[i]代表第i个孩子拥有的糖果数
     * 对每一个孩子，检查是否存在一个方案，将额外的糖分配给孩子后，该孩子拥有最多糖果，允许多个孩子同时拥有最多糖果
     * 如[2,3,5,1,3] 3
     * 输出[true,true,true,false,true]
     *
     */
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies){


        /**
         * 最大值法，找到分配额外糖果前孩子有最多糖果的数目，即数组最大值
         * 遍历数组判断与最大值的差距可知结果
         * 糖果数是正整数
         * 2020/11/18 1ms击败99.80% 38.8M 击败55.58%
         */
        List<Boolean> result = new ArrayList<>();
        int max = 0;

        //遍历一次找到最大值
        for(int i = 0 ; i < candies.length ; i ++){
            if (candies[i] > max){
                max = candies[i];
            }
        }

        //再遍历一次得到结果
        for(int i = 0 ; i < candies.length ; i ++){
            if (candies[i] + extraCandies >= max){
                result.add(true);
            }else {
                result.add(false);
            }
        }

        return result;

    }

    /**
     * 程序员面试金典 面试题08.03 魔术索引
     * 数组A中，如果A[i] = i ;则称i为魔术索引
     * 给出一个有序整数数组，找出魔术索引，有的话返回，没有则返回-1，有多个则返回索引最小的一个
     *
     */
    public int findMagicIndex(int[] nums){

        //直接遍历
        //2020/1/18 1ms 击败51.89% 39.2M 击败79.55%
//        for (int i = 0 ; i < nums.length ; i ++){
//            if (nums[i] == i){
//                return i;
//            }
//        }

        //法二：二分减枝
        //二分法判断中间值是否满足要求，满足则从继续从左边找
        //不满足则回到右边找
        //左右分别处理，其实已经是分治法了 唉 牛皮
        //最坏情况下时间空间都是n，遍历栈深度n
        //2020/11/18 0ms 击败100% 38.9M 击败97.23%
        return getAnswer(nums, 0, nums.length - 1);


        //失败的法3：企图使用有序条件找到第一个不合法数加条件，使得后面数均论证为不合法从而剪枝
        //但是这个非严格的有序数组输入使得A[i] - i的值呈现为[0,-1,-1,0,-1,0]的无序性，导致不成功

    }
    public int getAnswer(int[] nums, int left, int right) {
        if (left > right) {
            return -1;
        }
        int mid = (right - left) / 2 + left;
        int leftAnswer = getAnswer(nums, left, mid - 1);
        if (leftAnswer != -1) {
            return leftAnswer;
        } else if (nums[mid] == mid) {
            return mid;
        }
        return getAnswer(nums, mid + 1, right);
    }

    /**
     *
     */


}
