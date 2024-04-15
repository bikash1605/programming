package com.personal.leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class NumberOfCC_323 {
    public int countComponents(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjList = new HashMap<>();
        for(int[] tuple : edges) {
            int src = tuple[1];
            int dest = tuple[0];
            List<Integer> lst1 = adjList.getOrDefault(src, new ArrayList<Integer>());
            lst1.add(dest);
            adjList.put(src, lst1);
            
            List<Integer> lst2 = adjList.getOrDefault(dest, new ArrayList<Integer>());
            lst2.add(src);
            adjList.put(dest, lst2);
        }
        
        boolean[] visited = new boolean[n];
        int count = 0;
        for(int i = 0 ;i < n; i++) {
            if(!visited[i]) {
                dfs(i, visited, adjList);
                count++;
            }
        }
        
        return count;
    }
    
    public void dfs(int start, boolean[] visited, Map<Integer, List<Integer>> adjList) {
        
        visited[start] = true;
        for(int neighbour : adjList.getOrDefault(start, new ArrayList<>())) {
            if(!visited[neighbour]) {
                dfs(neighbour, visited, adjList);
            }
        }
    }
}