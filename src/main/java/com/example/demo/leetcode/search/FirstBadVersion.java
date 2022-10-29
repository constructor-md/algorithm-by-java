package com.example.demo.leetcode.search;

/**
 * leetcode 278 找到第一个错误的版本
 * 给定一个检查版本号正误的方法，给定一个最大版本号n，1-n作为版本号列表
 * 错误的版本号之后的版本均为错误，要求找到第一个错误的版本
 * 折半查找，错误的集中在右边
 *
 *
 */
public class FirstBadVersion extends VersionControl{

    public int firstBadVersion(int n) {

        int left = 1;
        if (isBadVersion(left)) {
            return left;
        }
        int right = n;
        while (right - left > 1) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        if (isBadVersion(left)) {
            return left;
        }else {
            return right;
        }

    }

}
class VersionControl {
    public boolean isBadVersion(int version){
        return true;
    }
}
