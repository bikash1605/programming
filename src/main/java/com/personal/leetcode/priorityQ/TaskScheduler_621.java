package com.personal.leetcode.priorityQ;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TaskScheduler_621 {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        
        PriorityQueue<Integer> max_heap = new PriorityQueue<>((a, b) -> b - a);
        Queue<int[]> q = new LinkedList<>();
        int[] char_map = new int[26];
        for(char ch : tasks) {
            char_map[ch - 'A']++;
        }
        for(int i = 0 ; i < 26; i++) {
            if(char_map[i] > 0)max_heap.add(char_map[i]);
        }

        int time = 0;
        while(!max_heap.isEmpty() || !q.isEmpty()) {
            time++;

            if(!max_heap.isEmpty()) {
                int val = max_heap.poll();
                val--;
                if(val > 0)q.add(new int[]{val, time+n});
            }


            if(!q.isEmpty() && q.peek()[1] == time) {
                max_heap.add(q.poll()[0]);
            }

        }

        return time;
    }
}
