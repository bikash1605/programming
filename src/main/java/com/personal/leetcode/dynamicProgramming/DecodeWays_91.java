package com.personal.leetcode.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

// Iterative
public class DecodeWays_91 {
    public int numDecodings(String s) {
        
        int[] dp = new int[s.length()];
        //Check for 1st character
        dp[0] = (s.charAt(0) == '0') ? 0 : 1;

        for(int i = 1; i < s.length() ; i++) {
            // Check if successful single digit decode is possible.
            if(s.charAt(i) != '0') {
                dp[i] = dp[i-1];
            }

            // Check if successful two digit decode is possible.
            int twoDigit = Integer.valueOf(s.substring(i-1, i+1));
            if(twoDigit >=10 && twoDigit <=26) {
                if(i > 1) {
                    dp[i] = dp[i] + dp[i-2];
                }else {
                    dp[i] += dp[i-1];
                }
                
            }
        }

        return dp[s.length() -1];
    }
}

// Memoization Technique
class Solution {

    Map<Integer, Integer> memo = new HashMap<>();

    public int numDecodings(String s) {
        return recursiveWithMemo(0, s);
    }
    
    private int recursiveWithMemo(int index, String str) {
        // Have we already seen this substring?
        if (memo.containsKey(index)) {
            return memo.get(index);
        }
        
        // If you reach the end of the string
        // Return 1 for success.
        if (index == str.length()) {
            return 1;
        }

        // If the string starts with a zero, it can't be decoded
        if (str.charAt(index) == '0') {
            return 0;
        }

        if (index == str.length() - 1) {
            return 1;
        }


        int ans = recursiveWithMemo(index + 1, str);
        if (Integer.parseInt(str.substring(index, index + 2)) <= 26) {
             ans += recursiveWithMemo(index + 2, str);
         }

        // Save for memoization
        memo.put(index, ans);

        return ans;
    }
}
