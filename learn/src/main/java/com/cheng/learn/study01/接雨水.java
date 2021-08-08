package com.cheng.learn.study01;

import java.util.Stack;

public class 接雨水 {

    public int trap(int[] height) {
        int res = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i =0;i<height.length;i++) {
            while(!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int curr = stack.peek();
                stack.pop();
                if(stack.isEmpty()) {break; }
                int left = stack.peek();
                int right = i;
                int w = Math.min(height[left],height[right]) - height[curr];
                res += w * (right - left -1);
            }
            stack.push(i);
        }
        return res;
    }
}
