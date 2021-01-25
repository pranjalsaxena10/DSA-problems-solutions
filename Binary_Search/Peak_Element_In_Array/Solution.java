/**
 * https://leetcode.com/problems/find-peak-element/
 * 
 * Problem: 
 * 
 * A peak element is an element that is strictly greater than its neighbors.

    Given an integer array nums, find a peak element, and return its index. 
    If the array contains multiple peaks, return the index to any of the peaks.

    You may imagine that nums[-1] = nums[n] = -∞.

    Example 1:

    Input: nums = [1,2,3,1]
    Output: 2
    Explanation: 3 is a peak element and your function should return the index number 2.
    Example 2:

    Input: nums = [1,2,1,3,5,6,4]
    Output: 5
    Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 
    where the peak element is 6.
 */

/**
 * Approach:
 * 
 * first element and last element are compared with second and second last element respectively
 * Each iteration of binary search we will compare arr[mid] with arr[mid-1] and arr[mid+1], 
 * if arr[mid] > arr[mid-1] && arr[mid] > arr[mid+1] => return arr[mid]
 * else
 *      go in greater element direction
 *      if arr[mid] > arr[mid-1] then we can neglect left part and go search in right part
 *      else go in left part
 */

class Solution {
    public int findPeakElement(int[] nums) {
        
        if(nums.length == 1)
            return 0;
        
        if(nums[0] > nums[1])
            return 0;
        
        if(nums[nums.length-1] > nums[nums.length-2])
            return nums.length-1;
        
        int left = 1;
        int right = nums.length - 2;
        int result = -1;
        
        while(left<=right) {
            int mid = left + (right-left)/2;
            
            if(nums[mid] > nums[mid+1] && nums[mid] > nums[mid-1])
                return mid;
            
            if(nums[mid-1] < nums[mid] && nums[mid] < nums[mid+1])
                left = mid + 1;
            else
                right = mid - 1;
            
        }
        
        return result;
    }
}