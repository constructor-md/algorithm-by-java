package com.example.demo.leetcode.bytedance;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * leetcode 3
 * 找出无重复字符最长子串
 * 用队列做滑动窗口，找到队列最长时的状态
 * 直到遍历完字符串
 */
public class LengthOfLongestSubstring {


    public static int lengthOfLongestSubstring(String s) {
        int result = 0;
        char[] strArr = s.toCharArray();
        //使用一个无界队列做窗口
        ConcurrentLinkedDeque<Character> queue = new ConcurrentLinkedDeque<>();
        //判断队列中元素是否重复
        Map<Character, Integer> judge = new HashMap();
        for (int i = 0; i < strArr.length; i++) {
            //先加入队列
            queue.add(strArr[i]);
            //更新Map状态
            if (judge.containsKey(strArr[i])) {
                judge.put(strArr[i], judge.get(strArr[i]) + 1);
            } else {
                judge.put(strArr[i], 1);
            }

            //判断当前队列中有无重复元素
            if (!judgeRepeat(judge)) {
                //如果没有，则最长无重复子串+1
                result++;
            } else {
                //如果有，则退出头部元素，保持长度不变，并更新Map状态
                Character removed = queue.remove();
                Integer charNum = judge.get(removed);
                //让judge始终有且仅有队列中的元素
                if (charNum == 1) {
                    judge.remove(removed);
                } else {
                    charNum--;
                    judge.put(removed, charNum);
                }
            }
        }
        return result;
    }

    //判断队列中元素是否重复
    public static boolean judgeRepeat(Map<Character, Integer> map) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() > 1) {
                return true;
            }
        }
        return false;
    }





    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
    }


}
