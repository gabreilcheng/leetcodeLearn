package com.cheng.learn.study05;

/**
 * 552. 学生出勤记录 II
 * https://leetcode-cn.com/problems/student-attendance-record-ii/
 */
public class CheckRecord {

    class Solution {
        int mod = (int)1e9+7;
        int[][][] cache;
        public int checkRecord(int n) {
            cache = new int[n + 1][2][3];
            for (int i = 0; i <= n; i++) {
                for (int j = 0; j < 2; j++) {
                    for (int k = 0; k < 3; k++) {
                        cache[i][j][k] = -1;
                    }
                }
            }
            return dfs(n, 0, 0);
        }
        int dfs(int u, int acnt, int lcnt) {
            if (acnt >= 2) return 0;
            if (lcnt >= 3) return 0;
            if (u == 0) return 1;
            if (cache[u][acnt][lcnt] != -1) return cache[u][acnt][lcnt];
            int ans = 0;
            ans = dfs(u - 1, acnt + 1, 0) % mod; // A
            ans = (ans + dfs(u - 1, acnt, lcnt + 1)) % mod; // L
            ans = (ans + dfs(u - 1, acnt, 0)) % mod; // P
            cache[u][acnt][lcnt] = ans;
            return ans;
        }
    }

}
