package com.personal.leetcode.binarySearch;

import java.util.Arrays;

public class SpellsAndPotions_2300 {

    // Time : O(mlogm) + O(nlogm), m = len(potions)
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        
        Arrays.sort(potions);
        int[] res = new int[spells.length];

        for(int i = 0; i < spells.length; i++) {
            int left = 0, right = potions.length - 1;
            // int minPos = potions.length;

            while(left <= right) {
                int mid = left + (right - left) / 2;
                if((long)spells[i] * potions[mid] >= success) {
                    right = mid - 1;
                    // minPos = mid;
                }else {
                    left = mid + 1;
                }
            }
            res[i] = potions.length - left;

        }

        return res;
    }
}
