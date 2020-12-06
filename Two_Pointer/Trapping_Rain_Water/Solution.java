/**
 * https://leetcode.com/problems/trapping-rain-water/
 * 
 * Problem:
 * 
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, 
 * compute how much water it can trap after raining.
 * 
 * Example 1:
 * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
    Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. 
    In this case, 6 units of rain water (blue section) are being trapped.

    Example 2:

    Input: height = [4,2,0,3,2,5]
    Output: 9
 */

/**
 * Approach:
 * 1. Maintain two parameters as left and right
 * 2. left = 0 , right = nums.length - 1
 * 3. Also maintain leftMax and rightMax which will store maximum from both the sides
 * 4. Each point of iteration left < right, keep checking whether nums[left] <= nums[right]
 *      and if it is then update leftMax with larger value in leftMax and nums[left] and also update 
 *      result with diff of height as result += leftMax - height[left]
 *      
 *      ans if nums[left] > nums[right]
 *          then update rightMax with larger value in rightMax and nums[right] and also update
 *          result with diff of height as result += rightMax - height[right]
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
class Solution {
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        
        int left = 0;
        int right = height.length - 1;
        
        int result = 0;
        
        while(left<right) {
            
            if(height[left] <= height[right]) {
                
                leftMax = Math.max(leftMax, height[left]);
                result += leftMax - height[left];
                left++;
                
            } else {
                
                rightMax = Math.max(rightMax, height[right]);
                result += rightMax - height[right];
                right--;
            }
        }
        
        return result;
    }

}