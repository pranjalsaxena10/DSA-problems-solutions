/**
 * https://practice.geeksforgeeks.org/problems/minimum-element-in-a-sorted-and-rotated-array3611/1
 * 
 * Problem:
 * 
 * A sorted array A[ ] with distinct elements is rotated at some unknown point, the task is to find the minimum element in it.

    Example

    Input
    N = 5
    arr[] = {4 ,5 ,1 ,2 ,3}
    Output
    1
    Explanation: 1 is the minimum element in
    the array.
 */


/**
 * Approach:
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
                return arr[mid];
            
            if(mid < right && arr[mid+1] < arr[mid])
                return arr[mid+1];
                
            if(arr[mid] >= arr[left])
                left = mid + 1;
            else 
                right = mid - 1;
        }
        
        return arr[0];
    }
}
