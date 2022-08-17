package com.personal.leetcode.stacks;

import java.util.Stack;

public class BackSpaceCompare844 {
    
    // Solution 2 : Space complexity O(M+N)
    public boolean backspaceCompare2(String S, String T) {
        return build(S).equals(build(T));
    }

    public String build(String S) {
        Stack<Character> ans = new Stack<>();
        for (char c: S.toCharArray()) {
            if (c != '#')
                ans.push(c);
            else if (!ans.empty())
                ans.pop();
        }
        return String.valueOf(ans);
    }
}
