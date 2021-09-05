package com.cheng.learn.study05;

/**
 * 221. 最大正方形
 * https://leetcode-cn.com/problems/maximal-square/
 * 时间复杂度：O(mn)O(mn) , 空间复杂度：O(mn)O(mn)
 */
public class MaximalSquare {

    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dp = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(
                                Math.min(dp[i - 1][j], dp[i][j - 1]),
                                dp[i - 1][j - 1]
                        ) + 1;
                    }
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        int maxSquare = maxSide * maxSide;
        return maxSquare;
    }


}
