package com.personal.leetcode.strings;

public class PalindromicSubstings_647 {

    private boolean isPalindrome(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) 
                return false;

            ++start;
            --end;
        }

        return true;
    }
    // Brute Force O(N^3)
    public int countSubstrings1(String s) {
        int ans = 0;

        for (int start = 0; start < s.length(); ++start)
            for (int end = start; end < s.length(); ++end) 
                ans += isPalindrome(s, start, end) ? 1 : 0;

        return ans;
    }

    //Using DP O(N^2)
    public int countSubstrings2(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int ans = 0;
        
        for(int g = 0; g< n;g++) {
            for(int i=0, j = g; j < n ; i++,j++) {
                if(g == 0){
                    dp[i][j] = true ;
                } else if (g == 1) {
                    dp[i][j] = (s.charAt(i) == s.charAt(j));
                }else{        
                    dp[i][j] = (s.charAt(i) == s.charAt(j) && dp[i+1][j-1] == true);
                }
                ans += (dp[i][j]) ? 1 : 0;
            }
        }
        return ans;
    }
    
    //  Expand Around Possible Centers - O(N^2)
    /*
     * Algorithm

        We choose all possible centers for potential palindromes:
            Every single character in the string is a center for possible odd-length palindromes
            Every pair of consecutive characters in the string is a center for possible even-length palindromes.
        
            For every center, we can expand around it as long as we get palindromes (i.e. the first and last characters should match).  
     * 
     */
    public int countSubstrings3(String s) {
        int s_len = s.length();
        int ans = 0;
        for(int i = 0; i < s_len; i++) {
            // for odd length substrings
            int l = i, r = i;
            while(l>=0 && r < s_len && s.charAt(l) == s.charAt(r)){
                ans += 1;
                l -= 1;
                r += 1;
            }
            
            // for even length substrings
            l = i;
            r = i+1;
            while(l>=0 && r < s_len && s.charAt(l) == s.charAt(r)){
                ans += 1;
                l -= 1;
                r += 1;
            }
        }
        
        return ans;
    }
}
