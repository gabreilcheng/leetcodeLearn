package com.cheng.learn.study02;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和：https://leetcode-cn.com/problems/two-sum/description/
 */
public class TwoNumSum {

    /**
     * 利用了hashmap的思想，比较经典
     * @param nums
     * @param target
     * @return
     */
    public int[] twoSum(int[] nums, int target) {
        //两数之和
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0;i < nums.length;i++) {
            int tmp = target - nums[i];
            if(map.containsKey(tmp)) {
                return new int[]{map.get(tmp),i};
            }

            map.put(nums[i], i);
        }
        return null;
    }
}
