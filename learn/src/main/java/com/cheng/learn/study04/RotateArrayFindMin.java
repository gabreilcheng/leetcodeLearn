package com.cheng.learn.study04;

/**
 * 153. 寻找旋转排序数组中的最小值
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 * 时间复杂度：O(logn) 空间复杂度: O(1)
 */
public class RotateArrayFindMin {

    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length -1;
        while(left < right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > nums[right]) {
                left = mid + 1;
            }else {
                right = mid;
            }
        }
        return nums[left];
    }


}
