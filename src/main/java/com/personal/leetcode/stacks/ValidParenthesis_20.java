package com.personal.leetcode.stacks;

import java.util.Stack;

public class ValidParenthesis_20 {
    public boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i = 0 ; i< s.length() ; i++) {
            char ch = s.charAt(i);
            if((st.isEmpty()) && (ch == ')' || ch == '}' || ch == ']')) return false;
            else {
                if(!st.isEmpty()) {
                    if(st.peek() == '(' && ch == ')') st.pop();
                    else if(st.peek() == '{' && ch == '}') st.pop();
                    else if(st.peek() == '[' && ch == ']') st.pop();
                    else st.push(ch);
                }else {
                    st.push(ch);
                }
            }
        }
        
        return st.isEmpty();
    }
}
