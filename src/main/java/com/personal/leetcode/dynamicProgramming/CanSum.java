package com.personal.leetcode.dynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class CanSum {

    public static boolean canSumMemo(int target, int[] nums){
        // boolean[] memo = new boolean[1000];
        Map<Integer, Boolean> memo = new HashMap<>();
        return canSum(target, nums, memo);
    }

    //Time Non Memoized : (n^m) where m=target, n = length of array
    // Memoized : O(m*n)
    public static boolean canSum(int target, int[] nums, Map<Integer, Boolean> memo) {

        if(memo.containsKey(target)) return memo.get(target);
        if(target == 0) return true;
        if(target < 0) return false;


        for(int num : nums){
            int remainderSum = target - num;
            if(canSum(remainderSum, nums, memo) == true){
                memo.put(target, true);
                return true;
            }
        }
        memo.put(target, false);
        return false;

    }

    public static void main(String args[]){
        System.out.println(canSumMemo(7, new int[] {2,3,4,7})); //true
        System.out.println(canSumMemo(7, new int[] {2,3})); // true
        System.out.println(canSumMemo(7, new int[] {2,4})); //false
        System.out.println(canSumMemo(8, new int[] {2,3,5})); //true
        System.out.println(canSumMemo(300, new int[] {7, 14})); // false

    }
    
}
