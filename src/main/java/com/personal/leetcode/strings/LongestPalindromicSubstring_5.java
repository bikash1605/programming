package com.personal.leetcode.strings;

public class LongestPalindromicSubstring_5 {
    public String longestPalindrome(String s) {
        int s_len = s.length();
        String sb = null; int max_len = 0;
        for(int i = 0; i< s_len; i++) {
            int left = i, right = i;

            // odd length string
            while(left >=0 && right < s_len && s.charAt(left) == s.charAt(right)) {
                String str_temp = s.subSequence(left, right+1).toString();
                if(str_temp.length() > max_len) {
                    sb = str_temp;
                    max_len = str_temp.length();
                }
                left -= 1;
                right += 1;
            }

            left = i; right = i + 1;
            //even length string
            while(left >=0 && right < s_len && s.charAt(left) == s.charAt(right)) {
                String str_temp = s.subSequence(left, right+1).toString();
                if(str_temp.length() > max_len) {
                    sb = str_temp;
                    max_len = str_temp.length();
                }
                left -= 1;
                right += 1;
            }
        }
        return sb;

    }
    
}
