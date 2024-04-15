package com.personal.leetcode.graphs;

public class NumOfProvinces547_DFS {
    public int findCircleNum(int[][] isConnected) {
        
        int num_cities = isConnected.length;
        int[] visited = new int[num_cities];
        int num_provinces = 0;
        for(int i=0;i< num_cities; i++) {
            if (visited[i] == 0) {
                dfs(isConnected, i, visited);
                num_provinces++;
            }
        }
        return num_provinces;
    }
    
    public void dfs(int[][] isConnected, int start, int[] visited) {
         for(int i=0; i< isConnected[start].length;i++){
            if(isConnected[start][i] == 1 && visited[i] == 0){
                visited[i] = 1;
                dfs(isConnected, i, visited);
            }
         }
    }
}
