package com.cheng.learn.study02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 三数之和
 *
 */
public class ThreeNumSum {

    public static void main(String[] args) {
        ThreeNumSum threeNumSum = new ThreeNumSum();
        int[] nums = new int[]{-1,0,1,2,-1,-4};
        List<List<Integer>> lists = threeNumSum.threeSum(nums);
        System.out.println(lists);
    }

    /**
     * 三数之和，双指针法
     * 需要注意的点是 去重和判断操作
     * @param nums
     * @return
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0;i < nums.length;i++) {
            int L = i + 1, R = nums.length - 1;
            if(nums[i] > 0) { return result;}
            if(i > 0 && nums[i] == nums[i-1]) { continue; }
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0) {
                    List<Integer> list = new ArrayList<>(Arrays.asList(nums[i],nums[L],nums[R]));
                    result.add(list);
                    while (L < R && nums[R] == nums[--R]);
                    while (L < R && nums[L] == nums[++L]);
                } else if(sum > 0) {
                    while (L < R && nums[R] == nums[--R]);
                } else {
                    while (L < R && nums[L] == nums[++L]);
                }
            }
        }
        return result;
    }
}
