package com.personal.leetcode.disjointSetUnion;

import java.util.Arrays;
import java.util.Comparator;

public class EarliestToBecomeFriends_1101 {
    public int earliestAcq(int[][] logs, int n) {

        Arrays.sort(logs, new Comparator<int[]> () {
            @Override
            public int compare(int[] log1, int[] log2) {
                Integer ts1 =  new Integer(log1[0]);
                Integer ts2 = new Integer(log2[0]);
                return ts1.compareTo(ts2);
            }
        });

        // Initially we treat each individual as a separate group
        int connectedComponenets = n;
        UnionFind dsu = new UnionFind(n);

        for(int[] log :  logs) {
            int ts = log[0], friendA = log[1], friendB = log[2];
            if(!dsu.isConnected(friendA, friendB)) {
                dsu.union(friendA, friendB);
                connectedComponenets -= 1;
            }

            if(connectedComponenets == 1) {
                return ts;
            }

        }

        return -1;

        
    }
}

class UnionFind {

    private int[] group;
    private int[] rank;

    public UnionFind(int size) {
        group = new int[size];
        rank = new int[size];

        for(int i = 0 ; i < size ; i++) {
            group[i] = i;
            rank[i] = 1;
        }
    }

    public int find(int x) {
        if(x == group[x]){
            return x;
        }
        return group[x] = find(group[x]);

    }

    public void union(int x, int y) {
        int groupX = find(x);
        int groupY = find(y);
        if(rank[groupX] >  rank[groupY]) {
            group[groupY] = groupX;
        }else if(rank[groupX] < rank[groupY]) {
            group[groupX] = groupY;
        }else {
            group[groupY] = groupX;
            rank[groupX] += 1;
        }
    }

    public boolean isConnected(int x, int y) {
        return find(x) == find(y);
    }
}
