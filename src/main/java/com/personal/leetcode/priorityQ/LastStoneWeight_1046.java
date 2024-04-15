package com.personal.leetcode.priorityQ;

import java.util.PriorityQueue;

public class LastStoneWeight_1046 {

    //Time : O(NlogN)
    //Space : O(N)
    public int lastStoneWeight(int[] stones) {
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> b-a);
        for(int stone : stones) {
            pq.add(stone);
        }

        while(pq.size() > 1) {
            int max1 = pq.poll();
            int max2 = pq.poll();
            if(max1 == max2) continue;
            else {
                pq.add(Math.abs(max1 - max2));
            }
            
        }

        return (pq.size() == 1) ? pq.poll() : 0;
    }
}
