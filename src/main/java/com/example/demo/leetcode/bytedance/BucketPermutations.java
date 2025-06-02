package com.example.demo.leetcode.bytedance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BucketPermutations {
    public static void main(String[] args) {
        int n = 3; // 假设有3个水桶
        List<String> colors = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            colors.add(String.valueOf((char) ('A' + i))); // 颜色用A、B、C等表示
        }
        
        List<BucketCombination> combinations = generateCombinations(colors);
        
        System.out.println("所有可能的桶身和桶盖组合方式：");
        for (int i = 0; i < combinations.size(); i++) {
            System.out.println("组合 " + (i + 1) + ": " + combinations.get(i));
        }
    }
    
    public static List<BucketCombination> generateCombinations(List<String> colors) {
        List<BucketCombination> result = new ArrayList<>();
        List<String> bodies = new ArrayList<>(colors);
        permuteBodies(bodies, 0, colors, result);
        return result;
    }
    
    private static void permuteBodies(List<String> bodies, int start, List<String> colors, 
                                     List<BucketCombination> result) {
        if (start == bodies.size()) {
            generateLidPermutations(bodies, colors, new ArrayList<>(), 0, result);
            return;
        }
        
        for (int i = start; i < bodies.size(); i++) {
            swap(bodies, start, i);
            permuteBodies(bodies, start + 1, colors, result);
            swap(bodies, start, i); // 回溯
        }
    }
    
    private static void generateLidPermutations(List<String> bodies, List<String> colors, 
                                               List<String> lids, int index, 
                                               List<BucketCombination> result) {
        if (index == bodies.size()) {
            result.add(new BucketCombination(new ArrayList<>(bodies), new ArrayList<>(lids)));
            return;
        }
        
        for (String color : colors) {
            if (!lids.contains(color)) { // 确保每个颜色只使用一次
                lids.add(color);
                generateLidPermutations(bodies, colors, lids, index + 1, result);
                lids.remove(lids.size() - 1); // 回溯
            }
        }
    }
    
    private static void swap(List<String> list, int i, int j) {
        String temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }
    
    static class BucketCombination {
        private List<String> bodies;
        private List<String> lids;
        
        public BucketCombination(List<String> bodies, List<String> lids) {
            this.bodies = bodies;
            this.lids = lids;
        }
        
        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("桶身: [");
            for (int i = 0; i < bodies.size(); i++) {
                sb.append(bodies.get(i));
                if (i < bodies.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("], 桶盖: [");
            for (int i = 0; i < lids.size(); i++) {
                sb.append(lids.get(i));
                if (i < lids.size() - 1) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            return sb.toString();
        }
    }
}    