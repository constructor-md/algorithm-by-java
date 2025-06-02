package com.example.demo.leetcode.map;

import java.util.LinkedList;

/**
 * leetcode 200 岛屿数量
 * 给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
 * <p>
 * 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
 * <p>
 * 此外，你可以假设该网格的四条边均被水包围。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：grid = [
 * ["1","1","1","1","0"],
 * ["1","1","0","1","0"],
 * ["1","1","0","0","0"],
 * ["0","0","0","0","0"]
 * ]
 * 输出：1
 * 示例 2：
 * <p>
 * 输入：grid = [
 * ["1","1","0","0","0"],
 * ["1","1","0","0","0"],
 * ["0","0","1","0","0"],
 * ["0","0","0","1","1"]
 * ]
 * 输出：3
 */
public class NumsIsland {


    /**
     * 深度优先搜索
     * 遍历所有节点，找到 1 就以此为根节点开启深度优先搜索
     * 深度优先搜索遇到数组边界或 0 就返回
     * 并且将所有搜索过的位置 置为 0
     * 也就是在最外层找到一个岛屿的根节点，就深度搜索这个岛屿的全部点 予以清除
     * 然后继续找下一个岛屿的根节点
     * 所以能够开启深度优先搜索的根节点的数量，就是岛屿的数量
     * 杀岛术
     *
     * 深度优先搜索 -- 递归
     * 找到一个点，关联点 1 2
     * 递归找 1 关联的的下一个点，直到结束递归
     * 再开启 2 关联的下一个点，直到结束递归
     * ...
     *
     * 二叉树的前中后序遍历就是深度优先搜索
     * 前序遍历：根节点 -> 左子树 -> 右子树
     * 中序遍历：左子树 -> 根节点 -> 右子树
     * 后序遍历：左子树 -> 右子树 -> 根节点
     * 含义是根节点第几个访问
     *
     * 都是给出根节点
     * 只不过递归时候向下传递记录数组
     * 在每次递归中，按顺序选择
     *  前序：先填入根节点，递归填入左子树，再递归填入右子树 直到节点为空
     *  中序：先递归填入左子树，再填入根节点，再递归填入右子树 直到节点为空
     *  后序：先递归填入右子树，递归填入左子树，再填入根节点 直到节点为空
     *
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int result = 0;
        // 遍历所有点
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0') continue;
                // 找到 1 ，开始深度搜索岛屿的全部点 全部清理掉
                dfs(grid, i, j);
                result++;
            }
        }
        return result;
    }

    public void dfs(char[][] grid, int i, int j) {
        // 遇到边界就停止
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[i].length || grid[i][j] == '0') return;

        // 不是边界就是岛屿本身，予以清除
        grid[i][j] = '0';
        // 继续搜索各个连接点
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }

    /**
     * 广度优先搜索
     * <p>
     * 也就是搜索岛屿的方式不同
     * 还是杀岛法，清理岛屿的点，并记录开启深度优先搜索的根节点个数即为岛屿个数
     *
     * 广度优先搜索 -- 迭代 + 队列
     * 将需要的搜索的点入队
     * 遍历队列直到为空
     * 将栈中的点的下一层全部取出入队，在后续遍历取出并继续入队
     * 从而每次整层入队，每次遍历的都是一层一层的向下
     *
     * 二叉树的层序遍历就是广度优先搜索
     */
    public int numIslands1(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int result = 0;
        // 遍历所有点
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '0') continue;
                // 找到 1 ，开始广度搜索岛屿的全部点 全部清理掉
                result++;
                // 使用一个队列存储当前层的节点，并逐一出栈查找
                // 出栈元素查找过程再把关联的下一层元素入栈
                // 从左上到右下，避免回头
                LinkedList<int[]> stack = new LinkedList<>();
                stack.addFirst(new int[]{i, j});
                // 遍历到栈为空即可
                while (!stack.isEmpty()) {
                    int[] location = stack.removeLast();
                    int xIndex = location[0];
                    int yIndex = location[1];
                    // 超过边界的不继续遍历
                    if (xIndex < 0 || yIndex < 0
                            || xIndex >= grid.length || yIndex >= grid[xIndex].length
                            || grid[xIndex][yIndex] == '0') continue;
                    // 将 1 点置为 0
                    grid[xIndex][yIndex] = '0';
                    // 并将下一层点入栈进行下次遍历
                    stack.addFirst(new int[]{xIndex + 1, yIndex});
                    stack.addFirst(new int[]{xIndex - 1, yIndex});
                    stack.addFirst(new int[]{xIndex, yIndex + 1});
                    stack.addFirst(new int[]{xIndex, yIndex - 1});
                }
            }
        }
        return result;
    }
}
