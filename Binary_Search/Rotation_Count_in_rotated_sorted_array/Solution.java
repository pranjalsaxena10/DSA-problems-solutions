/**
 * https://practice.geeksforgeeks.org/problems/rotation4723/1#
 * 
 * Problem: 
 * 
 * Given an ascending sorted rotated array Arr of distinct integers of size N. The array is right rotated K times. Find the value of K.

    Example 1:

    Input:
    N = 5
    Arr[] = {5, 1, 2, 3, 4}
    Output: 1
    Explanation: The given array is 5 1 2 3 4. 
    The original sorted array is 1 2 3 4 5. 
    We can see that the array was rotated 
    1 times to the right.
 */

/**
 * Approach:
 * 
 * Here minElement's index in array is required to be found.
 * 
 * 1. Min Element in rotated sorted array is always the one which is lesser than it's previous 
 * 2. If it is not found then search for in unsorted array because in that subarray only, answer could be present
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class Solution {
    int findMin(int arr[], int n)
    {
        //complete the function here
        int left = 0;
        int right = n-1;
        
        while(left<=right) {
            int mid = left + (right-left)/2;
            
            if(mid > left && arr[mid] < arr[mid-1])
                return mid;
            
            if(mid < right && arr[mid+1] < arr[mid])
                return mid+1;
                
            if(arr[mid] >= arr[left])
                left = mid + 1;
            else 
                right = mid - 1;
        }
        
        return 0;
    }
}
