package com.personal.leetcode.dynamicProgramming;

public class LCS_1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        
        int l1 = text1.length();
        int l2 = text2.length();
        
        int[][] dp = new int[l1+1][l2+1];

        //init first row
        for(int i = 0 ; i < l2; i++) {
            dp[0][i] = 0;
        } 

        for(int j=0; j< l1; j++){
            dp[j][0] = 0;
        }

        for(int i = 1; i<=l1; i++) {
            for(int j=1; j<=l2; j++) {
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }

        return dp[l1][l2];
    }
}
