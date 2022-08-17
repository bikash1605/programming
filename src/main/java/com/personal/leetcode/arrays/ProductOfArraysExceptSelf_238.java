package com.personal.leetcode.arrays;

public class ProductOfArraysExceptSelf_238 {
    
    //Time Complexity = O(n)
    //Space Complexity = O(n)
    public int[] productExceptSelf1(int[] nums) {
        
        int[] ans = new int[nums.length];
        
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        
        left[0] = 1;
        for(int i=1;i< nums.length ;i++){
            left[i] = left[i-1] * nums[i-1];
        }
        
        right[nums.length - 1] = 1;
        for(int i = nums.length - 2 ;i>=0 ;i--){
            right[i] = right[i+1] * nums[i+1];
        }
        
        for(int i=0;i< nums.length; i++) {
            ans[i] = left[i] * right[i];
        }
        
        return ans;
    }


    //Time Complexity = O(n)
    //Space Complexity = O(1)
    public int[] productExceptSelf2(int[] nums) {
        
        int[] ans = new int[nums.length];
        
        ans[0] = 1;
        for(int i=1;i< nums.length ;i++){
            ans[i] = ans[i-1] * nums[i-1];
        }
        
        int right = 1;
        
        for(int i = nums.length - 1 ;i>=0 ;i--){
            ans[i] = ans[i] * right;
            right = right * nums[i];
        }
        
        return ans;
    }
}
