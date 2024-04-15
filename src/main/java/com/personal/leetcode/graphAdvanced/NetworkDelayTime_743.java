package com.personal.leetcode.graphAdvanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class NetworkDelayTime_743 {
    public int networkDelayTime(int[][] times, int n, int k) {
        
        Map<Integer, List<int[]>> adjList  = new HashMap<>();
        //create adj list
        for(int[] pair : times) {
            int src = pair[0];
            int dest = pair[1];
            int wt = pair[2];
            List<int[]> lst = adjList.getOrDefault(src, new ArrayList<int[]>());
            lst.add(new int[] {dest, wt});
            adjList.put(src, lst);
        }
        
        //VisitedSet
        Set<Integer> visited = new HashSet<>();
        // init PQ with 1st element
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[0] - b[0]);
        pq.add(new int[]{0, k});
        
        int[] dist = new int[n+1];
        //dist[k] = 0;
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        // call Djikstras
        djikstra(visited, pq, dist,adjList, k);
        
        int ans = Integer.MIN_VALUE;
        for(int i = 1; i<=n;i++){
            ans = Math.max(ans, dist[i]);
        }
        
        return ans == Integer.MAX_VALUE ? -1 : ans;
        
    }
    
    public void djikstra(Set<Integer> visited, PriorityQueue<int[]> pq, int[] dist, Map<Integer, List<int[]>> adjList, int k) {
        dist[k] = 0;
        while(!pq.isEmpty()){
            //pop pq
            int[] pair = pq.poll();
            int wt = pair[0];
            int vertex = pair[1];

            if(visited.contains(vertex)) continue;

            visited.add(vertex);

            for(int[] neighbour : adjList.getOrDefault(vertex, new ArrayList<>())) {
                int neighNode = neighbour[0];
                int currWt = neighbour[1];
                if(dist[neighNode] > wt + currWt) {
                    dist[neighNode] = wt + currWt;
                    pq.add(new int[] {dist[neighNode], neighNode});
                }

            }
        }
    }
}
