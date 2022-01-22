package com.personal.leetcode.binarySearch;

/**
* A peak element is an element that is strictly greater than its neighbors.
* Given an integer array nums, find a peak element, and return its index. 
* If the array contains multiple peaks, return the index to any of the peaks.
*/
public class PeakElement {
    public static void main(String[] args) {
        int[] nums = new int[] {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(nums));
    }

    private static int findPeakElement(int[] nums) {
        return search(nums, 0, nums.length -1);
    }
    
    private static int search(int[] nums, int l, int r) {
        if(l == r)
            return l;
        int mid = (l+r)/2;
        if(nums[mid] > nums[mid+1])
            return search(nums, l, mid);
        else 
            return search(nums, mid+1, r);
    }
}
