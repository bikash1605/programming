package com.personal.leetcode.disjointSetUnion;

public class DSU_Optimized {
    
    private int[] parent;
    private int[] rank;

    public DSU_Optimized(int size) {
        parent = new int[size];
        rank = new int[size];

        for(int i = 0 ; i < size; i++) {
            parent[i] = i;
            rank[i] = i;
        }
    }

    // Time O(α(N))
    public int find(int x) {
        if(x == parent[x])
            return x;
        
        return parent[x] = find(parent[x]); 
    }

    // Time O(α(N))
    public void union(int x, int y) {
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


   // Time O(α(N))
    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
