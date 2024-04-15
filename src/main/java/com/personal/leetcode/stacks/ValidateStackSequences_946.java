package com.personal.leetcode.stacks;

import java.util.Stack;

public class ValidateStackSequences_946 {

    //Time : O(N)
    // Space : O(N)
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> st = new Stack<>();

        int j = 0;
        for(int p : pushed) {
            st.push(p);

            while(!st.isEmpty() && j < popped.length && st.peek() == popped[j]) {
                st.pop();
                j++;
            }
        }

        return j == popped.length;
    }
}
