/**
 * Problem
 * https://practice.geeksforgeeks.org/problems/knapsack-with-duplicate-items4201/1#
 * 
 * Given a set of N items, each with a weight and a value, and a weight limit W. Find the maximum value of a
 *  collection containing any of the N items any number of times so that the total weight is less than or equal 
 * to W.

    Example 1:

    Input: N = 2, W = 3
    val[] = {1, 1}
    wt[] = {2, 1}
    Output: 3
    Explaination: Pick the 2nd element thrice.
    

    Example 2:

    Input: N = 4, W = 8
    val[] = {1, 4, 5, 7}
    wt[] = {1, 3, 4, 5}
    Output: 11
    Explaination: The optimal choice is to 
    pick the 2nd and 4th element.

 */

/**
 * Approach:
 * Only difference unbounded and bounded is one element can be taken multiple times
 * If we take element then we can reconsider it
 * If it is not possible to take it again then it's not considered
 * 
 * Time Complexity : O(N*W)
 * Space Complexity: O(N*W)
 */

public class Solution {
    private static int[][] dp;
    static int knapSack(int N, int W, int val[], int wt[])
    {
        // code here
        
        dp = new int[N+1][W+1];
        
        for(int i=0; i<=N; i++) 
            Arrays.fill(dp[i], -1);
            
        return unBoundedKnapsack(N, W, val, wt);
    }
    
    private static int unBoundedKnapsack(int n, int capacity, int[] val, int[] weight) {
        
        if(n==0)
            return 0;
            
        if(dp[n][capacity] != -1)
            return dp[n][capacity];
            
        if(weight[n-1] > capacity) {
            return dp[n][capacity] = unBoundedKnapsack(n-1, capacity, val, weight);
        } else {
            return dp[n][capacity] = Math.max(unBoundedKnapsack(n, capacity-weight[n-1], val, weight) + val[n-1]
                            , unBoundedKnapsack(n-1, capacity, val, weight));
        }
    }
}
