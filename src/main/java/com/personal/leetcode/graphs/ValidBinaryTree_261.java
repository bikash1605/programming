package com.personal.leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class ValidBinaryTree_261 {
    private Map<Integer, List<Integer>> adjList = new HashMap<>();
    boolean isCyclic = false;
    
    public boolean validTree(int n, int[][] edges) {
            
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
        int[] parent = new int[n];
        for(int i = 0 ;i<n ; i++) {
            parent[i] = -2;
        }
        
        int count = 0;
        parent[0] = -1;
        for(int i=0 ;i < n ; i++) {
            if(!visited[i]) {
                dfs(i, visited, adjList, parent);
                count++;
            }
        }
        
        return (count == 1 && isCyclic == false) ? true:false;
        
    }
    
    public void dfs(int start, boolean[] visited, Map<Integer, List<Integer>> adjList, int[] parent) {
        visited[start] = true;
        for(int neighbour : adjList.getOrDefault(start, new ArrayList<Integer>())) {
            if(!visited[neighbour]){
                parent[neighbour] = start;
                dfs(neighbour, visited, adjList, parent);       
            }else if(parent[start] == neighbour){
                continue;
            }else {
                isCyclic =  true;
            }
        }
    }
}