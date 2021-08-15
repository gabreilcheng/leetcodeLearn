package com.cheng.learn.study02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

/**
 * 二叉树问题其实是比较相似的，可以总结为一套模板
 * https://leetcode-cn.com/problems/n-ary-tree-preorder-traversal/solution/yi-tao-quan-fa-shua-diao-nge-bian-li-shu-de-wen--3/
 */
public class BinaryTree {


    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        reverseNode(root, list);
        return list;
    }
    public void reverseNode(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        root.children.forEach(child -> reverseNode(child, list));
    }

    public List<Integer> postorder(Node root) {
        List<Integer> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            list.add(node.val);
            for (int i = node.children.size() - 1; i >= 0;i++) {
                stack.push(node.children.get(i));
            }
        }
        Collections.reverse(list);
        return list;
    }

}
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
