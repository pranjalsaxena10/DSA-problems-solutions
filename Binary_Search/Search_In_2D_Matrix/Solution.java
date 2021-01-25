/**
 * https://leetcode.com/problems/search-a-2d-matrix/
 * 
 * Problem: Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted from left to right.
    The first integer of each row is greater than the last integer of the previous row.

 */

/**
 * Approach: Since matrix is sorted. 
 * Given condition is: The first integer of each row is greater than the last integer of the previous row.
 * Suppose cols = column size
    matrix[i][0] > matrix[i-1][cols-1]

 * 1. First find out most probable row in which target can probably be found by implementing 
 *      Binary Seach over the 1st column
 * 2. Search in this row whether target element is present or not. If found return true else return false
 *  
 * Time Complexity: O(log n + log m)
 * Space Complexity: O(1)
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int start = 0;
        int end = matrix.length - 1;
        
        while(start <= end) {
            int mid = start + (end - start) / 2;
            
            if(matrix[mid][0] == target)
                return true;
            else
                if(matrix[mid][0] < target)
                    start = mid + 1;
                else
                    end = mid - 1;
        }
        
        int row = end;
        
        if(row == -1)
            return false;
        
        int left = 0;
        int right = matrix[0].length - 1;
        
        while(left <= right) {
            int mid = left + (right-left)/2;
            
            if(matrix[row][mid] == target)
                return true;
            else
                if(matrix[row][mid] < target)
                    left = mid + 1;
                else
                    right = mid - 1;
        }
        
        return false;
    }
}