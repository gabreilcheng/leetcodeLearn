package com.cheng.learn.study01;

import java.util.Arrays;

/**
 * 考察多种解法的实现性，找到最好的解法
 * 此题有三种解法，
 */
public class 数组翻转 {

    public void rotate(int[] nums, int k) {
        //第一种解法：数组翻转
        k %= nums.length;
        reverse(nums,0,nums.length-1);
        reverse(nums,0,k-1);
        reverse(nums,k,nums.length-1);

    }

    public void reverse(int[] nums,int start,int end) {
        while(start < end) {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start ++;
            end --;
        }

    }

    //第二种解法，直接新建一个数组
    public static void rotate2(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; i++) {
            newArr[(i+k) % n] = nums[i];
        }
        System.arraycopy(newArr,0,nums,0,n);
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        rotate2(arr,3);
        System.out.println(Arrays.toString(arr));
    }


}
