package com.personal.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams_49 {
    public String getHashCode(String s, int[] count) {
        
        Arrays.fill(count, 0);
        for(char c: s.toCharArray()) {
            count[c - 'a']++ ;
        }
        StringBuilder sb = new StringBuilder("");
        for(int i = 0; i< 26; i++) {
            sb.append('#');
            sb.append(count[i]);
        }
            
        return sb.toString();
    }
    
    public List<List<String>> groupAnagrams(String[] strs) {
        
        Map<String, List<String>> group = new HashMap<>();
        int[] count = new int[26];
        for(int i = 0; i< strs.length ; i++) {
            String key = getHashCode(strs[i], count);
            if(group.containsKey(key)) {
                List<String> val = group.get(key);
                val.add(strs[i]);
                group.put(key, val);
            }else {
                group.put(key, new ArrayList<String>(Arrays.asList(strs[i])));
            }
        }
        
        return new ArrayList(group.values());
    }
    
}
