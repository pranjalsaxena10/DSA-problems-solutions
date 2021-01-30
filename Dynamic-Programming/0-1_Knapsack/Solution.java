/**
 * https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1#
 * 
 * Problem:
 * 
    You are given weights and values of N items, put these items in a knapsack of capacity W to get the maximum total value in the knapsack. Note that we have only one quantity of each item.
    In other words, given two integer arrays val[0..N-1] and wt[0..N-1] which represent values and weights associated with N items respectively. Also given an integer W which represents knapsack capacity, find out the maximum value subset of val[] such that sum of the weights of this subset is smaller than or equal to W. You cannot break an item, either pick the complete item, or don’t pick it (0-1 property).

    Example 1:

    Input:
    N = 3
    W = 4
    values[] = {1,2,3}
    weight[] = {4,5,1}
    Output: 3
    Example 2:

    Input:
    N = 3
    W = 3
    values[] = {1,2,3}
    weight[] = {4,5,6}
    Output: 0
 * 
 */

/**
 * Approach:
 * 
 * Think of choice diagram viz. whether for each article check whether it should be included or not
 * 
 * Time Complexity:
 * O(n^2)
 * 
 * Space Complexity: 
 * O(n^2)
 * 
 */

public class Solution {
    static int[][] dp;

    // Returns the maximum value that can be put in a knapsack of capacity W 
    static int knapSack(int W, int wt[], int val[], int n) 
    { 
         // your code here 
         dp = new int[n+1][W+1];
         
         for(int i=0; i<=n; i++) {
             Arrays.fill(dp[i], -1);
         }
         
         return maxProfit(W, wt, val, n);
    } 
    
    private static int maxProfit(int w, int[] wt, int[] val, int n) {
        if(n == 0 || w == 0) 
            return 0;
            
        if(dp[n][w] != -1)
            return dp[n][w];
            
        if(wt[n-1] <= w)
            return dp[n][w] = Math.max(maxProfit(w-wt[n-1], wt, val, n-1) + val[n-1], maxProfit(w, wt, val, n-1));
        else
            return dp[n][w] = maxProfit(w, wt, val, n-1);
    }    
}
