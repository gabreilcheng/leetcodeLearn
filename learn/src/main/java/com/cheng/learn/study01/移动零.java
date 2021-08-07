package com.cheng.learn.study01;

public class 移动零 {

    public void moveZeroes(int[] nums) {
        int j = 0;
        for (int i = 0;i < nums.length;i++) {
            if(nums[i] != 0) {
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                j++;
            }
        }
    }
}
