/**
 * https://leetcode.com/problems/max-consecutive-ones/
 * 
 * Problem:
 * 
 * Given a binary array, find the maximum number of consecutive 1s in this array.

    Example 1:
    Input: [1,1,0,1,1,1]
    Output: 3
    Explanation: The first two digits or the last three digits are consecutive 1s.
        The maximum number of consecutive 1s is 3.
    Note:

    The input array will only contain 0 and 1.
    The length of input array is a positive integer and will not exceed 10,000
 * 
 */

/**
 * Approach: 
 * 1. Keep increasing length by 1 when 1 is encountered
 * 2. Keep tracking max length in result variable
 * 3. Every time when current element is not 1 make length as 0
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int result = 0;
        int consecutiveOnesLength = 0;
        
        for(int i=0; i<nums.length; i++) {
            
            if(nums[i] == 1)
                consecutiveOnesLength++;
            else
                consecutiveOnesLength = 0;
            
            result = Math.max(result, consecutiveOnesLength);
        }
        
        return result;
    }

}