package com.personal.leetcode.strings;

public class GCD_Strings_1071 {

    //Time : O(min(m,n) * (m+n))
    public String gcdOfStrings(String str1, String str2) {
        String str = null;
        if(str1.length() < str2.length()) {
            str = str1;
        }else {
            str = str2;
        }
        for(int i = str.length(); i >=1 ; i--) {
            if(checkDivisor(str1, str2, str.substring(0,i))) {
                return str.substring(0,i);
            }
        }

        return "";

        
    }

    public boolean checkDivisor(String str1, String str2, String s) {

        if(str1.length() % s.length() != 0 || str2.length() % s.length() != 0) {
            return false;
        }

        StringBuilder res1 = new StringBuilder();
        int loop1 = str1.length() / s.length();
        while(loop1 > 0) {
            res1.append(s);
            loop1--;
        }
        StringBuilder res2 = new StringBuilder();
        int loop2 = str2.length() / s.length();
        while(loop2 > 0) {
            res2.append(s);
            loop2--;
        }
        if(res1.toString().equals(str1) == true && res2.toString().equals(str2) == true) {
            return true;
        }else {
            return false;
        }

    }
}
