package com.personal.leetcode.priorityQ;

import java.util.*;

// Time Complexity - O(logn) for building min and max heaps
// Time Complexity - O(1) for gettig median 
class MedianFinder {
    
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
//         if(maxHeap.isEmpty() || maxHeap.peek() >= num) {
//             maxHeap.add(num);
//         } else {
//             minHeap.add(num);
//         }
        
//         //Check for counts in both maxHeap and minHeap
//         if(maxHeap.size() > minHeap.size() + 1 ) {
//             minHeap.add(maxHeap.poll());
//         } else if(maxHeap.size() < minHeap.size()) {
//             maxHeap.add(minHeap.poll());
//         }
        
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());            
            if(minHeap.size()>maxHeap.size()){
                maxHeap.add(minHeap.poll());
            }
        
    }
    
    public double findMedian() {
        if(maxHeap.size() == minHeap.size()) {
            return 0.5* (maxHeap.peek() + minHeap.peek());
        } else {
            return maxHeap.peek();
        }
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
