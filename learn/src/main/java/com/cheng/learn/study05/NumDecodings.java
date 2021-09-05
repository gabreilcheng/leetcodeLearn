package com.cheng.learn.study05;

/**
 * https://leetcode-cn.com/problems/decode-ways/
 * 91. 解码方法
 */
public class NumDecodings {

    // 动态规划：优化空间复杂度为 O(N) 时间复杂度：O(N)
    public int numDecodings(String s) {
        int n = s.length();
        s = " " + s;
        char[] cs = s.toCharArray();
        int[] f = new int[n + 1];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            // a : 代表「当前位置」单独形成 item
            // b : 代表「当前位置」与「前一位置」共同形成 item
            int a = cs[i] - '0', b = (cs[i - 1] - '0') * 10 + (cs[i] - '0');
            // 如果 a 属于有效值，那么 f[i] 可以由 f[i - 1] 转移过来
            if (1 <= a && a <= 9) f[i] = f[i - 1];
            // 如果 b 属于有效值，那么 f[i] 可以由 f[i - 2] 或者 f[i - 1] & f[i - 2] 转移过来
            if (10 <= b && b <= 26) f[i] += f[i - 2];
        }
        return f[n];
    }

    // 优化空间复杂度为 O(1) 时间复杂度：O(N)
    public int numDecodings2(String s) {
        int n = s.length();
        s = " " + s;
        char[] cs = s.toCharArray();
        int[] f = new int[3];
        f[0] = 1;
        for (int i = 1; i <= n; i++) {
            f[i % 3] = 0;
            int a = cs[i] - '0', b = (cs[i - 1] - '0') * 10 + (cs[i] - '0');
            if (1 <= a && a <= 9) f[i % 3] = f[(i - 1) % 3];
            if (10 <= b && b <= 26) f[i % 3] += f[(i - 2) % 3];
        }
        return f[n % 3];
    }

}
