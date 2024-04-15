package com.personal.leetcode.disjointSetUnion;

public class DSU_QuickUnion {
    private int[] parent;

    public  DSU_QuickUnion(int size) {
        parent = new int[size];
        for(int i = 0; i < size; i ++) {
            parent[i] = i;
        }
    }

    // Time : O(N)
    public int find(int x) {
        while(parent[x] != x) {
            x = parent[x];
        }
        return x;
    }

    // Time : O(N) but ideally less than O(N)
    public void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);
        if(parentX  != parentY) {
            parent[parentY] = parentX;
        }
    }

    public boolean isConected(int x , int y) {
        return find(x) == find(y);
    }
}
