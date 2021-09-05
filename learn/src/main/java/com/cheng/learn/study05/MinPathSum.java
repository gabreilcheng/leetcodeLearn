package com.cheng.learn.study05;

/**
 * https://leetcode-cn.com/problems/minimum-path-sum/
 * 64. 最小路径和
 * 时间复杂度： O(N)
 */
public class MinPathSum {

    //没有开新的空间，使用原有数组。 拆解成子问题，写出三种情况的公式
    public int minPathSum(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (i == 0 && j == 0) { continue; }
                if(i == 0) {
                    grid[i][j] = grid[i][j] + grid[i][j-1];
                } else if (j == 0) {
                    grid[i][j] = grid[i][j] + grid[i-1][j];
                } else {
                    grid[i][j] = Math.min(grid[i-1][j], grid[i][j-1]) + grid[i][j];
                }
            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }
}
