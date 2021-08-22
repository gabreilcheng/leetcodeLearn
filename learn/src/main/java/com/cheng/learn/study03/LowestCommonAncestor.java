package com.cheng.learn.study03;

/**
 * 236. 二叉树的最近公共祖先
 * https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 时间复杂度： O(N) 空间复杂度：O(N)
 */
public class LowestCommonAncestor {

    /**
     * 思路：
     * 分为三种情况：
     * a. p和q 分别再root的左右子树中
     * b. p == root,并且q在root的左/右子树中
     * c. q == root,并且p在root的左/右子树中
     *
     * 递归公式：
     * 1、终止条件
     *  如果越过叶子节点（左右子树是null），直接返回null。如果 root 等于 p, q，则直接返回 root
     * 2、递推公式
     *      开启递归左子节点，返回值记为 left
     *      开启递归右子节点，返回值记为 right
     * 3、处理结果状态
     *    当left 为空时，返回right
     *    当right 为空时，返回left
     *    当left 和right 不为空时，返回root
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == q || root == p) {return root;}
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
        if(left == null) {return right;}
        if(right == null) {return left;}
        return root;
    }
}

