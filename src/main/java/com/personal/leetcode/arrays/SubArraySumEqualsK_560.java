package com.personal.leetcode.arrays;

import java.util.HashMap;
import java.util.Map;

public class SubArraySumEqualsK_560 {
    public int subarraySum(int[] nums, int k) {

        Map<Integer, Integer> prefixMap = new HashMap<>();
        int prefixSum = 0; int result = 0;

        //init
        prefixMap.put(0,1);
        for(int i = 0 ; i < nums.length ; i++) {
            prefixSum += nums[i];
            if(prefixMap.containsKey(prefixSum - k)){
                result += prefixMap.get(prefixSum - k);
            }
            prefixMap.put(prefixSum , prefixMap.getOrDefault(prefixSum, 0) + 1);
        }

        return result;
        
    }
}
