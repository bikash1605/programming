package com.personal.leetcode.intervals;

import java.util.Arrays;

public class MeetingRooms_252 {
    public boolean canAttendMeetings(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0],b[0])); // O(NlogN)
        
        for(int i = 0; i < intervals.length - 1 ; i++) {
            if(intervals[i][1] > intervals[i+1][0]) {
                return false;
            }
        }
        return true;
    }
}
