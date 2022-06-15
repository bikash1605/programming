package com.personal.leetcode.binarySearch;

import java.util.Arrays;

public class FirstAndLastPosition {

    public static void main(String args[]){
        int[] nums = new int[]{5,7,7,8,8,10};
        int target = 8;
        System.out.println(Arrays.toString(searchRange(nums,target)));
    }

    public static int[] searchRange(int[] nums, int target) {
        
        int firstOccurence = findBound(nums, target, true);
        
        if(firstOccurence == -1) {
            return new int[]{-1,-1};
        }
        
        int lastOccurence = findBound(nums,target, false);
        
        return new int[]{firstOccurence, lastOccurence};
    }
    
    public static int findBound(int[] nums, int target, boolean isFirst){
        
        int N = nums.length;
        int left = 0, right = N - 1;
        
        while(left <= right) {
            
            int mid = (left+right)/2;
            
            if(nums[mid] == target) {
                
                if(isFirst){
                    if (mid == left || nums[mid-1] != target) {
                        return mid;
                    }
                    right = mid - 1;
                    
                } else {
                    if(mid == right || nums[mid+1] != target) {
                        return mid;
                    }
                    left = mid + 1;
                }
            } else if (nums[mid] > target) {
                right = mid -1;
            } else {
                left = mid + 1;
            }
        }
        
        return -1;
    }
    
}
