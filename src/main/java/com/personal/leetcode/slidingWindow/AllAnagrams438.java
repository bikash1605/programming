package com.personal.leetcode.slidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AllAnagrams438 {
    public List<Integer> findAnagrams(String s, String p) {
        
        int ns = s.length(), np = p.length() ;
        List<Integer> output = new ArrayList<>();
        //1. Initialize  a hash map on the reference string : refHashMap
        Map<Character, Integer> refHashMap = new HashMap<>();
        for (int i=0; i< np; i++) {
            char ch = p.charAt(i);
            if (refHashMap.containsKey(ch)) {
                refHashMap.put(ch, refHashMap.get(ch) + 1);
            } else {
                refHashMap.put(ch,1);
            }
        }
        //2. Iterate through the input string using a slidow window of length = len(reference)
        //For every window interation, insert the counts into input string hash map (character -> count) : inputHashMap
        Map<Character, Integer> inputHashMap = new HashMap<>();
        for (int i=0; i< ns; i++) {
            char ch = s.charAt(i);
            if (inputHashMap.containsKey(ch)) {
                inputHashMap.put(ch, inputHashMap.get(ch) + 1);
            } else {
                inputHashMap.put(ch,1);
            }
            
            
            //remove one letter from left
            if(i>=np) {
                ch = s.charAt(i-np);
                if(inputHashMap.get(ch) == 1) {
                    inputHashMap.remove(ch);
                }else { 
                    // if the element to be removed has count > 1 as the element that was getting added to window is same as ch
                    inputHashMap.put(ch, inputHashMap.get(ch) - 1);
                }
                
            }
            //4. If both hashmap are equal, (refHashMap == inputHashMap), store it into an ArrayList
            if(inputHashMap.equals(refHashMap)){
                output.add(i -np + 1);
            }
            
            
        }

         //5. return arrayList
        return output;
        
    }
}
