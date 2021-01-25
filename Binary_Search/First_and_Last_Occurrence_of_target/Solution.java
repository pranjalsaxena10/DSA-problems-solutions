/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
 * 
 * Problem: 
 * 
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.

    If target is not found in the array, return [-1, -1].

    Follow up: Could you write an algorithm with O(log n) runtime complexity?

    

    Example 1:

    Input: nums = [5,7,7,8,8,10], target = 8
    Output: [3,4]
    Example 2:

    Input: nums = [5,7,7,8,8,10], target = 6
    Output: [-1,-1]
 */

/**
 * Approach:
 * Intutive
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
class Solution {
    
    public int[] searchRange(int[] nums, int target) {
        
        int[] result = new int [2];
        result[0] = -1;
        result[1] = -1;
        
        binarySearch(nums, result, target, true);
        binarySearch(nums, result, target, false);
        
        return result;
        
    }
    
    private void binarySearch(int[] arr, int[] result, int target, boolean isFirstOccurrence) {
        
        int left = 0;
        int right = arr.length-1;
        
        while(left<=right) {
            int mid = left + (right-left)/2;
            
            if(arr[mid] == target) {
                
                if(isFirstOccurrence) {
                    result[0] = mid;
                    right = mid - 1;
                } else {
                    result[1] = mid;
                    left = mid + 1;
                }
                    
            } else
                if(arr[mid] < target)
                    left = mid + 1;
                else
                    right = mid - 1;
            
        }
    }
}