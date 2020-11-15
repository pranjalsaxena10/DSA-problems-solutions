/**
 * https://leetcode.com/problems/set-matrix-zeroes/
 * Problem:
 * Given an m x n matrix. If an element is 0, set its entire row and column to 0. Do it in-place.
 */

/**
 * Approach:
 * 
 * 1. Linearly traverse the matrix and update 1st row with corresponding column index 
 *      and 1st column with corresponding row index if 0 is encountered.
 * 
 * 2. Here the catch is, since we have to do this updation in place thus we are bound to take 1st row and 
 *      column to be treated as dummy.
 * 
 * 3. Since both these dummy arrays would overlap at index (0,0). Thus another boolean variable colFlag 
 *      is taken to consider conflicting scenarios 
 *      
 */

class Solution {
    public void setZeroes(int[][] matrix) {
        
        int rows = matrix.length;
        int cols = matrix[0].length;
        boolean colFlag = true;
        
        for(int i=0; i<rows; i++) {
            if(matrix[i][0] == 0)
                colFlag = false;
            
            for(int j=1; j<cols; j++) {
                
                if(matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
                    
            }
        }
        
        for(int i=rows-1; i>=0; i--) {
            for(int j=cols-1; j>=1; j--) {
                
                if(matrix[i][j] != 0 && (matrix[i][0] == 0 || matrix[0][j] == 0)) {
                    matrix[i][j] = 0;
                }
            }
            
            if(!colFlag)
                matrix[i][0] = 0;
        }
    }
}