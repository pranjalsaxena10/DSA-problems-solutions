/**
 * https://leetcode.com/problems/median-of-two-sorted-arrays/
 * 
 * Problem:
 * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

    Follow up: The overall run time complexity should be O(log (m+n)).

    Example 1:

    Input: nums1 = [1,3], nums2 = [2]
    Output: 2.00000
    Explanation: merged array = [1,2,3] and median is 2.
    Example 2:

    Input: nums1 = [1,2], nums2 = [3,4]
    Output: 2.50000
    Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.
 */

/**
 * Approach:
 * 
 * Since median is the element which has n/2 elements on left and right
 * We have to find out partition1 and partition2 such that
 * no of elements on left of 1st + no of elements on left of 2nd = (1st array length + 2nd array length) / 2
 * and 
 * int max1 = partition1 == 0 ? Integer.MIN_VALUE : arr1[partition1-1];
    int max2 = partition2 == 0 ? Integer.MIN_VALUE : arr2[partition2-1];
    int min1 = partition1 == m ? Integer.MAX_VALUE : arr1[partition1];
    int min2 = partition2 == n ? Integer.MAX_VALUE : arr2[partition2];


    if(max1 <= min2 && max2 <= min1) // this means partition is found correctly

    Time Complexity: O(log(min(m,n)))
    Space Complexity: O(1)
 */

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        
        
        if(m<=n) {
            return findMedian(nums1, nums2);
        } else {
            return findMedian(nums2, nums1);
        }
        
    }
    
    public double findMedian(int[] arr1, int[] arr2) {
        int left = 0;
        int right = arr1.length;
        
        int m = arr1.length;
        int n = arr2.length;
        double ans = 0;
        
        while(left <= right) {
            
            int partition1 = left+right>>1;
            int partition2 = (m+n+1>>1) - partition1;
            
            int max1 = partition1 == 0 ? Integer.MIN_VALUE : arr1[partition1-1];
            int max2 = partition2 == 0 ? Integer.MIN_VALUE : arr2[partition2-1];
            int min1 = partition1 == m ? Integer.MAX_VALUE : arr1[partition1];
            int min2 = partition2 == n ? Integer.MAX_VALUE : arr2[partition2];
            
            
            if(max1 <= min2 && max2 <= min1) {
                
                if((m+n) % 2 == 0) {
                    int first = Math.max(max1, max2);
                    int second = Math.min(min1, min2);
                    ans = ((double) (first+second)) / 2;
                    break;

                } else {
                    ans = (double) Math.max(max1, max2);
                    break;
                }
                
            } else 
                if(max1 > min2)
                    right = partition1 - 1;
                else
                    left = partition1 + 1;
            
        }
        
        return ans;
    }
}