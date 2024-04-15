package com.personal.leetcode;

import java.util.Arrays;
import java.util.Collections;
import java.util.Optional;

public class Test{

    public static String distinctIntegers(String s, int numRows) {

        if(numRows == 1) return s;
        StringBuilder[] map = new StringBuilder[numRows];
        for(int i = 0 ; i < numRows ; i++) {
            map[i] = new StringBuilder();
        }

        Integer[] index = new Integer[numRows];
        for(int i = 0 ; i < numRows ; i++) {
            index[i] = i;
        }
        int strindex = 0;

        for(int i = 0; i < numRows; i++) {
            map[index[i]].append(s.charAt(strindex));
            strindex++;  
        }

        while(strindex < s.length()) {
            Collections.reverse(Arrays.asList(index));
            for(int i = 1; i < numRows && strindex < s.length(); i++) {
                map[index[i]].append(s.charAt(strindex));  
                strindex++;         
            }
        }


        //contenate
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < numRows; i++) {
            res.append(map[i]);
        }
        return res.toString();
        
    }
public static void main(String[] args) {

        // using the of method to create an Optional instance with value "B+"
        Optional<String> grade = Optional.of("B+");
        String opt1 = "Not null";
        String opt2 = null;

        System.out.println("Non-Empty Optional: " + grade);
        System.out.println("Value of Non-Empty Optional: " + grade.get());
        
        // Printing an empty instance of Optional with the empty method
        System.out.println("Empty Optional: " + Optional.empty());

        System.out.println("ofNullable on Non-Empty Optional: " + Optional.ofNullable(opt1));
        System.out.println("ofNullable on Empty Optional: " + Optional.ofNullable(opt2));

        if(Optional.ofNullable(opt1).isPresent()){
            System.out.println("of on Non-Empty Optional: " + Optional.of(opt1));
        }

        if(Optional.ofNullable(opt2).isPresent()){
            System.out.println("of on Empty Optional: " + Optional.of(opt2));
        }
    }
}