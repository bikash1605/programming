package com.personal.leetcode.dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BestTeamWithNoConflicts_1626 {

    // Time : O(N*N)
    //Space = O(N)
    public int bestTeamScore(int[] scores, int[] ages) {
        
        int[][] pairs = new int[ages.length][2];
        for(int i = 0; i < ages.length ; i++) {
            pairs[i][0] = ages[i];
            pairs[i][1] = scores[i];
        }

        Arrays.sort(pairs, (a,b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        List<Integer> nums = new ArrayList<>();
        for(int i = 0 ;i < pairs.length ; i++) {
            nums.add(pairs[i][1]);
        }

        Integer[] scoresList = new Integer[ages.length];
        int result = LIS(nums.toArray(scoresList));

        return result;

    }

    public int LIS(Integer[] nums) {

        int[] dp = new int[nums.length];

        int result = 0;
        for(int i=0 ; i< nums.length; i++) {
            dp[i] = nums[i];
            result = Math.max(result, dp[i]);
        }
        for(int i = 0 ;i < nums.length ; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[j] <= nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + nums[i]);
                    result = Math.max(result, dp[i]);
                }
            }
        }

        return result;
        
    }
}
