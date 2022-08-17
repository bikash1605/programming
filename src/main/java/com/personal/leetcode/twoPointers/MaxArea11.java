package com.personal.leetcode.twoPointers;

public class MaxArea11 {
    public int maxArea(int[] height) {
        
        int left = 0, right = height.length - 1;
        int maxArea = -1;
        
        while(left <= right) {
            int area = Math.min(height[left], height[right]) * (right - left) ; 
            if (area > maxArea) {
                maxArea = area;
            }
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
        
    }
}
