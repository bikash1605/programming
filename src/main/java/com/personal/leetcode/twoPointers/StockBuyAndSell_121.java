package com.personal.leetcode.twoPointers;

public class StockBuyAndSell_121 {

    /**
     * One Pass Approach - Stocks can be bought ina single day and sold in a different date
     * Time Complexity = O(n)
     * Space Complexity = O(1)
     */
    public int maxProfit_121(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else if (prices[i] - minprice > maxprofit)
                maxprofit = prices[i] - minprice;
        }
        return maxprofit;
    }

    /**
     * Stocks can be bought and sold multiple times
     * Time Complexity = O(n)
     * Space Complexity = O(1)
     */
    public int maxProfit_122(int[] prices) {
        int maxProfit = 0;
        int localMinima = Integer.MAX_VALUE;
        int localMaxima = -1;
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < localMinima) {
                localMinima = prices[i];
            }else if(prices[i] - localMinima > 0) {
                maxProfit += prices[i] - localMinima;
                localMaxima = prices[i];
                localMinima = prices[i];
            }else {
                localMinima = prices[i];
            }
        }
        return maxProfit;
    }
}
