package com.cheng.learn.study03;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * https://leetcode-cn.com/problems/combinations/
 * 时间复杂度：O(C(n, k) * k) 空间复杂度：O(n)
 */
public class Combine {

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if(k <= 0 || n < k) {
            return res;
        }
        Deque<Integer> deque = new LinkedList<>();
        dfs(n, k, 1, deque, res);
        return res;
    }

    public void dfs(int n, int k, int index, Deque<Integer> deque, List<List<Integer>> res) {
        //终止条件
        if(deque.size() == k) {
            res.add(new ArrayList<>(deque));
            return;
        }
        //剪枝：发现规律是 n - k + 1 + depth
        for(int i = index; i <= n - k + 1 + deque.size();i++) {
            deque.addLast(i);
            //递推公式
            dfs(n, k, i + 1, deque, res);
            deque.removeLast();
        }
    }

    //======================方法二===========================

    private List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combine2(int n, int k) {
        getCombine(n, k, 1, new ArrayList<>());
        return ans;
    }

    public void getCombine(int n, int k, int start, List<Integer> list) {
        if(k == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }
        for(int i = start;i <= n - k + 1;i++) {
            list.add(i);
            getCombine(n, k - 1, i+1, list);
            list.remove(list.size() - 1);
        }
    }

}
