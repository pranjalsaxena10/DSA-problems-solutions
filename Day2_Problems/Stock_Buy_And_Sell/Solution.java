/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
 * 
 * Problem:
 * Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), 
    design an algorithm to find the maximum profit.

    Note that you cannot sell a stock before you buy one.
 */

/**
 * Input: [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
             Not 7-1 = 6, as selling price needs to be larger than buying price.
 */

 /**
  * Approach is to keep tracking of minimum price of stock on each day and also considering max profit by using
    minStock buying price
  */

class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length < 2)
            return 0;
        
        int index = 0;
        int minPrice = prices[index];
        int maxProfit = 0;
        
        for(int i=1; i<prices.length; i++) {
            minPrice = Math.min(minPrice, prices[i]);
            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
        }
        
        return maxProfit;
    }
}