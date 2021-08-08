package com.cheng.learn.study01;

public class 删除数组中的重复元素 {

    public int removeDuplicates(int[] nums) {
        int j = 0;
        for(int i = 0;i < nums.length;i++) {
            if(nums[j] != nums[i]) {
                nums[++j] = nums[i];
            }
        }
        return j+1;
    }

}
