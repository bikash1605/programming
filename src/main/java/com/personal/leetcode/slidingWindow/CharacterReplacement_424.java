package com.personal.leetcode.slidingWindow;

import java.util.HashMap;
import java.util.Map;

public class CharacterReplacement_424 {
    public int characterReplacement(String s, int k) {
        
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;
        int ans = 0;
        
        for(int right = 0; right < s.length(); right++) {
            char key = s.charAt(right);
            map.put(key, map.getOrDefault(key, 0) + 1);
            
            //int window_size = right - left + 1;
            while((right - left + 1) - getMaxCount(map) > k) {
                char key_to_remove = s.charAt(left);
                map.put(key_to_remove, map.get(key_to_remove) - 1);
                left += 1;
            }
            
            ans = Math.max(ans, right - left + 1);
        }
        
        return ans;
    }
    
    public int getMaxCount(Map<Character, Integer> map) {
        
        int max = -1;
        for(int value : map.values()) {
            if(value > max) {
                max = value;
            }
        }  
        return max;
    }
}
