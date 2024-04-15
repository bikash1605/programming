package com.personal.leetcode.priorityQ;

import java.util.PriorityQueue;


// Time : O(nlogN) + O(Mlogk)
public class KthLargest_703 {
    
    private PriorityQueue<Integer> minHeap; 
    int size;

    public KthLargest_703(int k, int[] nums) {
        this.minHeap = new PriorityQueue<>();
        this.size = k;

        for(int i = 0; i < nums.length ; i++) {
            this.minHeap.add(nums[i]); // NlogN where N  = nums.length;
            if(this.minHeap.size() > this.size){
                this.minHeap.poll();
            }
        }
    }
    
    // M calls made , Therefore Mlogk where k is the size of heap
    public int add(int val) {
        this.minHeap.add(val);
        if(this.minHeap.size() > this.size){
            this.minHeap.poll();
        }

        return this.minHeap.peek();
        
    }
}
