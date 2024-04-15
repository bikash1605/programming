package com.personal.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

class LongestConsecutiveSequence_128 {
    public int longestConsecutive(int[] nums) {
          
        Set<Integer> lookup = new HashSet<>();
        for(int num : nums) {
            lookup.add(num);
        }
        
        int longest = 0;
        for(int num : nums) {
            if(!lookup.contains(num - 1)) {
                int curr = 1;
                int start = num;
                
                while(lookup.contains(start + 1)){
                    start += 1;
                    curr += 1;
                }
                longest = Math.max(longest, curr);
            }
        }
        return longest;
    }
}