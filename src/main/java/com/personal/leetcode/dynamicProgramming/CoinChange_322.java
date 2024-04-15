package com.personal.leetcode.dynamicProgramming;

public class CoinChange_322 {
    public int coinChange(int[] coins, int amount) {
        
        int[][] dp = new int[coins.length][amount + 1];
        for(int i = 0; i <= amount ; i++) {
            // dp[i][0] = 0;
            if(i % coins[0] == 0) {
                dp[0][i] = i / coins[0];
            }else {
                dp[0][i] = Integer.MAX_VALUE;
            }
        }

        for(int i = 1; i< coins.length ; i++) {
            for(int j = 1; j <= amount; j++) {
                // System.out.print(dp[i][j] + " ");
                if(coins[i] <= j && dp[i][(j-coins[i])] != Integer.MAX_VALUE) {
                    dp[i][j] = Math.min(dp[i-1][j], 1 + dp[i][(j-coins[i])]);

                }else {
                    dp[i][j] = dp[i-1][j];     
                }
            }
            // System.out.print("\n");
        }

        return (dp[coins.length - 1][amount] == Integer.MAX_VALUE) ? -1 : dp[coins.length - 1][amount];
    }
}
