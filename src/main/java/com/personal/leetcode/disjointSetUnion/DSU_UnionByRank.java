package com.personal.leetcode.disjointSetUnion;

public class DSU_UnionByRank {
    private int[] parent;
    private int[] rank;

    // Time :  O(N)
    public DSU_UnionByRank(int size) {
        parent = new int[size];
        rank = new int[size];

        for(int i = 0 ; i < size ; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    // Time O(logN)
    public int find(int x) {
        while(parent[x] != x) {
            x = parent[x];
        }

        return x;
    }

    //Time : O(logN)
    public void union(int x , int y) {
        int parentX = find(x);
        int parentY = find(y);

        if(rank[parentX] > rank[parentY]) {
            parent[parentY] = parentX;
        }else if(rank[parentX] < rank[parentY]) {
            parent[parentX] = parentY;
        }else {
            parent[parentY] = parentX;
            rank[parentX] += 1;
        }
    }

    //Time : O(logN)
    public boolean isConnected(int x, int y){
        return find(x) == find(y);
    }
}
