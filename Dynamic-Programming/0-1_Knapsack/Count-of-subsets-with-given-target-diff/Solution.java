/**
 * Problem:
 * 
 * We have to find how many subsets are there which have difference of their sums as given target value
 */

/**
 * Approach:
 * 
 * arr => input array
 * sum => total sum of arr
 * x => First Subset sum
 * (sum-x) => Second subset sum
 * 
 * First subset sum would be calculated as (sum-target)/2
 * Second subset sum would be calculated as (sum+target)/2
 * 
 * Now problem is to find out count of subsets having target sum as either (sum-target)/2 or (sum+target)/2
 * 
 * Time Complexity: O(n*sum)
 * Space Complexity: O(n*sum)
 */
public class Solution {
    
    private int[][] dp;

    public int countOfSubsetsWithDiff(int[] arr, int target) {

        int sum = 0;
        int n = arr.length;

        for(int i=0; i<n; i++) 
            sum += arr[i];
        
        dp = new int[n+1][sum+1];

        prepareCount(arr, sum, n);

        int x = (sum-target)/2;
        return dp[n][x];
    }

    private void prepareCount(int[] arr, int sum, int n) {
        
        for(int i=0; i<=n; i++) {
            dp[i][0] = 1;
        }

        for(int i=1; i<=sum; i++) {
            dp[0][i] = 0;
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=sum; j++) {
                if(arr[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] + dp[i-1][j-arr[i-1]];
            }
        }

    }
}
