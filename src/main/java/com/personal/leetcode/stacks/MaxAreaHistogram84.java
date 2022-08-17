package com.personal.leetcode.stacks;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaxAreaHistogram84 {
    public int largestRectangleArea(int[] heights) {
        
        //Initialize Stack
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        int maxArea = 0;
        for (int i = 0; i< heights.length; i++) {
            while(stack.peek() != -1 && heights[stack.peek()] >= heights[i]) { // Pop stack, histogram length is decreasing
                int currHeight = heights[stack.pop()];
                int currWidth = i - stack.peek() - 1;
                maxArea = Math.max(maxArea, currHeight * currWidth);
            }
            
            stack.push(i);
        }
        
        while(stack.peek() != -1) {
            int currHeight = heights[stack.pop()];
            int currWidth = heights.length - stack.peek() - 1;
            maxArea = Math.max(maxArea, currHeight * currWidth);
        }
        
        return maxArea;
    }
}
