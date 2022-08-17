package com.personal.leetcode.priorityQ;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequent_347 {
    
    //O(NlogK) if K tends to N -> O(NlogN)
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> count = new HashMap<>();
        for(int num:nums){
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        PriorityQueue<Integer> minHeap = new PriorityQueue<>(
            (n1, n2) -> count.get(n1) - count.get(n2)
        );
        
        // keep top K elements in the heap
        for(int n : count.keySet()) {
            minHeap.add(n);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        
        // build output
        int[] topK  = new int[k];
        for(int i = k - 1; i>=0; i--) {
            topK[i] = minHeap.poll();
        }
        
        return topK;
    }

    // O(N) using Bucket Sort
    public int[] topKFrequent_BucketSort(int[] nums, int k) {
        //1. Init Frequencies
        Map<Integer, Integer> count = new HashMap<>();
        for(int num: nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);
        }
        
        //2. Init Buckets
       List<Integer>[] buckets = new List[nums.length + 1];
        for(int i = 0; i < buckets.length; i++) {
            buckets[i] = new ArrayList<>();
        }
        for(int key : count.keySet()) {
            buckets[count.get(key)].add(key);
        }
        
        //Flatten buckets
        List<Integer> flattened = new ArrayList<>();
        for(int i = buckets.length - 1; i>=0; i--) {
            for(int num : buckets[i]) {
                flattened.add(num);
            }
        }
        
        int[] top = new int[k];
        for(int i = 0;i< k; i++){
            top[i] = flattened.get(i);
        }
        
        return top;
    }
}
