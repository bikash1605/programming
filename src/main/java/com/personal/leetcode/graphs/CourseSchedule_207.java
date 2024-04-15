package com.personal.leetcode.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CourseSchedule_207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        // create adjacencey list
        Map<Integer, List<Integer>> adj = new HashMap<>();
        for(int[] tuple : prerequisites) {
            if(adj.containsKey(tuple[1])) {
                adj.get(tuple[1]).add(tuple[0]);
            }else{
                List<Integer> nextCourses= new ArrayList<>();
                nextCourses.add(tuple[0]);
                adj.put(tuple[1], nextCourses);
            }
        }
        
        int[] visited = new int[numCourses];
        int[] checked = new int[numCourses];
        
        for(int i = 0 ;i < numCourses; i++) {
            if(isCyclic(i, adj, visited, checked)) {
                return false;
            }
        }
        
        return true;   
    }
    
    public boolean isCyclic(int start, Map<Integer, List<Integer>> adj, int[] visited, int[] checked) {
        
        if(checked[start] == 1) {
            return false;
        }
        
        if(visited[start] == 1) {
            return true;
        }
        
        
        if(!adj.containsKey(start)) {
            return false;
        }
        //mark node as visited
        visited[start] = 1;
        
        boolean ret = false;
        for(int course : adj.get(start)) {
            ret = this.isCyclic(course, adj, visited, checked);
            if(ret) {
                break;
            }
            
        }
        
        //mark not visited
        visited[start] = 0;
        
        checked[start] = 1;
        return ret;
    }
}
