package com.personal.leetcode.binarySearch;

public class CapacityToShipPackages_1011 {
    public int shipWithinDays(int[] weights, int days) {
        
        int maxWt = 0, totalWt = 0;
        for(int i = 0 ; i < weights.length ; i++) {
            totalWt += weights[i];
            maxWt = Math.max(maxWt, weights[i]);
        }

        int left = maxWt , right = totalWt;
        int result = Integer.MAX_VALUE;
        while(left <= right) {
            int mid = left + (right - left)/2;

            if(isPossible(weights, mid, days)) {
                result = Math.min(result, mid);
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }

        return result;
    }

    public boolean isPossible(int[] weights, int capacity, int days) {
        int currCapacity = 0;
        int daysNeeded = 1;
        for(int i = 0 ; i < weights.length; i++) {
            currCapacity += weights[i];
            if(currCapacity > capacity) {
                daysNeeded++;
                currCapacity = weights[i];
            }
        }

        return daysNeeded <= days ;
    }
}
