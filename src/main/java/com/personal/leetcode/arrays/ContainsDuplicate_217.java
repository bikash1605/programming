package com.personal.leetcode.arrays;

import java.util.HashSet;
import java.util.Set;

class ContainsDuplicate_217 {
    /**
     * HashSet has O(1) for insert() and search()
     * @param nums
     * @return boolean
     */
    public boolean containsDuplicate1(int[] nums) {
        Set<Integer> lookup = new HashSet<>(nums.length);
        for(int num : nums) {
            if(lookup.contains(num))
                return true;
            else {
                lookup.add(num);
            }
        } 
        return false;
    }
}