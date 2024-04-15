package com.personal.leetcode.arrays;

public class MaxSubarray_circular_918 {

    //Time : O(N) , Space = O(1)
    public int maxSubarraySumCircular(int[] nums) {
        int currMax = 0, currMin = 0;
        int globalMax = nums[0], globalMin = nums[0];
        int total = 0;

        for(int i = 0 ; i<nums.length ; i++) {
            currMax = Math.max(currMax + nums[i] , nums[i]);
            globalMax = Math.max(globalMax, currMax);
            total += nums[i];

            currMin = Math.min(currMin + nums[i], nums[i]);
            globalMin = Math.min(globalMin, currMin);
        }

        return (globalMax > 0)? Math.max(globalMax, total - globalMin) : globalMax;
    }
}
