package com.personal.leetcode.stacks;

import java.util.Stack;

public class RemovingStarsFromString_2390 {
    public String removeStars(String s) {

        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i < s.length() ; i++) {
            if(s.charAt(i) != '*') {
                st.add(s.charAt(i));
            }else {
                st.pop();
            }
        }

        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()) {
            sb.append(st.pop());
        }

        return sb.reverse().toString();
        
    }
}
