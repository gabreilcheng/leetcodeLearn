package com.cheng.learn.study03;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 46. 全排列
 * https://leetcode-cn.com/problems/permutations/
 */
public class Permute {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> outList = new ArrayList<>();
        //先存放到一个list中
        for(int i = 0; i< nums.length;i++){
            outList.add(nums[i]);
        }
        int len = nums.length;
        backtrack(len,outList,list,0);
        return list;
    }
    public void backtrack(int len,List<Integer> outList,List<List<Integer>> res,int first){
        if(first == len) {
            res.add(new ArrayList<Integer>(outList));
        }
        for(int i = first;i< len;i++) {
            Collections.swap(outList,first,i);
            backtrack(len,outList,res,first+1);
            Collections.swap(outList,first,i);
        }
    }
}
