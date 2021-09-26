package com.cheng.learn.week08;

/**
 * 231. 2 的幂
 * https://leetcode-cn.com/problems/power-of-two/
 */
public class IsPowerOfTwo {

    //设计很巧妙
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
