package com.personal.leetcode.binarySearch;

public class Single_Element_in_a_Sorted_Array_540 {
    
    public int singleNonDuplicate(int[] nums) {
        int low = 0, high = nums.length - 1;

        while(low<high) {
            int mid = low + (high - low)/2;
            boolean halves = (high - mid) % 2 == 0;
            if(nums[mid] == nums[mid + 1]){
                if(halves) {
                    low = mid + 2;
                }else {
                    high = mid - 1;
                }
            }else if(nums[mid] == nums[mid - 1]) {
                if(halves) {
                    high = mid - 2;
                }else {
                    low = mid + 1;
                }
            }else {
                return nums[mid];
            }

        }
        return nums[low];
    }
}
