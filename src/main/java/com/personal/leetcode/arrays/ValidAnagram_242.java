package com.personal.leetcode.arrays;

class ValidAnagram_242 {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        
        int[] counter = new int[26];
        for(int i = 0 ;i < s.length() ;i++) {
            counter[s.charAt(i) - 'a']++;
            counter[t.charAt(i) - 'a']--;
        }
        
        for(int i : counter){
            if(i != 0) {
                return false;
            }
        }
        
        return true;
    }
}