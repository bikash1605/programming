package com.personal.leetcode.arrays;

public class MaxSubarray_53_Kadane {

    //TimeO(N) , Space = O(N)
    public int maxSubArray(int[] nums) {
        
        //Time = O(N), Space = O(N)
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int result = dp[0];
        for(int i = 1; i< nums.length; i++) {
            dp[i] = Math.max(dp[i-1]+nums[i], nums[i]);
            result = Math.max(result, dp[i]);
        }

        return result;
    }

    //Space O(N)
    public int maxSubArray_2(int[] nums){

        int curr_sum = nums[0];
        int result = nums[0];

        for(int i = 1; i< nums.length ; i++) {
            curr_sum = Math.max(curr_sum, 0) + nums[i];
            result = Math.max(result, curr_sum);
        }

        return result;
    }

}
