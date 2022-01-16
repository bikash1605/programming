package com.personal.algorithms;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Program to find prime numbers withing a given range
 *
 */
public class BinarySearch {
    
    public static void main( String[] args )
    {
        List<Integer> inputArray = Arrays.asList(4,34,56,-1,78,65,77,89,0);
        Collections.sort(inputArray);
        
        System.out.println(search(inputArray, 78));
    }

    private static int search(List<Integer> inputArray, int target) {
        int mid , left = 0, right = inputArray.size() -1;
        while(left <=right){
            mid = left + (right-left)/2;
            if(inputArray.get(mid) == target){
                return 1;
            }
            if(target < inputArray.get(mid)) {
                right = mid - 1;
            }else{
                left = mid + 1;
            }
        }
        return -1;
    }

}