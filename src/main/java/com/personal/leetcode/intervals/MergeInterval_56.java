package com.personal.leetcode.intervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeInterval_56 {

    //Time : O(nlogn + N)
    // Space : O(N)
    public int[][] merge(int[][] intervals) {

        List<int[]> res = new ArrayList<>();
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0])); // O(NlogN)
        int[] prev = intervals[0];

        for(int[] interval:intervals) {
            if(prev[1] < interval[0]) {
                res.add(prev);
                prev = interval;
            }else if(interval[0] > prev[1]) {
                res.add(prev);
                prev = interval;
            }else{
                prev = new int[] {Math.min(prev[0], interval[0]), Math.max(prev[1], interval[1])};
            }
        }
        res.add(prev);

        return res.toArray(new int[res.size()][]);
        
    }
}
