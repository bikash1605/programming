package com.personal.leetcode.twoPointers;

import java.util.Arrays;

public class BoatsToSavePeople_881 {

    // Time : O(nlogn)
    public int numRescueBoats(int[] people, int limit) {
        
        Arrays.sort(people); // O(nlogn)
        int left = 0, right = people.length - 1;
        int boats = 0;
        while(left <= right) {
            if(people[left] + people[right] <= limit) {
                left++;
                right--;
            }else {
                right--;
            }
            boats++;
        }

        return boats;
    }
}
