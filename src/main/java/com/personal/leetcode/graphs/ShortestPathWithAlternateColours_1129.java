package com.personal.leetcode.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class ShortestPathWithAlternateColours_1129 {

    //Time complexity: O(n+e)
    //Space complexity : O(n+e)

    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        
        //create adj matrix
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        for(int[] red : redEdges) {
            List<int[]> val = adjList.getOrDefault(red[0], new ArrayList<int[]>());
            val.add(new int[] {red[1], 0});
            adjList.put(red[0], val);
        }
        for(int[] blue : blueEdges) {
            List<int[]> val = adjList.getOrDefault(blue[0], new ArrayList<int[]>());
            val.add(new int[] {blue[1], 1});
            adjList.put(blue[0], val);
        }

        Queue<int[]> bfsQ = new LinkedList<>();
        bfsQ.offer(new int[] {0,0, -1});
        boolean[][] visited = new boolean[n][2];
        visited[0][1] = visited[0][0] = true;

        int[] result = new int[n];
        Arrays.fill(result, -1);
        result[0] = 0;

        while(!bfsQ.isEmpty()) {
            int[] elem = bfsQ.poll();
            int node = elem[0], steps = elem[1], prevColour = elem[2];



            for(int[] neighbours : adjList.getOrDefault(node, new ArrayList<int[]>())) {
                int neighbour = neighbours[0];
                int colour = neighbours[1];
                if(!visited[neighbour][colour] && colour != prevColour) {
                    if(result[neighbour] == -1) {
                        result[neighbour] =  steps + 1;
                    }
                    visited[neighbour][colour] = true;
                    bfsQ.offer(new int[] {neighbour, steps + 1, colour});
                }

            }
        }
        return result;

    }
}
