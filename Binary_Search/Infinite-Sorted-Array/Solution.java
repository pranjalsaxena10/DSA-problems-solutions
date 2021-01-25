/**
 * https://www.geeksforgeeks.org/find-position-element-sorted-array-infinite-numbers/
 * 
 * 
 * Suppose you have a sorted array of infinite numbers, how would you search an element in the array?

    Source: Amazon Interview Experience.
    Since array is sorted, the first thing clicks into mind is binary search, but the problem here is that we don’t know
    size of array.
    If the array is infinite, that means we don’t have proper bounds to apply binary search. So in order to find position
    of key, first we find bounds and then apply binary search algorithm.

    Let low be pointing to 1st element and high pointing to 2nd element of array, Now compare key with high index element,

    ->if it is greater than high index element then copy high index in low index and double the high index.
    ->if it is smaller, then apply binary search on high and low indices found.

    Time Complexity: Let p be the index for high/right => O(log p)
    Space Complexity: O(1)
 */


public class Solution {

    public int findIndex(int[] arr, int target) {
    
        int left = 0;
        int right = 1;
        int result = -1;

        while(arr[right] < target) {
            left = right;
            right *= 2;
        }

        while(left <= right) {
            int mid = left + (right-left) / 2;

            if(arr[mid] == target)
                return mid;
            else
                if(arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
        }

        return result;
    }
}
