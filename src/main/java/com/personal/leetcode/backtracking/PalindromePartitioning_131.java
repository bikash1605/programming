package com.personal.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning_131 {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        List<String> partition = new ArrayList<>();
        backtrack(s, 0, partition, result);
        return result;
    }

    public boolean isPalindrome(String s, int start, int end) {
        while(start < end) {
            if(s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start += 1;
            end -= 1;
        }
        return true;
    }

    public void backtrack(String s, int index, List<String> partition, List<List<String>> result) {

        if(index >= s.length()) {
            result.add(new ArrayList<>(partition));
            return;
        }

        for(int i = index ; i < s.length() ; i++) {
            if(isPalindrome(s, index, i)) {
                partition.add(s.substring(index, i+1));
                backtrack(s, i+1 , partition, result);
                partition.remove(partition.size() - 1);
            }
        }
    }
}
