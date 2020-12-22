/**
 * https://leetcode.com/problems/single-element-in-a-sorted-array/
 * 
 * Problem:
 * 
 * You are given a sorted array consisting of only integers where every element appears exactly twice, except for one element which appears exactly once. Find this single element that appears only once.

    Follow up: Your solution should run in O(log n) time and O(1) space.

    

    Example 1:

    Input: nums = [1,1,2,3,3,4,4,8,8]
    Output: 2
    Example 2:

    Input: nums = [3,3,7,7,10,11,11]
    Output: 10
 */

/**
 * Approach:
 * 
 * 1. Since array is sorted and it is mentioned that all elements except one occurs twice
 * 2. Thus 1st occurrence occurs at even positions and it's duplicate occurs at odd
 * 
 * Time Complexity: O(logN)
 * Space Complexity: O(1)
 */
class Solution {
    public int singleNonDuplicate(int[] nums) {
           
        return find(nums, 0, nums.length-1);

    }
    
    private int find(int[] nums, int left, int right) {
        
        if(left >= right)
            return nums[left];
        
        int mid = left+right+1>>1;
        
        if(mid%2 == 0) {
            
            if(nums[mid] == nums[mid+1])
                return find(nums, mid+2, right);
            else
                return find(nums, left, mid);
            
        } else {
            
            if(nums[mid] == nums[mid-1])
                return find(nums, mid+1, right);
            else
                return find(nums, left, mid-1);
            
        }
        
    }
}