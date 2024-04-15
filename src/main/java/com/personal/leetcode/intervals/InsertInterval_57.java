package com.personal.leetcode.intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertInterval_57 {

    //Time : O(N) , Space = O(N)
    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> res = new ArrayList<>();
        for(int[] interval : intervals) {
            if(newInterval != null && newInterval[1] < interval[0]){ //left
                res.add(newInterval);
                res.add(interval);
                newInterval = null;
            }else if(newInterval == null || newInterval[0] > interval[1]) { //right
                res.add(interval);
            }else { //overlapping
                newInterval = new int[] {Math.min(newInterval[0], interval[0]), Math.max(newInterval[1], interval[1])};
            }
        }

        if(newInterval != null) res.add(newInterval);

        return res.toArray(new int[res.size()][]);
        
    }

}
