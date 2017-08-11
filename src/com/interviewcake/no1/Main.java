package com.interviewcake.no1;

// Write an efficient function that takes stockPricesYesterday
// and returns the best profit I could have made from 1 purchase
// and 1 sale of 1 Apple stock yesterday. You must buy before you sell.
// You may not buy and sell in the same time step (at least 1 minute must pass).
// For example:
//
// int[] stockPricesYesterday = new int[] {10, 7, 5, 8, 11, 9};
// getMaxProfit(stockPricesYesterday);
// returns 6 (buying for $5 and selling for $11)



public class Main {

    // not good. it is O(n^2) and also don't work for negative profit.
    public static int getMaxProfit(int[] prices){
        int maxProfit = 0;
        for (int i = 0; i < prices.length-1; i++) {
            int maxFromRemaining = 0;
            for (int j = i+1; j < prices.length; j++) {
                maxFromRemaining = Math.max(maxFromRemaining, prices[j]);
            }
            int potentialProfit = maxFromRemaining - prices[i];
            maxProfit = Math.max(maxProfit, potentialProfit);
        }
        return maxProfit;
    }


    // it is O(n) time and O(1) space
    public static int getMaxProfit2(int[] prices){
        if (prices.length < 2) {
            throw new IllegalArgumentException("at least 2 prices needed");
        }
        int currentMin = prices[0];
        int maxProfit = prices[1] - prices[0];

        for (int i = 1; i < prices.length; i++) {
            int currentPrice = prices[i];

            // see what our profit would be if we bought at the
            // min price and sold at the current price
            int potentialProfit = currentPrice - currentMin;

            // update maxProfit if we can do better
            maxProfit = Math.max(maxProfit, potentialProfit);

            // update minPrice so it's always
            // the lowest price we've seen so far
            currentMin = Math.min(currentMin, currentPrice);

        }
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] stockPrices1 = new int[] {40, 41, 20, 10, 15};
        int[] stockPrices2 = new int[] {40, 30, 20, 10, 5};
        int[] stockPrices3 = new int[] {40, 40, 40, 40, 40};
        System.out.println(getMaxProfit2(stockPrices1));
        System.out.println(getMaxProfit2(stockPrices2));
        System.out.println(getMaxProfit2(stockPrices3));
    }

}
