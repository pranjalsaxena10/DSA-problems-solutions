/**
 * https://practice.geeksforgeeks.org/problems/subset-sum-problem2014/1#
 * 
 * Problem:
 * Given an array arr[] of size N, check if it can be partitioned into two parts such that the sum of elements in both parts is the same.

    Example 1:

    Input: N = 4
    arr = {1, 5, 11, 5}
    Output: YES
    Explaination: 
    The two parts are {1, 5, 5} and {11}.

    Example 2:

    Input: N = 3
    arr = {1, 3, 5}
    Output: NO
    Explaination: This array can never be 
    partitioned into two such parts.

    Your Task:
    You do not need to read input or print anything. Your task is to complete the function equalPartition() which takes the value N and the array as input parameters and returns 1 if the partition is possible. Otherwise, returns 0.


    Expected Time Complexity: O(N*sum of elements)
    Expected Auxiliary Space: O(N*sum of elements)
 * 
 */

/**
 * Approach:
 * 
 * Same as knapsack pattern
 * 
 * Time Complexity: O(n*sum of arr[])
 * Space Complexity: O(n*sum of arr[])
 */

public class Solution {

    private static boolean[][] dp;
    
    static int equalPartition(int N, int arr[])
    {
        // code here
        int target = 0;
        
        for(int i=0; i<N; i++) {
            target += arr[i];    
        }
        
        /**
         * In case of finding equal sum partition => total sum is checked => 
         * if odd then not possible
         * if even then call isSubsetSumPossible() method with proper values to find out any possible subset
         * exists or not
         */
        if(target % 2 != 0)
            return 0;
            
        target = target / 2;
        
        dp = new boolean[N+1][target+1];
        
        return isSubsetSumPossible(arr, N, target) ? 1 : 0;
    }
    
    /**
     * * This function is used in order to find out is there any subset which has sum as target (given) value
     * @param arr
     * @param n
     * @param target
     * @return
     */
    private static boolean isSubsetSumPossible(int[] arr, int n, int target) {
        
        if(target == 0)
            return true;
            
        if(n == 0)
            return false;
        
        if(dp[n][target])
            return dp[n][target];
        
        if(arr[n-1] > target)
            return dp[n][target] = isSubsetSumPossible(arr, n-1, target);
        
        else
            return dp[n][target] = isSubsetSumPossible(arr, n-1, target - arr[n-1])
                                    || isSubsetSumPossible(arr, n-1, target);
        
    }
}
