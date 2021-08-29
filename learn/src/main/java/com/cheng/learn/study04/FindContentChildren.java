package com.cheng.learn.study04;

import java.util.Arrays;

/**
 *
 */
public class FindContentChildren {

    //方法一：从后向前遍历小孩数组，用大饼干优先满足胃口大的，并统计满足小孩数量
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int index = s.length - 1;
        int result = 0;
        for(int i = g.length - 1; i >= 0; i--) {
            if(index >= 0 && s[index] >= g[i]) {
                index --;
                result ++;
            }
        }
        return result;
    }

    //方法二： 小饼干先喂饱小胃口
    public int findContentChildren2(int[] g, int[] s) {
        //s 是饼干数组 g是孩子胃口数组
        Arrays.sort(g);
        Arrays.sort(s);
        int index = 0;
        for(int i = 0; i < s.length; i++) {
            if(index < g.length && s[i] >= g[index]) {
                index ++;
            }
        }
        return index;
    }




}
