package com.personal.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Subsets_78 {
    public List<List<Integer>> subsets(int[] nums) {
        
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> sequence = new ArrayList<>();
        backtrack(nums, 0 , sequence, result);
        return new ArrayList<>(result);
    }

    public void backtrack(int[] nums, int index, List<Integer> sequence, Set<List<Integer>> result) {

        if(index >= nums.length) {
            result.add(new ArrayList<>(sequence));
            return;
        }

        sequence.add(nums[index]);
        backtrack(nums, index + 1, sequence, result);
        sequence.remove(sequence.size() - 1);
        backtrack(nums, index + 1, sequence, result);
    }
}
