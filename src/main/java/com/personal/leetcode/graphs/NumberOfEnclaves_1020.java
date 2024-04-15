package com.personal.leetcode.graphs;

public class NumberOfEnclaves_1020 {

    // Time :O(m*n)
    //Space : O(m*n)
    void dfs(int x, int y, int row, int col, int[][] grid, boolean[][] visited) {
        //check boundary condition
        if(x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == 0 || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        int[][] dirs = new int[][] {{-1, 0}, {0, -1},{1, 0}, {0,1}};
        for(int[] dir : dirs) {
            dfs(x+dir[0], y+dir[1], row, col, grid, visited);
        }

        return;
    }



    public int numEnclaves(int[][] grid) {
        
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];

        for(int i = 0 ; i< row; i++) {

            // First Col
            if(grid[i][0] == 1 && !visited[i][0]){
                dfs(i, 0, row, col,grid,  visited);
            }

            //Last Col
            if(grid[i][col - 1] == 1 && !visited[i][col - 1]){
                dfs(i, col - 1, row, col,grid,  visited);
            }
        }


        for(int i = 0 ; i < col; i++) {

            // First row
            if(grid[0][i] == 1 && !visited[0][i]){
                dfs(0, i, row, col,grid,  visited);
            }

            //Last row
            if(grid[row - 1][i] == 1 && !visited[row - 1][i]){
                dfs(row - 1, i, row, col,grid,  visited);
            }
        }


        int count = 0;
        for(int i = 0 ; i < row ; i++) {
            for(int j = 0; j< col ; j++) {
                if(grid[i][j] == 1 && !visited[i][j]) {
                    count++;
                }
            }
        }

        return count;
    }
}
