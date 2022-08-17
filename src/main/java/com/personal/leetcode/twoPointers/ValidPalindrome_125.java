package com.personal.leetcode.twoPointers;

public class ValidPalindrome_125 {
    public boolean isPalindrome(String s) {
        
        //remove non-alphanumeric
        String strCleaned = s.replaceAll("[^A-Za-z0-9]", "");
        String lower = strCleaned.toLowerCase();
        
        int left = 0 , right = lower.length() - 1;
        while(left <= right) {
            if(lower.charAt(left) != lower.charAt(right)) return false;
            left++;
            right--;
        }
        
        return true;
    }
}
