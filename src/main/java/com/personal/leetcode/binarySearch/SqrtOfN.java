package com.personal.leetcode.binarySearch;

/**
 * The value aa we're supposed to compute could be defined as a^2 < x < (a + 1)^2a . 
 * It is called integer square root. From geometrical points of view, 
 * it's the side of the largest integer-side square with a surface less than x.
 *
 */
public class SqrtOfN {
    public static void main(String[] args) {
        System.out.println(mySqrt(34562));
    }

    private static int mySqrt(int x) {
        if (x < 2) return x;

        long num;
        int pivot, left = 2, right = x / 2;
        while (left <= right) {
          pivot = left + (right - left) / 2;
          num = (long)pivot * pivot;
          if (num > x) right = pivot - 1;
          else if (num < x) left = pivot + 1;
          else return pivot;
        }
    
        return right;
    }
    
}
