/**
 * https://leetcode.com/problems/search-in-rotated-sorted-array/
 * 
 * 
 * Biggest note in this type of problem is to ask interviewer, whether array can have duplicates or not
 * If duplicates are not allowed then this solution works fine
 * 
 * If duplicates are allowed then we have to add below condition
 * 
 * if(nums[mid] == nums[left]) {
        left++;
        continue;
    }
 * This makes worst case time complexity of the solution to be O(n)
 * If duplicates are allowed: Problem link => https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
 * 
 * 
 * Problem: 
 * 
 * You are given an integer array nums sorted in ascending order (with distinct values), and an integer target.

    Suppose that nums is rotated at some pivot unknown to you beforehand (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).

    If target is found in the array return its index, otherwise, return -1.

    

    Example 1:

    Input: nums = [4,5,6,7,0,1,2], target = 0
    Output: 4
    Example 2:

    Input: nums = [4,5,6,7,0,1,2], target = 3
    Output: -1
 */


/**
 * Approach:
 * 
 * If element is found then return it's index
 * 
 * if not found then,
 * 
 * check which subarray is sorted, select sorted subarray and check if target occurs in that subarray range
 * if it doesn't fall in that range then search in other subarray
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1) 
 */

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        
        while(left<=right) {
            int mid = left + (right - left)/2;
            
            if(nums[mid] == target)
                return mid;
            
            /**
             * This condition is required in case of duplicates are allowed in the array
             */
            // if(nums[mid] == nums[left]) {
            //     left++;
            //     continue;
            // }

            if(nums[mid] >= nums[left]) {
                if(nums[left] <= target && nums[mid] >= target)
                    right = mid - 1;
                else
                    left = mid + 1;
                
            } else {
                if(nums[right] >= target && nums[mid] <= target)
                    left = mid + 1;
                else
                    right = mid - 1;
            }
        }
        
        return -1;
    }
}