package com.personal.leetcode.disjointSetUnion;

// Quick Find
public class DSU_QuickFind {
    private int[] parent;

    public DSU_QuickFind(int size) {
        parent = new int[size];
        for(int i = 0 ; i < size ; i++) {
            parent[i] = i;
        }

    }
    
    //Time : O(1)
    public int find(int x) {
        return parent[x];
    }

    //Time :  O(N)
    public void union(int x, int y) {
        int parentX = find(x);
        int parentY = find(y);

        if(parentX != parentY) {
            for(int i = 0; i < parent.length; i++) {
                if(parent[i] == parentY){
                    parent[i] = parentX;
                }
            }
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }


}

