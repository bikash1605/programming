package com.personal.maths;

import java.util.ArrayList;
import java.util.List;

/**
 * Program to find prime numbers withing a given range
 *
 */
public class PrimeNumberSieve 
{
    public static void main( String[] args )
    {
        System.out.println(findAllPrimesUpto(100));
    }

    private static List<Integer> findAllPrimesUpto(final int n) {
        final boolean[] touched = new boolean[n+1];
        final double sqrtOfN = Math.sqrt(n);
        final List<Integer> primes = new ArrayList<>();

        //adding 2 as the first prime number
        primes.add(2);
        for (int i =2; i< n; i+=2){
            touched[i] = true;
        }

        for(int i =3; i<=sqrtOfN; i++){
            if(!touched[i]){
                for(int j=i*i; j<=n; j+=i) {
                    touched[j] = true;
                }
            }
        }

        for (int i=2; i<=n ; i++){
            if(!touched[i]){
                primes.add(i);
            }
        }

        return primes;
    }
}
