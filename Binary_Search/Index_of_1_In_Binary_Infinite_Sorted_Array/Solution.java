/**
 * https://www.geeksforgeeks.org/find-index-first-1-infinite-sorted-array-0s-1s/
 * 
 * 
 * Suppose you have a sorted array of binary infinite size, how would you search an element in the array?

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

    public static int findFirstOccurrence(int[] arr) {
    
        int left = 0;
        int right = 1;
        int result = -1;

        while(arr[right] < 1) {
            left = right;
            right *= 2;
        }

        while(left <= right) {

            int mid = left + (right-left) / 2;
            
            if(arr[mid] == 1) {
                result = mid;
                right = mid - 1;
            } else
                if(arr[mid] < 1)
                    left = mid + 1;
                else    
                    right = mid - 1;
            
        }

        return result;
    }
}
