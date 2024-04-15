package com.personal.leetcode.graphs;

public class MaxAreaOfIsland_695 {
    //Time : O(r*c), Space = O(1)
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int result = 0;
        for(int r = 0; r < nr; r++){
            for(int c = 0; c < nc; c++) {
                if(grid[r][c] == 1){
                    int counter = 0;
                    int curr_island_count = dfs(grid,r,c,counter);
                    result = Math.max(result, curr_island_count);
                }
                
            }
        }
        return result;
        
    }

    int dfs(int[][] grid,int r, int c, int counter) {
        int nr = grid.length;
        int nc = grid[0].length;

        if(r<0 || c<0 || r>=nr || c >=nc || grid[r][c] == 0){
            return 0;
        }
        grid[r][c] = 0;

        counter = 1+ dfs(grid, r-1, c, counter)+ dfs(grid, r+1, c, counter)+ dfs(grid, r, c+1, counter)+ dfs(grid, r, c-1, counter);

        return counter;
    }
}
