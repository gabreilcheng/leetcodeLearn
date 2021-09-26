package com.cheng.learn.week08;

/**
 * 191. 位1的个数
 * https://leetcode-cn.com/problems/number-of-1-bits/
 */
public class hammingWeight {

    public int hammingWeight(int n) {
        // int count = 0;
        // for (int i = 0; i < 32; ++i) {
        //     count += n & 1;
        //     n >>= 1;
        // }
        // return count;

        int count = 0;
        while (n != 0) {
            count ++;
            n = n & (n - 1);
        }
        return count;
    }

}
