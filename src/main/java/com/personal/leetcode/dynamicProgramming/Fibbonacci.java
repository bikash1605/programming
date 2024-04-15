package com.personal.leetcode.dynamicProgramming;

public class Fibbonacci {

    // Memoization Technique - O(n)
    // Time : O(n), Space O(n)
    public long nthFibbonacci(int n, long[] memo) {
        if(memo[n] !=0) return memo[n];
        if(n<=2) return 1;
        memo[n] =  nthFibbonacci(n-1, memo) + nthFibbonacci(n-2, memo);
        return memo[n];
    }
    
    // Bottom Up
    //Time : O(n), Space O(n)
    public long nthFibbonacciBottomUp(int n) {
        long[] fib = new long [n+1];
        fib[1] = 1;
        fib[2] = 1;
        for(int i=3;i<=n;i++){
            fib[i] = fib[i-1] + fib[i-2];
        }

        return fib[n];
    }

    public static void main(String args[]){
        Fibbonacci fb = new Fibbonacci();
        long[] memo = new long[100];
        //Memoization
        System.out.println(fb.nthFibbonacci(7, memo));
        System.out.println(fb.nthFibbonacci(10, memo));
        System.out.println(fb.nthFibbonacci(50, memo));

        //Bottom UP
        System.out.println(fb.nthFibbonacciBottomUp(7));
        System.out.println(fb.nthFibbonacciBottomUp(50));
        

    }
}
