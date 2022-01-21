package com.personal.leetcode.binarySearch;

import java.util.Arrays;

/**
There is an integer array nums sorted in ascending order (with distinct values).
Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length)
such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). 
For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
Given the array nums after the possible rotation and an integer target, 
return the index of target if it is in nums, or -1 if it is not in nums.
 */
public class SearchRotatedArray {
    private static int search(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
          
        while (start <= end) {
          int mid = start + (end - start) / 2;
            
          if (nums[mid] == target) return mid;
          else if (nums[mid] >= nums[start]) { // left side is sorted
            if (target >= nums[start] && target < nums[mid]) end = mid - 1; // if target found in left side 
            else start = mid + 1; //otherwise search in the right side
          }
          else { //right side is sorted
            if (target <= nums[end] && target > nums[mid]) start = mid + 1;
            else end = mid - 1;
          }
        }
        return -1;
      }

    public static void main(String[] args) {
        //List<Integer> inputArray = Arrays.asList(4,34,56,-1,78,65,77,89,0);
        //Collections.sort(inputArray);
        int num[] = new int[] {4,34,56,-1,78,65,77,89,0};
        Arrays.sort(num);
        System.out.println(search(num, 65));
    }
}
