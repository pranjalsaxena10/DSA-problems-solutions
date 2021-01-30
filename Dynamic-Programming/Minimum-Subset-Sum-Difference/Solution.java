/**
 * https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1#
 * 
 * Problem:
 * 
 * Minimum sum partition 
 * Given an integer array arr of size N, the task is to divide it into two sets S1 and S2 such that the 
 * absolute difference between their sums is minimum and find the minimum difference

    Example 1:

    Input: N = 4, arr[] = {1, 6, 11, 5} 
    Output: 1
    Explanation: 
    Subset1 = {1, 5, 6}, sum of Subset1 = 12 
    Subset2 = {11}, sum of Subset2 = 11   
    Example 2:
    Input: N = 2, arr[] = {1, 4}
    Output: 3
    Explanation: 
    Subset1 = {1}, sum of Subset1 = 1
    Subset2 = {4}, sum of Subset2 = 4

    Your Task:  
    You don't need to read input or print anything. Complete the function minDifference() which takes N and array arr as input parameters and returns the integer value

    Expected Time Complexity: O(N*|sum of array elements|)
    Expected Auxiliary Space: O(N*|sum of array elements|)

    Constraints:
    1 ≤ N*|sum of array elements| ≤ 10^6
 */

/**
 * Approach:
 * 
 * we have to divide given arr in two subsets such that absolute difference between those 2 is minimized
 * 
 * First insight would be,
 * if we take two subsets sums as S1 and S2 then, (S1 + S2) belongs to [0, S], S=> total sum of input arr
 * thus assume first set sum to be "x" => second sum would be "S-x"
 * and if we keep x <= S/2 then S-x >= S/2
 * 
 * so we have to minimize S-x-x => S-2*x where x can range between [0, S/2]
 * 
 * One more point every x within [0, S/2] will not be useful,
 * For x to be considered, there must be a subset having sum equals to x
 * In order to find out all x in range [0, S/2], having a subset, we can do this
 * 
    * If we do iterative approach of DP problem is there a subset having target sum
    * then we can have a matrix
    * boolean dp[n+1][sum+1] => dp[i][j] denotes whether for length "i" do we have any subset having target sum "j"
 * 
 * Once we get this matrix filled, we need to check last row only, since it would only be holding results 
 * for whole array length. True would be denoting subset can be found
 * result = INFINITY
 * Once all this done we can check for x E [0, S/2] => dp[n][x] ? min(result, 2*(S-x)) : do nothing
 * 
 * Time Complexity: O(n * S)
 * Space Complexity: O(n * S)
 * 
 */
public class Solution {
    
    private boolean[][] dp;
    
	public int minDiffernce(int arr[], int n) 
	{ 
	    // Your code goes here
	    int sum = 0;
	    
	    for(int i=0; i<arr.length; i++) {
	        sum += arr[i];
	    }
	    
	    dp = new boolean[n+1][sum+1];
	    
	    isSubset(arr, sum, n);
	    
	    int minimumAbsoluteDifference = Integer.MAX_VALUE;
	    
	    for(int i=0; i<=sum/2; i++) {
	        if(dp[n][i])
    	        minimumAbsoluteDifference = Math.min(minimumAbsoluteDifference, sum-2*i);
	    }
	    
	    return minimumAbsoluteDifference;
	} 
	
	private void isSubset(int[] arr, int target, int n) {
        
        for(int i=0; i<=n; i++) {
            dp[i][0] = true;
        }
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=target; j++) {
                
                if(arr[i-1] > j)
                    dp[i][j] = dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
            }
        }
	    
	}    
}
