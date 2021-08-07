package com.cheng.learn.study01;

public class 合并两个有序数组 {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m-1 , j=n-1;
        int k = m+n-1;
        int cur;
        while(i>=0 || j>=0) {
            if(i == -1) {
                cur = nums2[j--];
            }else if(j == -1) {
                cur = nums1[i--];
            }else if(nums2[j] > nums1[i]){
                cur = nums2[j--];
            }else {
                cur = nums1[i--];
            }
            nums1[k--] = cur;
        }

    }

}
