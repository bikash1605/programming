package com.personal.leetcode.disjointSetUnion;

public class RedundantConnection_684 {

    //Time : O(Nα(N))≈O(N)
    public int[] findRedundantConnection(int[][] edges) {

        int[] result = null;
        UnionFind dsu  = new UnionFind(1001);
        for(int[] edge : edges) {
            if(dsu.isConnected(edge[0],edge[1])){
                result = edge;
            }else {
                dsu.union(edge[0], edge[1]);
            }
        }

        return result; 
    }
}

class UnionFind {
    int [] parent;
    int [] rank;

    public UnionFind(int size) {
        parent = new int[size];
        rank = new int[size];

        for(int i = 0 ; i < size ; i++) {
            parent[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if(x == parent[x]) return x;

        return parent[x] = find(parent[x]);
    }

    public void union(int x , int y) {
        int parentX = find(x);
        int parentY = find(y);
        
        if(rank[parentX] > rank[parentY]) {
            parent[parentY] = parentX;
        }else if(rank[parentX] < rank[parentY]){
            parent[parentX] = parentY;
        }else {
            parent[parentY] = parentX;
            rank[parentX] += 1;
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
