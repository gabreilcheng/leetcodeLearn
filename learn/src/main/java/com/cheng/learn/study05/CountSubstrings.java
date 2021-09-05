package com.cheng.learn.study05;

/**
 * 647. 回文子串
 * https://leetcode-cn.com/problems/palindromic-substrings/
 * 时间复杂度为 O(N^2)  空间复杂度为 O(N^2)
 */
public class CountSubstrings {

    public int countSubstrings(String s) {
        // 动态规划
        boolean[][] dp = new boolean[s.length()][s.length()];
        int ans = 0;

        for (int j = 0; j < s.length(); j++) {
            for (int i = 0; i <= j; i++) {
                if (s.charAt(i) == s.charAt(j) && (j - i < 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    ans++;
                }
            }
        }

        return ans;
    }


}
