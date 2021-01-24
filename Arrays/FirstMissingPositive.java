/**
 * https://leetcode.com/problems/first-missing-positive/
 * Problem:
 * 
 * Given an unsorted integer array nums, find the smallest missing positive integer.

    Follow up: Could you implement an algorithm that runs in O(n) time and uses constant extra space.?

    

    Example 1:

    Input: nums = [1,2,0]
    Output: 3
    Example 2:

    Input: nums = [3,4,-1,1]
    Output: 2
 */

/**
 * Approach:
 * 
 * Make every integer in array to be in range of 1...n
 * if any integer is less than 1 or greater than n then make it as n+1 respectively (these values are of no use)
 * 
 * Once this is done, we keep updating nums[Math.abs(nums[i])-1] with negative
 * After it is completed we check first positive value in array and return that index + 1
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1)
 */
public class FirstMissingPositive {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        int result = 1;
        
        for(int i=0; i<n; i++) {
            if(nums[i] > n || nums[i] < 1)
                nums[i] = n + 1;
        }

        for(int i=0; i<n; i++) {

            int index = Math.abs(nums[i]);

            if(index > n)
                continue;
            
            if(nums[index-1] > 0)
                nums[index-1] = nums[index-1] * -1;
        }

        while(result<=n) {
            
            if(nums[result-1] > 0)
                return result;
            
            result++;
        }

        
        return result;
        
    }   
}
