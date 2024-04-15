package com.personal.leetcode.graphs;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ClosestNode_To_GivenTwoNodes_2359 {

    // Time : O(N)
    // Space : O(N)
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        Map<Integer, Integer> adjList = new HashMap<>();
        for(int i = 0 ; i < n ; i++) {
            adjList.put(i,edges[i]);
        }

        int[] node1Map = new int[n]; Arrays.fill(node1Map, Integer.MAX_VALUE);
        node1Map[node1] = 0;
        int[] node2Map = new int[n];Arrays.fill(node2Map, Integer.MAX_VALUE);
        node2Map[node2] = 0;
        int[] visited = new int[n];

        //call dfs on node1
        Arrays.fill(visited, 0);
        dfs(adjList, node1, node1Map, visited);

        //call dfs on node2
        Arrays.fill(visited, 0);
        dfs(adjList, node2, node2Map, visited);

        int minDist = Integer.MAX_VALUE;
        int result = -1;
        for(int i = 0 ; i < n ; i ++) {
            if(Math.max(node1Map[i] , node2Map[i]) < minDist) {
                result = i;
                minDist = Math.max(node1Map[i] , node2Map[i]);
            }
            
        }

        return result;
    }

    public void dfs(Map<Integer, Integer> adjList, int node, int[] nodeMap, int[] visited) {
        int next = adjList.get(node);
        visited[node] = 1;
        if(next != -1 && visited[next] == 0) {
            nodeMap[next] = nodeMap[node] + 1;
            dfs(adjList, next, nodeMap, visited);
        }
        return;

    }
}
