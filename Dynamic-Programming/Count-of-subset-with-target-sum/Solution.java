/**
 * https://www.geeksforgeeks.org/count-of-subsets-with-sum-equal-to-x/
 * 
 * Problem:
 * 
 * Given an array arr[] of length N and an integer X, the task is to find the number of subsets with sum equal to X.

    Examples:

    Input: arr[] = {1, 2, 3, 3}, X = 6
    Output: 3
    All the possible subsets are {1, 2, 3},
    {1, 2, 3} and {3, 3}

    Input: arr[] = {1, 1, 1, 1}, X = 1
    Output: 4
 * 
 */

/**
 * Approach:
 * 
 * 1. First think of solution through recursion
 * 2. Count is required
 * 3. Each array element is having a choice whether do we have to take it or not
 * 4. In order to calculate all such subsets that will have sum as target 
 *      => add (count which can be obtained by considering that element) and (count when element is not considered)
 * 5. If array element is itself greater than target value then, by considering that element we can't reach to 
 *      solution
 * 
 * Time Complexity: O(n*target)
 * Space Complexity: O(n*target) 
 */
class Solution {
    private int[][] dp;
    
    public int numSubseq(int[] nums, int target) {
        int n = nums.length;
        
        dp = new int[n+1][target+1];
        
        return find(nums, target, n);
    }
    
    private int find(int[] arr, int target, int n) {
        
        if(n == 0) {
            if(target == 0)
                return 1;
            else
                return 0;
        }
        
        if(dp[n][target] != 0)
            return dp[n][target];
        
        if(arr[n-1] > target)
            return dp[n][target] = find(arr, target, n-1);
        else
            return dp[n][target] = find(arr, target - arr[n-1], n-1) + find(arr, target, n-1);
        
    }
    
}