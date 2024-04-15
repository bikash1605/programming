package com.personal.leetcode.priorityQ;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class KClosestPointsToOrigin_973 {

    //Time : ONlogN + OKlogK 
    public int[][] kClosest(int[][] points, int k) {
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        List<int[]> result = new ArrayList<>();

        for(int i = 0 ;i < points.length ; i++) { //ONlogN
            int dist = points[i][0]*points[i][0] + points[i][1]*points[i][1];
            pq.add(new int[] {dist, i});
        }

        for(int i = 0 ; i<k ; i++) { //OklogK
            int[] item = pq.poll();
            result.add(points[item[1]]);
        }

        return result.toArray(new int[k][]);
    }
}
