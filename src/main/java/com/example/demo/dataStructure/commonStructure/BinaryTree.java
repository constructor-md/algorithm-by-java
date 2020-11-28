package com.example.demo.dataStructure.commonStructure;

import com.example.demo.entity.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree {

    public static void main(String[] args) {

        TreeNode root = new TreeNode();

        List<Integer> result = new ArrayList<>();

        preOrderTraversalByRecursion(result, root);

        System.out.println(result);
    }


    /**
     * 二叉树的前序遍历-递归
     * 输入二叉树根节点、输出该树的前序遍历
     * 0ms,36.3M 2020/11/22 100% 94.64% （36。3-36.8）波动与执行相关
     */
    public static void preOrderTraversalByRecursion(List<Integer> result, TreeNode root) {

        //为空则不执行
        if (root == null){
            return;
        }
        //先写入根节点、再写入左节点、右节点
        result.add(root.getVal());
        preOrderTraversalByRecursion(result, root.getLeft());
        preOrderTraversalByRecursion(result, root.getRight());

    }

    /**
     * 二叉树的前序遍历-迭代
     * 输入二叉树根节点、输出该树的前序遍历
     */
    public static List<Integer> preOrderTraversalByInteraction(TreeNode root) {

        //迭代方法

        return null;
    }


    /**
     * 二叉树的中序遍历-递归
     * 输入二叉树根节点、输出该树的中序遍历
     */
    public static void inorderTraversalByRecursion(List<Integer> result, TreeNode root) {

        //为空则不执行
        if (root == null){
            return;
        }
        //先写入左节点、再写入根节点、右节点（左右节点的判空在左右节点作为跟节点遍历时执行）
        inorderTraversalByRecursion(result, root.getLeft());
        result.add(root.getVal());
        inorderTraversalByRecursion(result, root.getRight());
    }

    /**
     * 二叉树的后序遍历-递归
     * 输入二叉树根节点、输出该树的后序遍历  三者遍历提交结果相差无几
     */
    public static void postOrderTraversalByRecursion(List<Integer> result, TreeNode root){

        //为空则不执行
        if (root == null){
            return;
        }
        //先写入左节点、再写入右节点、根节点（左右节点的判空在左右节点作为跟节点遍历时执行）
        postOrderTraversalByRecursion(result, root.getLeft());
        postOrderTraversalByRecursion(result, root.getRight());
        result.add(root.getVal());

    }

    /**
     * 二叉树的层序遍历
     * 输入二叉树根节点、输出该树的层序遍历
     * 迭代解法-双队列
     */
    public static List<List<Integer>> layerOrderByDoubleQueue(TreeNode root){

        List<List<Integer>> lists = new ArrayList<>();

        return lists;
    }

    /**
     * 二叉树的层序遍历
     * 输入二叉树根节点、输出该树的层序遍历 返回一个二维数组区分层
     * 迭代解法-广度优先搜索
     */
    public static List<List<Integer>> layerOrderByBFS(TreeNode root){

        List<List<Integer>> lists = new ArrayList<>();






        return lists;
    }

}
