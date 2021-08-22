package com.cheng.learn.study03;

import java.util.HashMap;
import java.util.Map;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 * https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 时间复杂度： 空间复杂度：
 *
 * preorder = [3,9,20,15,7]
 * inorder = [9,3,15,20,7]
 * 首先根据 preorder 找到根节点是 3
 *
 * 然后根据根节点将 inorder 分成左子树和右子树
 * 左子树
 * inorder [9]
 *
 * 右子树
 * inorder [15,20,7]
 *
 * 把相应的前序遍历的数组也加进来
 * 左子树
 * preorder[9]
 * inorder [9]
 *
 * 右子树
 * preorder[20 15 7]
 * inorder [15,20,7]
 *
 * 现在我们只需要构造左子树和右子树即可，成功把大问题化成了小问题
 * 然后重复上边的步骤继续划分，直到 preorder 和 inorder 都为空，返回 null 即可
 */
public class BuildTree {

    public TreeNode buildTree(int[] preorder,int[] inorder) {
        //先把中序遍历存起来, 用于快速定位根节点
        Map<Integer,Integer> map = new HashMap<>();
        for(int i =0;i < inorder.length;i++) {
            map.put(inorder[i],i);
        }
        TreeNode node = buildTreeHelper(preorder,0,preorder.length,inorder,0,inorder.length,map);
        return node;
    }

    public TreeNode buildTreeHelper(int[] preorder,int preStart,int preEnd, int[] inorder,int inStart,int inEnd,Map<Integer,Integer> map) {
        //构造二叉树，其实是前序遍历
        if(preStart == preEnd) {
            return null;
        }
        //前序遍历中的第一个节点就是根节点
        TreeNode root = new TreeNode(preorder[preStart]);
        // 在中序遍历中定位根节点
        int i_root_index = map.get(root.val);
        // 得到左子树中的节点数目
        int leftNum = i_root_index - inStart;
        //递推公式
        // 递归地构造左子树，并连接到根节点
        // 先序遍历中「从 左边界+1 开始的 size_left_subtree」个元素就对应了中序遍历中「从 左边界 开始到 根节点定位-1」的元素
        root.left = buildTreeHelper(preorder,preStart+1,preStart+leftNum +1,inorder,inStart,i_root_index,map);
        // 递归地构造右子树，并连接到根节点
        // 先序遍历中「从 左边界+1+左子树节点数目 开始到 右边界」的元素就对应了中序遍历中「从 根节点定位+1 到 右边界」的元素
        root.right = buildTreeHelper(preorder,preStart+leftNum +1,preEnd,inorder,i_root_index +1,inEnd,map);
        return root;
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
