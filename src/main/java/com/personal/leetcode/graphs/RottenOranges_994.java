package com.personal.leetcode.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges_994 {

    //Time : O(N*M), Space = O(N*M)
    public int orangesRotting(int[][] grid) {
        
        Queue<int[]> rottenOranges = new LinkedList<>();
        int freshOranges = 0;

        int rows = grid.length;
        int cols = grid[0].length;
        for(int i = 0 ; i< rows; i++) {
            for(int j = 0 ; j< cols; j++) {
                if(grid[i][j] == 2) {
                    rottenOranges.offer(new int[]{i,j});
                }else if(grid[i][j] == 1) {
                    freshOranges++;
                }
            }
        }

        int minutes = 0;
        int[][] dirs = new int[][] {{-1,0}, {0,-1}, {1, 0}, {0,1}};
        while(!rottenOranges.isEmpty() && freshOranges != 0) {
            minutes += 1;
            int sz = rottenOranges.size();
            for(int i = 0; i < sz; i++) {
                int[] curr = rottenOranges.poll();
                int r = curr[0]; int c = curr[1];
                for(int[] dir : dirs) {
                    int x = r + dir[0]; int y = c + dir[1];
                    if(x >=0 && y >=0 && x < rows && y < cols && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        rottenOranges.offer(new int[] {x,y});
                        freshOranges--;
                    }
                }
            }
            
        }

        return (freshOranges == 0) ? minutes : -1;

    }

    
}
