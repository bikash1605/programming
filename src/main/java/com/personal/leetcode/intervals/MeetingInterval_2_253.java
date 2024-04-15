package com.personal.leetcode.intervals;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MeetingInterval_2_253 {

    //Time : O(nlogN), Space = O(N)
    // 2 Pointer approach
    public int minMeetingRooms(int[][] intervals) {
        
        int[] start = new int[intervals.length];
        int[] end = new int[intervals.length];

        for(int i = 0 ; i<intervals.length ; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }

        Arrays.sort(start);
        Arrays.sort(end);

        int res = 0;
        int startPointer = 0, endPointer = 0;
        int rooms = 0;

        while(startPointer < intervals.length) {
          if(start[startPointer] < end[endPointer]) {
            rooms += 1;
            startPointer += 1;
          }else {
            rooms -= 1;
            endPointer +=1;
          }
          res = Math.max(res, rooms);
        }
        
        return res;

    }

    //Time : O(NlogN) , Space : O(N)
    public int minMeetingRooms2(int[][] intervals) {
        
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0])); // O(nlogN)

        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> a-b);
        // pq.add(intervals[0][1]);

        for(int[] interval : intervals) {
          if(!pq.isEmpty() && interval[0] >= pq.peek()){
            pq.poll(); // O(nlogN) in the worst case
          }

          pq.add(interval[1]);
        }

        return pq.size();

    }
}
