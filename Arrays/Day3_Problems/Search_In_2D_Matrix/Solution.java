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
 */

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0)
            return false;
        
        if(matrix[0].length == 0)
            return false;
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        
        if(target < matrix[0][0] || target > matrix[rows-1][cols-1])
            return false;
        
        int firstRow = 0;
        int lastRow = rows-1;
        
        while(firstRow < lastRow) {
            int midRow = firstRow + lastRow + 1>>1;
            
            if(matrix[midRow][0] <= target) {
                firstRow = midRow;
            } else {
                lastRow = midRow - 1;
            }
        }
        
        int left = 0;
        int right = cols - 1;
        
        while(left<=right) {
            int mid = left+right+1>>1;
            
            if(matrix[firstRow][mid] == target)
                return true;
            
            if(matrix[firstRow][mid] <= target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return false;
        
    }
}