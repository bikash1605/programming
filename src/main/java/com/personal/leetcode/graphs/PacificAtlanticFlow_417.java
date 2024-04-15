package com.personal.leetcode.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PacificAtlanticFlow_417 {
    int[][] dirs = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };
        
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        
        List<List<Integer>> res = new ArrayList<>();
        
        int nr = heights.length;
        int nc = heights[0].length;
        
        boolean[][] pacific = new boolean[nr][nc];
        boolean[][] atlantic = new boolean[nr][nc];
        
        for(int i = 0 ;i<nc; i++) { // 1st row and last row
            dfs(0, i, pacific, heights, Integer.MIN_VALUE); // 1st row
            dfs(nr-1, i, atlantic, heights, Integer.MIN_VALUE); // last row
        }
        
        for(int i = 0 ;i<nr; i++) { // 1st row and last row
            dfs(i, 0, pacific, heights, Integer.MIN_VALUE); // 1st row
            dfs(i, nc -1, atlantic, heights, Integer.MIN_VALUE); // last row
        }
        
        for(int i = 0;i<nr;i++) {
            for(int j = 0; j< nc ; j++) {
                if(pacific[i][j] && atlantic[i][j]){
                    res.add(Arrays.asList(i,j));
                }
            }
        }
        
        return res;
    }
    
    public void dfs(int r, int c, boolean[][] visited, int[][] heights, int prev) {
        
        int nr = visited.length;
        int nc = visited[0].length;
        if(r<0 || c<0 || r>=nr || c >=nc) return;
        if(heights[r][c] < prev || visited[r][c]) return;
        
        visited[r][c] = true;
        // for(int [] dir : dirs){
        //     dfs(r+dir[0], c+dir[1], visited, heights, heights[r][c]);
        // }
        dfs(r-1, c, visited, heights, heights[r][c]);
        dfs(r+1, c, visited, heights, heights[r][c]);
        dfs(r, c-1, visited, heights, heights[r][c]);
        dfs(r, c+1, visited, heights, heights[r][c]);
    }
}
