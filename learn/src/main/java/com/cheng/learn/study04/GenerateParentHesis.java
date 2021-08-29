package com.cheng.learn.study04;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * https://leetcode-cn.com/problems/generate-parentheses/#/description
 */
public class GenerateParentHesis {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        dfs(0, 0, result, n, "");
        return result;
    }

    public void dfs(int left, int right, List<String> result, int n, String s) {
        if(left == n && right == n) {
            result.add(s);
            return;
        }
        if(left < n) {
            dfs(left + 1, right, result, n, s + "(");
        }
        if(right < left) {
            dfs(left, right +1, result, n, s + ")");
        }
    }


}
