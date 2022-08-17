package com.personal.leetcode.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class NumOfProvinces547_BFS {
    public int findCircleNum(int[][] M) {
        
        int[] isVisited = new int[M.length];
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0; i< M.length; i++) {
            if(isVisited[i] == 0) {
                q.add(i);
                while(!q.isEmpty()) {
                    int s = q.remove();
                    isVisited[s] = 1;
                    for(int j=0;j<M.length;j++) {
                        if(M[s][j] == 1 && isVisited[j] == 0){
                            q.add(j);
                        }
                    }
                }
                count++;
            }
        }
        return count;
    }
}
