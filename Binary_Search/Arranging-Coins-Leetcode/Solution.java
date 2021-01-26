/**
 * https://leetcode.com/problems/arranging-coins/
 * 
 * Problem:
 * You have a total of n coins that you want to form in a staircase shape, where every k-th row must have exactly k coins.

    Given n, find the total number of full staircase rows that can be formed.

    n is a non-negative integer and fits within the range of a 32-bit signed integer.

    Example 1:

    n = 5

    The coins can form the following rows:
    ¤
    ¤ ¤
    ¤ ¤

    Because the 3rd row is incomplete, we return 2.
    Example 2:

    n = 8

    The coins can form the following rows:
    ¤
    ¤ ¤
    ¤ ¤ ¤
    ¤ ¤

    Because the 4th row is incomplete, we return 3.
 */

/**
 * Approach:
 * 
 * pattern is like coins => (row * (row+1)) / 2
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 * 
 */
class Solution {

    public int arrangeCoins(int n) {
        long left = 1;
        long right = n;
        long target = n;
        
        while(left<=right) {
            
            long mid = left + (right-left)/2;
        
            long coins = totalCoins(mid);
            
            if(coins == target)
                return (int) mid;
            else
                if(coins < target)
                    left = mid + 1;
                else
                    right = mid - 1;
            
        }
        
        return (int) (right);
    }
    
    private long totalCoins(long row) {
        return (row * (row + 1))/2;
    }
    
}
