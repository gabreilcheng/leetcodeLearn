package com.cheng.learn.study02;

import java.util.*;

public class TopKFrequent {

    public static void main(String[] args) {
    }

    /**
     借助 哈希表 来建立数字和其出现次数的映射，遍历一遍数组统计元素的频率
     维护一个元素数目为 kk 的最小堆
     每次都将新的元素与堆顶元素（堆中频率最小的元素）进行比较
     如果新的元素的频率比堆顶端的元素大，则弹出堆顶端的元素，将新的元素添加进堆中
     最终，堆中的 kk 个元素即为前 kk 个高频元素
     */
    public int[] topKFrequent(int[] nums, int k) {
        if(nums.length == 0 || k == 0 || k > nums.length) {
            return nums;
        }
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>(){
            public int compare(Integer a ,Integer b) {
                return map.get(a) - map.get(b);
            }
        });
        for(Integer key : map.keySet()) {
            if(heap.size() < k) {
                heap.add(key);

            } else if(map.get(key) > map.get(heap.peek())) {
                //如果该元素大于堆顶元素
                heap.remove();
                heap.add(key);
            }
        }
        //取出最小堆的k个元素
        List<Integer> res = new ArrayList<>();
        while (!heap.isEmpty()) {
            res.add(heap.remove());
        }
        int[] arr = new int[res.size()];
        for(int i = 0;i < res.size(); i ++) {
            arr[i] = res.get(i);
        }
        return arr;
    }
}
