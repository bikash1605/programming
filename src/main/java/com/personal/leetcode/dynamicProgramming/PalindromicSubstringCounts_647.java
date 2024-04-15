package com.personal.leetcode.dynamicProgramming;

public class PalindromicSubstringCounts_647 {

    //Time= O(N^2), Space = O(N^2)
    public int countSubstrings(String s) {
        int s_len = s.length();
        boolean[][] dp = new boolean[s_len][s_len];
        int ans = 0;

        //traverse around the diagonals
        for(int gap = 0; gap < s_len ; gap++) {
            for(int i = 0, j = gap; j < s_len ; i++, j++) {
                if(gap == 0) {
                    dp[i][j] = true;
                }else if(gap ==1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }else {
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1]);
                }
                ans += (dp[i][j]) ? 1 : 0;
            }
        }
        return ans;
    }

}
