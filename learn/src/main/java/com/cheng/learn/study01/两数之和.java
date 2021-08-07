package com.cheng.learn.study01;

import java.util.HashMap;
import java.util.Map;

public class 两数之和 {

    public int[] twoSum(int[] nums, int target) {
        //两数之和
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++) {
            int tmp = target - nums[i];
            if(map.containsKey(tmp)) {
                return new int[]{map.get(tmp),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }


}
