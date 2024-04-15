package com.personal.leetcode.intervals;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin_973 {

    //Time : NlogK
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        List<int[]> result = new ArrayList<>();


        for(int i = 0 ; i < points.length ; i++) {
            int dist = points[i][0]*points[i][0] + points[i][1] * points[i][1];

            pq.add(new int[]{dist, i});
            if(pq.size() > k) {
                pq.poll();
            }

        }

        for(int i = 0 ; i < k ; i++) {
            int[] pair = pq.poll();
            int index = pair[1];
            result.add(points[index]);
        }

        return result.toArray(new int[result.size()][]);
    }
}
