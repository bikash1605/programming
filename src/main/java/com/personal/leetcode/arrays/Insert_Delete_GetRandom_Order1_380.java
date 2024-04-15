package com.personal.leetcode.arrays;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Insert_Delete_GetRandom_Order1_380 {
    Set<Integer> hashSet;
    Random rand = new Random();
    
    public Insert_Delete_GetRandom_Order1_380() {
        this.hashSet = new HashSet<>();
    }
    
    public boolean insert(int val) {
        if(this.hashSet.contains(val))
            return false;
        else {
            this.hashSet.add(val);
            return true;
        }
    }
    
    public boolean remove(int val) {
        if(this.hashSet.contains(val)) {
            this.hashSet.remove(val);
            return true;
        }
        else {
            return false;
        }
    }
    
    public int getRandom() {
        List<Integer> list = new ArrayList<>(this.hashSet);
        return list.get(rand.nextInt(list.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */