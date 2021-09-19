package com.cheng.learn.study07;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(0,0,"", n, result);
        return result;
    }

    public void dfs(int left, int right, String s, int n, List<String> result) {
        if(left == n && right == n) {
            result.add(s);
            return;
        }
        //剪枝
        if(left < n) {
            dfs(left+1, right, s + "(", n, result);
        }
        if(right < left) {
            dfs(left, right + 1, s+")", n, result);
        }
    }
}
