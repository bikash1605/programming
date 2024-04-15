package com.personal.leetcode.graphAdvanced;

import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class MST_MinCostConnection_1584 {
    public int minCostConnectPoints(int[][] points) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        //Add first element to pq
        pq.add(new int[]{0,0});
        int len = points.length;
        int cost = 0;
        Set<Integer> visited = new HashSet<>();
        
        while(visited.size() < len) {
            int[] pair = pq.poll();
            int wt = pair[0];
            int v = pair[1];
            
            if(visited.contains(v)) continue;
            
            visited.add(v);
            cost+=wt;
            
            for(int nexvalue = 0; nexvalue < len; nexvalue++) {
                if(!visited.contains(nexvalue)) {
                    int md = Math.abs(points[nexvalue][0] - points[v][0]) + Math.abs(points[nexvalue][1] - points[v][1]);
                    pq.add(new int[]{md,nexvalue});    
                }
            }
            
        }
        
        return cost;
    }
}
