/**
 * https://practice.geeksforgeeks.org/problems/number-of-occurrence2259/1#
 *
 * Problem: 
 * 
 * Given a sorted array Arr of size N and a number X, you need to find the number of occurrences of X in Arr.

    Example 1:

    Input:
    N = 7, X = 2
    Arr[] = {1, 1, 2, 2, 2, 2, 3}
    Output: 4
    Explanation: 2 occurs 4 times in the
    given array.
    Example 2:

    Input:
    N = 7, X = 4
    Arr[] = {1, 1, 2, 2, 2, 2, 3}
    Output: 0
    Explanation: 4 is not present in the
    given array.
 */

/**
 * Approach:
 * 
 * Find first and last index of required element and return last-first+1
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */

public class Solution {
    int count(int[] arr, int n, int x) {
        // code here
        int left = 0;
        int right = n-1;
        int start = n;
        int end = -1;
        
        while(left<=right) {
            int mid = left + (right-left)/2;
            
            if(arr[mid] == x) {
                start = Math.min(start, mid);
                right = mid-1;
            } else
                if(arr[mid]>x) {
                    right = mid-1;
                } else
                    if(arr[mid]<x) {
                        left = mid+1;
                    }
        }

        left = 0;
        right = n-1;
        
        while(left<=right) {
            int mid = left + (right-left)/2;
            
            if(arr[mid] == x) {
                end = Math.max(end, mid);
                left = mid+1;
            } else
                if(arr[mid]>x) {
                    right = mid-1;
                } else
                    if(arr[mid]<x) {
                        left = mid+1;
                    }
        }
        
        if(start == n && end == -1)
            return 0;
        else
            return end-start+1;
    }   
}
