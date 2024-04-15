package com.personal.leetcode.graphs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WallsAndGates_286 {

    //Time : O(M*N)   Space = O(M*N)
    public void wallsAndGates(int[][] rooms) {
        
        int nr = rooms.length;
        int nc = rooms[0].length;

        List<int[]> gates = new ArrayList<>();
        Queue<List<Integer>> bfsQ = new LinkedList<>();
        for(int i = 0; i < nr ; i++) {
            for(int j = 0; j < nc ; j++) {
                if(rooms[i][j] == 0){
                    // gates.add(new int[] {i, j});
                    List<Integer> element = new ArrayList<>();
                    element.add(i);element.add(j);
                    bfsQ.add(element);
                }
            }
        }

        int INF = 2147483647;
        int[][] dirs = new int[][] {{1,0}, {-1, 0}, {0,1}, {0,-1}};
        
        
        while(!bfsQ.isEmpty()) {
            List<Integer> ls = bfsQ.poll();
            int r = ls.get(0);
            int c = ls.get(1);
            for(int[] dir : dirs) {
                int x = r + dir[0];
                int y = c + dir[1];
                if(x  < 0 || y < 0 || x >= nr || y >= nc || rooms[x][y] != INF) {
                    continue;
                }

                rooms[x][y] = 1 + rooms[r][c];
                List<Integer> element = new ArrayList<>();
                element.add(x);element.add(y);element.add(rooms[x][y]);
                bfsQ.add(element);
            }
        }
    }
}
