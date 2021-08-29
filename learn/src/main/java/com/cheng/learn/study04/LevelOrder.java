package com.cheng.learn.study04;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102. 二叉树的层序遍历
 * https://leetcode-cn.com/problems/binary-tree-level-order-traversal/
 * 时间复杂度O(n)，空间复杂度O(n) 或者 O(h)，h 是树的高度
 * 熟练写出模板代码
 */
public class LevelOrder {

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        dfs(0, result, root);
        return result;
    }

    public void dfs(int index, List<List<Integer>> list, TreeNode root) {
        if(list.size() == index) {
            list.add(new ArrayList<Integer>());
        }
        list.get(index).add(root.val);
        if(root.left != null) {
            dfs(index + 1, list, root.left);
        }
        if(root.right != null) {
            dfs(index + 1, list, root.right);
        }
    }

    //迭代实现
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        if (root == null) {
            return ret;
        }
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            int currentLevelSize = queue.size();
            for (int i = 1; i <= currentLevelSize; ++i) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            ret.add(level);
        }
        return ret;
    }
}
