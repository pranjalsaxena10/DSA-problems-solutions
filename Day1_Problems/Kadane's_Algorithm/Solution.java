/**
 * https://leetcode.com/problems/maximum-subarray/
 */

/**
 * Problem is to find max subArray sum for nums
 * Approach is to keep doing sum of every element while maintaing maximum of all sums 
 * and when sum adds to a -ve number then make the sum as 0
 */

class Solution {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int maxSum = 0;
        
        for(int i=0; i<nums.length; i++) {
            maxSum += nums[i];
            
            if(result < maxSum) {
                result = maxSum;
            }
            
            if(maxSum < 0) {
                maxSum = 0;
            }
        }
        
        return result;
    }
}