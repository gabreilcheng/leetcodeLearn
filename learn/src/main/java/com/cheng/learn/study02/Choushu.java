package com.cheng.learn.study02;

/**
 * 丑数：https://leetcode-cn.com/problems/chou-shu-lcof/submissions/
 * 我们把只包含因子 2、3 和 5 的数称作丑数.
 */
public class Choushu {

    /**
     * 使用动态规划：
     * 合并 3 个有序序列， 最简单的方法就是每一个序列都各自维护一个指针，
     * 然后比较指针指向的元素的值， 将最小的放入最终的合并数组中， 并将相应指针向后移动一个元素
     */
    public int nthUglyNumber(int n) {
        //丑数
        int a = 0, b = 0, c = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int i = 1;i < n;i++) {
            int n1 = dp[a] * 2, n2 = dp[b] * 3, n3 = dp[c] * 5;
            dp[i] = Math.min(Math.min(n1, n2), n3);
            if(dp[i] == n1) {a++;}
            if(dp[i] == n2) {b++;}
            if(dp[i] == n3) {c++;}
        }
        return dp[n - 1];
    }
}
