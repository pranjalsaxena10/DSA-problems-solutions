/**
 * https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/
 * 
 * Problem:
 * 
 * Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, 
 * return the number of negative numbers in grid.

    Example 1:

    Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
    Output: 8
    Explanation: There are 8 negatives number in the matrix.
    Example 2:

    Input: grid = [[3,2],[1,0]]
    Output: 0
    Example 3:

    Input: grid = [[1,-1],[-1,-1]]
    Output: 3
    Example 4:

    Input: grid = [[-1]]
    Output: 1
 */

/**
 * Approach:
 * 
 * Since matrix is sorted in non increasing order both row wise and column wise:
 * We start from top-right corner and check if it's negative, 
 * if it's negative => all elements in that column will be negative 
 *                  => increase counter with (n-i) 
 *                  => decrement column
 * 
 * if it's not negative => go in downward direction
 * 
 */

 class Solution {

    public int countNegatives(int[][] grid) {
        int i = 0;
        int j = grid[0].length-1;
        int n = grid.length;
        int m = grid[0].length;
        int negatives = 0;
        int target = -1;
        
        while(isValid(i, j, n, m)) {
            
            if(grid[i][j] <= target) {
                negatives += (n-i);
                j--;
                    
            } else {
                
                i++;
                
            }
            
        }
        
        return negatives;
    }
    
    private boolean isValid(int r, int c, int n, int m) {

        return r>=0 && r<n && c>=0 && c<m;

    }
}