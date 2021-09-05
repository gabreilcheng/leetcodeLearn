package com.cheng.learn.study05;

/**
 *
 */
public class MinDistance {

    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        // 第一行
        for (int j = 1; j <= n2; j++) dp[0][j] = dp[0][j - 1] + 1;
        // 第一列
        for (int i = 1; i <= n1; i++) dp[i][0] = dp[i - 1][0] + 1;

        for (int i = 1; i <= n1; i++) {
            for (int j = 1; j <= n2; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) dp[i][j] = dp[i - 1][j - 1];
                else dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
            }
        }
        return dp[n1][n2];
    }

    public int minDistance2(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] dp = new int[len1 + 1][len2 + 1];
        for(int i = 0;i < len1 + 1;i++){
            for(int j = 0;j < len2 + 1;j++){
                if (Math.min(i, j) == 0) {//初始化数组的第一行与第一列
                    dp[i][j] = Math.max(i, j);
                }else{
                    int ic = dp[i][j - 1] + 1;//插入字符所产生的距离
                    int dc = dp[i - 1][j] + 1;//删除字符所产生的距离
                    int sc = 0;//替换字符所产生的距离
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        sc = dp[i - 1][j - 1];//两字符相等就不用替换
                    }else {
                        sc = dp[i - 1][j - 1] + 1;//两字符不相等需要替换
                    }
                    dp[i][j] = Math.min(ic, Math.min(dc, sc));
                }
            }
        }
        return dp[len1][len2];
    }


}
