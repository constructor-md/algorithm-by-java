package com.example.demo.leetcode.tree;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * leetcode 102 二叉树的层序遍历
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        //存放下次要遍历的层的列表
        List<TreeNode> level = new ArrayList<>(Collections.singletonList(root));
        while (level.size() != 0) {

            List<TreeNode> temp = new ArrayList<>();
            List<Integer> levelResult = new ArrayList<>();
            for (TreeNode node : level) {
                levelResult.add(node.val);
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
            }
            if (levelResult.size() != 0) {
                result.add(levelResult);
            }
            level.clear();
            level.addAll(temp);
        }


        return result;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
