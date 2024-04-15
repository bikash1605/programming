package com.personal.leetcode.graphs;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders_909 {
    /**
     * @param board
     * @return
     * 
     * Time Complexity : O(N^2) 
     * There are n^2 vertices and no more than 6n^2 edges
     * BFS = O(V+E) = O(N^2 + 6*N^2)
     * 
     * Space = O(N^2) for cells and O(N) for dist
     */
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        Pair<Integer, Integer>[] cells = new Pair[n*n +1];

        Integer[] columns = new Integer[n];
        for(int i = 0 ; i < n ; i++) {
            columns[i] = i;
        }
        int label = 1;
        for(int row = n-1; row >=0 ; row--) {
            for(int col : columns) {
                cells[label++] = new Pair<>(row, col);
            }
            Collections.reverse(Arrays.asList(columns));
        }

        int[] dist = new int[n*n+1];
        Arrays.fill(dist , -1);
        dist[1] = 0;

        Queue<Integer> q = new LinkedList<>();
        q.add(1);

        while(!q.isEmpty()) {
            int curr  = q.poll();
            for(int next = curr + 1; next <=Math.min(curr+6, n*n); next++) {
                int row = cells[next].getKey(), col = cells[next].getValue();
                int destination = board[row][col] != -1 ? board[row][col] : next;
                if(dist[destination] == -1) {
                    dist[destination] = dist[curr] + 1;
                    q.add(destination);
                }
            }
        }
        
        return dist[n*n];


    }
}
