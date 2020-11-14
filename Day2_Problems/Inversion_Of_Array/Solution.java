/**
 * Problem: Inversion of Array
 * Here we have to find no of pairs (i, j) for which arr[i] > arr[j] and i<j
 * 
 * https://www.geeksforgeeks.org/counting-inversions/
 */

/**
 * Approach:
 * 1. While doing merge in Merge Sort we can check whether element in left subarray is greater than 
 *      right subarray element
 * 2. And if so then, all elements present in right side of that element in left subarray will always be greater than 
 *      right subarray element
 * 3. Thus we can simply take the count of difference of last index of left subarray and current index in left subarray
 * 
 * Time Complexity = O(nlogn)
 * Space Complexity = O(n)
 */


class Solution {
    static long inversionCount(long arr[], long N)
    {
        // Your Code Here
        long[] temp = new long[arr.length];
        
        
        return mergeSortLogic(temp, arr, 0, arr.length-1);
    }
    
    private static long mergeSortLogic(long[] temp, long[] arr, int low, int high) {
        int mid = (low + high) / 2;
        long inversionCount = 0;
        
        if(low<high) {
            inversionCount += mergeSortLogic(temp, arr, low, mid);
            inversionCount += mergeSortLogic(temp, arr, mid + 1, high);
            inversionCount += merge(temp, arr, low, mid + 1, high);    
        }
        
        
        return inversionCount;
    }
    
    private static long merge(long[] temp, long[] arr, int left, int mid, int right) {
        /**
         * i => index for left subarray
         * j => index for right subarray
         * k => index for temp subarray
         */
         long inversionCount = 0;
         int i = left;
         int j = mid;
         int k = left;
         
         while(i<=mid-1 && j<=right) {
             if(arr[i] <= arr[j]) {
                 
                 temp[k++] = arr[i++];
                 
             } else {
                 
                 temp[k++] = arr[j++];
                 inversionCount += (long)(mid-i);
                 
             }
         }
         
         while(i<=mid-1) {
             temp[k++] = arr[i++];
         }
         
         while(j<=right) {
             temp[k++] = arr[j++];
         }
         for(int p=left; p<=right; p++) {
             arr[p] = temp[p];
         }
         
         return inversionCount;
    }
}
