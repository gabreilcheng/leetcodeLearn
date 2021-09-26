package com.cheng.learn.week08;

/**
 * 547. 省份数量
 * https://leetcode-cn.com/problems/number-of-provinces/
 */
public class FindCircleNum {
    /**
     * 并查集是一种数据结构
     * 并查集这三个字，一个字代表一个意思。
     * 并（Union），代表合并
     * 查（Find），代表查找
     * 集（Set），代表这是一个以字典为基础的数据结构，它的基本功能是合并集合中的元素，查找集合中的元素
     * 并查集的典型应用是有关连通分量的问题
     * 并查集解决单个问题（添加，合并，查找）的时间复杂度都是O(1)O(1)
     * 因此，并查集可以应用到在线算法中
     */
    public int findCircleNum(int[][] isConnected) {
        int provinces = isConnected.length;
        int[] parent = new int[provinces];
        for (int i = 0; i < provinces; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < provinces; i++) {
            for (int j = i + 1; j < provinces; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            if (parent[i] == i) {
                circles++;
            }
        }
        return circles;
    }

    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }



}
