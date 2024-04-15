package com.personal.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

public class RestoreIPAddresses_93 {

    // Time : O(M^N) Here M=3 and N=4 
    // At every step, we are taking 3 decisions and height of the tree can be at max = 4

    //Space = O(M*N)
    public List<String> restoreIpAddresses(String s) {
        
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    public boolean isValid(String s, int startIndex, int length) {
        return length == 1 || 
            (s.charAt(startIndex) != '0' && 
             (length < 3 || 
              s.substring(startIndex, startIndex + length).compareTo("255") <= 0));
    }

    public void backtrack(String s, int startIndex , List<Integer> dots, List<String> result) {

        //Base condition
        int remainingIntegers = 4 - dots.size();
        int remainingLength = s.length() - startIndex;
        if(remainingLength > remainingIntegers *3 || remainingLength < remainingIntegers) {
            return;
        }

        if (dots.size() == 3) {
            if (isValid(s, startIndex, remainingLength)) {
                StringBuilder sb = new StringBuilder();
                int last = 0;
                for (Integer dot : dots) {
                    sb.append(s.substring(last, last + dot));
                    last += dot;
                    sb.append('.');
                }
                sb.append(s.substring(last));
                result.add(sb.toString());
            }
            return;
        }

        for(int currPos = 1; currPos <=3 && currPos <= remainingLength; currPos++) {
            dots.add(currPos);
            if(isValid(s, startIndex, currPos)) {
                backtrack(s, startIndex + currPos, dots, result);
            }
            dots.remove(dots.size() - 1);
        }
    }
}
