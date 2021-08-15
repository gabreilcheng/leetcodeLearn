package com.cheng.learn.study02;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 树的层序遍历
 */
public class SeqTraversal {

    /**
     * 比较通用的方法
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> ans = new ArrayList<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> t = new ArrayList<>();
            for(int i = 0; i < size; i++){
                Node node = q.poll();
                if(node == null) continue;
                t.add(node.val);
                //如果是二叉树只需要放左右子树即可
                for(Node no : node.children){
                    q.offer(no);
                }
            }
            // 防止空列表加入答案
            if(t.size() > 0) ans.add(t);
        }
        return ans;
    }
}
