/**
 * https://www.geeksforgeeks.org/search-almost-sorted-array/
 * 
 * Problem: 
 * 
 * Given an array which is sorted, but after sorting some elements are moved to either of the adjacent positions,
 *  i.e., arr[i] may be present at arr[i+1] or arr[i-1]. Write an efficient function to search an element in this array.
 *  Basically the element arr[i] can only be swapped with either arr[i+1] or arr[i-1].

    For example consider the array {2, 3, 10, 4, 40}, 4 is moved to next position and 10 is moved to previous position.

    Example :

    Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 40
    Output: 2 
    Output is index of 40 in given array

    Input: arr[] =  {10, 3, 40, 20, 50, 80, 70}, key = 90
    Output: -1
    -1 is returned to indicate element is not present
 */

/**
 * Approach:
 * Since element are only interchanged with mid - 1 or mid + 1
 * Then we can check for all three options where target could be found. 
 * If found return true
 * else check appropriate subarray by doing
 *  if(arr[mid] > target)
 *      right = mid - 2;
 *  else
 *      left = mid + 2;
 * 
 * reason behind increasing by 2 is mid - 1 and mid + 1 are already checked and if that could give result, it would have
 * already returned true
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

public class Solution {
    public boolean search(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while(left<=right) {
            int mid = left + (right-left) / 2;

            if(arr[mid] == target) 
                return true;

            if(mid > left && arr[mid - 1] == target)
                return true;

            if(mid < right && arr[mid + 1] == target)
                return true;

            if(arr[mid] > target)
                right = mid - 2;
            else    
                left = mid + 2;

        }

        return false;
    }   
}
