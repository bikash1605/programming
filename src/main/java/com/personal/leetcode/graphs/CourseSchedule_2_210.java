package com.personal.leetcode.graphs;

import java.util.*;


class CourseSchedule_2_210 {
    
    static int WHITE = 0;
    static int GREY = 1;
    static int BLACK = 2;
    
    boolean isPossible;
    Map<Integer, Integer> color;
    Map<Integer, List<Integer>> adjList;
    List<Integer> topologicalOrder;
    
    public void init(int numCourses){
        this.isPossible = true;
        this.color = new HashMap<Integer, Integer>();
        this.adjList = new HashMap<Integer, List<Integer>>();
        this.topologicalOrder = new ArrayList<Integer>();
        
        //mark all vertices as WHITE
        for (int i = 0; i< numCourses; i++){
            this.color.put(i, WHITE);
        }
    }
    
    public void dfs(int node) {
        
        //Cycle detected. Terminate
        if(!this.isPossible) {
            return;
        }
        
        //start recursion
        this.color.put(node, GREY);
        
        //traverse on adjacency list nodes
        for(Integer neighbour : this.adjList.getOrDefault(node, new ArrayList<Integer>())) {
            if(this.color.get(neighbour) == WHITE) {
                this.dfs(neighbour);
            } else if (this.color.get(neighbour) == GREY) { //cycle detected
                this.isPossible = false;
            }
        }
        
        // Recusrsion ends. Push it to stack
        this.color.put(node, BLACK);
        this.topologicalOrder.add(node);
        
    }
    
    // Time Complexity : O(V+E)
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        this.init(numCourses);
        
        //Build adjacency list
        for(int[] tuple: prerequisites){
            int src = tuple[1];
            int dest = tuple[0];
            List<Integer> lst = adjList.getOrDefault(src, new ArrayList<Integer>());
            lst.add(dest);
            adjList.put(src, lst);
            
        }
        
        //perform dfs
        for(int i=0;i< numCourses; i++){
            if(this.color.get(i) == WHITE){
                this.dfs(i);
            }
        }
        
        int[] order;
        if(this.isPossible) {
            order = new int[numCourses];
            for(int i=0;i<numCourses;i++) {
                order[i] = this.topologicalOrder.get(numCourses -i -1);
            }
        } else {
            order = new int[0];
        }
        
        return order;
    }
}
