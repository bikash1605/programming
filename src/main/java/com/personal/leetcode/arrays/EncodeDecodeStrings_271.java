package com.personal.leetcode.arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EncodeDecodeStrings_271 {
    // Encodes a list of strings to a single string.
    public String encode1(List<String> strs) {
        
        //empty string case
        if (strs.size() == 0) return Character.toString((char)258);
        
        StringBuilder sb = new StringBuilder();
        String delimiter = Character.toString((char)(257));
        for(String st: strs) {
            sb.append(st).append(delimiter);
        }
        sb.deleteCharAt(sb.length() - 1);
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode1(String s) {
        //empty string case
        String delimiter = Character.toString((char)(258));
        if(s.equals(delimiter)) return new ArrayList<String>();
        
        delimiter = Character.toString((char)(257));
        return Arrays.asList(s.split(delimiter, -1));
        
    }

    /**
     * APPROACH - 2
     * @param strs
     * @return
     */
    public String encode2(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String str : strs) {
            encodedString.append(str.length()).append("#").append(str);
        }
        return encodedString.toString();
    }

    public List<String> decode2(String str) {
        List<String> list = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            int j = i;
            while (str.charAt(j) != '#') j++;

            int length = Integer.valueOf(str.substring(i, j));
            i = j + 1 + length;
            list.add(str.substring(j + 1, i));
        }
        return list;
    }
}
