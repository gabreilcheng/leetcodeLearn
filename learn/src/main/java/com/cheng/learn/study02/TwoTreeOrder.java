package com.cheng.learn.study02;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的前中后遍历
 * 两种思路：递归和迭代
 */
public class TwoTreeOrder {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        return list;

    }
    //中序遍历
    public void inorder(TreeNode root ,List<Integer> res) {
        if(root == null) {
            return;
        }
        inorder(root.left, res);
        res.add(root.val);
        inorder(root.right, res);
    }
    //======================================================
    //前序遍历
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preOrder(root, list);
        return list;
    }

    public void preOrder(TreeNode root, List<Integer> list) {
        if(root == null) { return;}
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }
    //===============================================
    public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();
            list.add(node.val);
            //判断右节点
            if(node.right !=null){
                stack.push(node.right);
            }
            if(node.left != null){
                stack.push(node.left);
            }

        }
        return list;
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