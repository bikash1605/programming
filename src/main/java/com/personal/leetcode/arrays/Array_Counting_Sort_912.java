package com.personal.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;


//Time : O(n+k) where  minValue <= k <= maxValue
//Space : O(n)
public class Array_Counting_Sort_912 {
    public int[] sortArray(int[] nums) {
        
        Map<Integer,Integer> frequency = new HashMap<>();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0 ; i < nums.length ; i++) {
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            frequency.put(nums[i], frequency.getOrDefault(nums[i], 0) + 1);
        }

        int index = 0;
        for(int val = min; val <= max; val++) {
            
            while(frequency.getOrDefault(val, 0) > 0) {
                nums[index] = val;
                index += 1;
                frequency.put(val, frequency.get(val) - 1);
            }
        }

        return nums;
    }
}
