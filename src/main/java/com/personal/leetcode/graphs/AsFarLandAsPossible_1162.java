package com.personal.leetcode.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class AsFarLandAsPossible_1162 {

    // Time : O(N*N)
    //Space : O(N*N)
    public int maxDistance(int[][] grid) {
        
        int[][] visited = new int[grid.length][grid[0].length];

        Queue<int[]> bfsQ = new LinkedList<>();

        for(int i = 0 ; i < grid.length ; i++) {
            for(int j = 0; j< grid[0].length ; j++) {
                if(grid[i][j] == 1) {
                    bfsQ.offer(new int[] {i,j});
                }
                visited[i][j] = grid[i][j];
            }
        }


        int[][] dirs = new int[][] {{0,1}, {0, -1}, {1,0}, {-1, 0}};
        int distance = -1;
        while(!bfsQ.isEmpty()) {
            int qsize = bfsQ.size();

            while(qsize > 0) {
                int[] curr = bfsQ.poll();
                qsize--;

                for(int[] dir : dirs) {
                    int x = curr[0] + dir[0]; int y = curr[1] + dir[1];
                    if(x>=0 && y >=0 && x < grid[0].length && y < grid[0].length && visited[x][y] == 0) {
                        visited[x][y] = 1;
                        bfsQ.offer(new int[] {x, y});
                    }
                }
            }
            distance++;

        }

        return (distance == 0) ? -1 : distance; 
    }
}
