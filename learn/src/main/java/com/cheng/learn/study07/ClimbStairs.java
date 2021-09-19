package com.cheng.learn.study07;

import java.util.HashMap;
import java.util.Map;

/**
 * 70. 爬楼梯
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 时间复杂度：O(N) 空间复杂度：O(N)
 */
public class ClimbStairs {

    public int climbStairs(int n) {
         //递归
         Map<Integer,Integer> map = new HashMap<>();
         if(n == 1) { return 1;}
         if(n == 2) { return 2;}
         if(map.containsKey(n)) {
             return map.get(n);
         }
         int sum = climbStairs(n - 1) + climbStairs(n-2);
         map.put(n, sum);
         return sum;
    }

    public int climbStairs1(int n) {
        //动态规划
         int[] dp = new int[n+1];
         dp[0] = 1;
         dp[1] = 1;
         for(int i = 2;i <= n; i++) {
             dp[i] = dp[i-1] + dp[i-2];
         }
         return dp[n];
    }

    //优化版
    public int climbStairs2(int n) {
        if(n <= 2) {
            return n;
        }
        int f1 = 1, f2 = 2, f3 = 3;
        for (int i = 3;i <= n;i++) {
            f3 = f1 + f2;
            f1 = f2;
            f2 = f3;
        }
        return f3;
    }
}
