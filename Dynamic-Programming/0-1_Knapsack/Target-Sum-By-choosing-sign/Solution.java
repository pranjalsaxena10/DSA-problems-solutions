/**
 * https://leetcode.com/problems/target-sum/
 * 
 * Problem:
 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S. Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.

    Find out how many ways to assign symbols to make sum of integers equal to target S.

    Example 1:

    Input: nums is [1, 1, 1, 1, 1], S is 3. 
    Output: 5
    Explanation: 

    -1+1+1+1+1 = 3
    +1-1+1+1+1 = 3
    +1+1-1+1+1 = 3
    +1+1+1-1+1 = 3
    +1+1+1+1-1 = 3

    There are 5 ways to assign symbols to make the sum of nums be target 3.
 */

/**
 * Approach:
 * 
 * Total sum => sum
 * target => S
 * 
 * If we take a closer look to the problem, we could see if we partition arr to S1 and S2 subset,
 * S1 => all +ve
 * S2 => all -ve
 * and we have to find out no of ways of doing this where sum(S1) + sum(S2) = target
 * Now this problem is converted to find out count of subsets with given target diff between their sums
 * 
 * Time Complexity: O(n*sum)
 * Space Complexity: O(n*sum)
 */

class Solution {
    private int[][] dp;
    
    public int findTargetSumWays(int[] nums, int S) {
        int n = nums.length;
        int sum = 0;
        int zeroCount = 0;
        
        for(int i=0; i<n; i++) {
            sum += nums[i];
            if(nums[i] == 0)
                zeroCount++;
        }
        
        if(sum < Math.abs(S) || (sum - S) % 2 != 0)
            return 0;
        
        dp = new int[n+1][sum+1];
        count(nums, sum, n);
        
        int x = (sum - S) / 2;
        
        if(x <= sum) {
            return ((int) Math.pow(2, zeroCount)) * dp[n][x];
        }
        
        return 0;
        
    }
    
    private void count(int[] arr, int target, int n) {
        for(int i=0; i<=n; i++) {
            dp[i][0] = 1;
        }
        
        for(int i=1; i<=target; i++) {
            dp[0][i] = 0;
        }
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=target; j++) {
                if(arr[i-1] > j || arr[i-1] == 0)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
            }
        }
    }
}