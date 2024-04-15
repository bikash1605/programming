package com.personal.leetcode.dynamicProgramming;

public class MinCostClimibingStairs_746 {

    // Time : O(N), Space : O(N)
    public int minCostClimbingStairs(int[] cost) {
        
        int[] min_cost = new int[cost.length + 1];
        min_cost[0] = 0;
        min_cost[1] = 0;

        for(int i = 2; i< min_cost.length ; i++) {
            min_cost[i] = Math.min(min_cost[i-1]+cost[i-1], min_cost[i-2]+cost[i-2]);
        }

        return min_cost[cost.length];
    }

    // Constant Space : O(1), Time : O(N)
    public int minCostClimbingStairs_2(int[] cost) {
        
    }
}
