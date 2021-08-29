package com.cheng.learn.study04;

import java.util.*;

public class CodeTemplate {

    public int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1, mid;
        while (left <= right) {
            mid = (right - left) / 2 + left;
            if (array[mid] == target) {
                return mid;
            } else if (array[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    //DFS 递归实现
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> allResults = new ArrayList<>();
        if(root == null) {
            return allResults;
        }
        travel(root, 0 , allResults);
        return allResults;
    }
    private void travel(TreeNode root, int level, List<List<Integer>> list) {
        if(list.size() == level) {
            return;
        }
        list.get(level).add(root.val);
        if(root.left != null) {
            travel(root.left, level + 1, list);
        }
        if(root.right != null) {
            travel(root.right, level + 1, list);
        }
    }

    //非递归实现
    public List<List<Integer>> dfsWithStack(TreeNode root) {
        return null;
    }
    //==============================================================
    //BFS
    public List<List<Integer>> bfs(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if(node.left != null) {
                    queue.add(node.left);
                }
                if(node.right != null) {
                    queue.add(node.right);
                }
            }
            result.add(list);
        }
        return result;
    }


}
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
