/**
 * https://leetcode.com/problems/valid-perfect-square/
 * 
 * Problem:
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.

    Follow up: Do not use any built-in library function such as sqrt.

    

    Example 1:

    Input: num = 16
    Output: true
    Example 2:

    Input: num = 14
    Output: false
 */

/**
 * Approach:
 * 
 * Simple binary search on the criteria of square
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
class Solution {
    public boolean isPerfectSquare(int num) {
        long left = 1;
        long right = num;
        long target = num;
        
        while(left <= right) {
            long mid = left + (right-left)/2;
            
            if(mid*mid == target)
                return true;
            else
                if(mid*mid < target)
                    left = mid + 1;
                else
                    right = mid - 1;
        }
        
        return false;
    }
}