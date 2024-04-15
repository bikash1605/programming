package com.personal.leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ReorderRoutes_1466 {

    //Time : O(E) where E= no of edges
    //Space : O(n)
    public int minReorder(int n, int[][] connections) {
        int positiveSign = 0;
        int negativeSign = 1;

        Map<Integer, List<int[]>> adjList = new HashMap<>();

        for(int[] connection : connections) {
            int src = connection[0], dest = connection[1];
            List<int[]> value = adjList.getOrDefault(src,new ArrayList<>());
            value.add(new int[] {dest,negativeSign});
            adjList.put(src, value);

            List<int[]> value1 = adjList.getOrDefault(dest,new ArrayList<>());
            value1.add(new int[] {src,positiveSign});   
            adjList.put(dest, value1);
            
        }

        Queue<Integer> bfsQ = new LinkedList<>();
        boolean[] visited = new boolean[n];
        bfsQ.add(0);
        visited[0] = true;

        int result = 0;
        while(!bfsQ.isEmpty()) {
            int curr = bfsQ.poll();

            for(int[] neighbourSet : adjList.getOrDefault(curr, new ArrayList<int[]>())) {
                int neighbour = neighbourSet[0];
                int sign = neighbourSet[1];
                
                if(!visited[neighbour]) {
                    result = result + sign;
                    bfsQ.add(neighbour);
                    visited[neighbour] = true;
                }
            }
        }

        return result;
        
    }
}
