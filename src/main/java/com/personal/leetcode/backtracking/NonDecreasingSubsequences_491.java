package com.personal.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class NonDecreasingSubsequences_491 {
    //Time : O(2^n  * n)
    //Space complexity: O(2^n * n).
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        List<Integer> sequence = new ArrayList<>();
        backtrack(nums, 0, sequence, result);
        return new ArrayList(result);
    }

    public void backtrack(int[] nums, int index, List<Integer> sequence, Set<List<Integer>> result) {

        // Base case
        if(index == nums.length) {
            if(sequence.size() >=2) {
                result.add(new ArrayList<>(sequence));
            }
            return;
        }

        //logic to add an element to sequence
        if(sequence.isEmpty() || sequence.get(sequence.size() - 1) <= nums[index]) {
            sequence.add(nums[index]);
            backtrack(nums, index + 1, sequence, result);

            sequence.remove(sequence.size() - 1);
        }

        backtrack(nums, index + 1, sequence, result);
    }
}
