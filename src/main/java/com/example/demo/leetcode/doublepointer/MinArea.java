package com.example.demo.leetcode.doublepointer;

/**
 * leetcode 11
 * 盛水最少的容器
 *
 * 使用双指针，每次移动记录指向值小的那个指针，每次记下更新最大值
 * 最后得到的就是最大值
 *
 * 证明：
 *  面积S=min(y1, y2) * (x1 - x2)
 *  假设y1 < y2：S = y1 * (x1 - x2)
 *      如果移动y1，则（x1 - x2）变小，此时如果y1变大，则面积S变化不一定；如果y1变小，则面积变小
 *      如果移动y2，则（x1 - x2）变小，此时如果y2变大，面积S仍是y1决定，不变；如果y2变小，则面积可能变小或相等
 *  故，每次移动指针，只能移动指向值小的那个，才有可能得到每次的最大值，最终结果将在这些最大值中取最大值
 *
 *  这个证明看似其实不严谨，因为只取了每次最大，却无法说明在同一个(x1 - x2)长度条件下，移动这个框，为什么不能找到另一组下限更高的边
 *  假设从双指针最开始，拿着框左右扫描
 *  第一次动弹不得，按证明移动小指针（假设在左边）期望获取更大值
 *  第二次，可以向左移动，则结果变成了第一步向右移动的结果，要么记录过，要么更小。于是保持现状，这是个新数组了。
 *  重复第一次和第二次，最终获得全部最大状态。
 *
 *  暂且论定，希望有反证法出现
 *
 */
public class MinArea {

    public static int maxArea(int[] height) {

        int result = 0;
        int i = 0;
        int j = height.length-1;
        while (i <= j) {
            result = Math.max((j - i) * Math.min(height[i], height[j]), result);
            if (height[i] <= height[j]) {
                i++;
            } else {
                j--;
            }
        }
        return result;

    }

    public static void main(String[] args) {

    }




}
