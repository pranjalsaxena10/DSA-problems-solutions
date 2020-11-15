/**
 * https://leetcode.com/problems/rotate-image/
 * 
 * Problem:
 * You are given an n x n 2D matrix representing an image, rotate the image by 90 degrees (clockwise).
 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. 
 * DO NOT allocate another 2D matrix and do the rotation.
 */

/**
 * Input: matrix = [[1,2,3],[4,5,6],[7,8,9]]
    Output: [[7,4,1],[8,5,2],[9,6,3]]
 */

 /**
  * Approach: Take transpose of matrix and then reverse each row. Simple
  */
class Solution {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        
        for(int[] row: matrix) {
            reverse(row);    
        }
    }
    
    private void transpose(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        
        for(int i=0; i<rows; i++) {
            for(int j=0; j<i; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[j][i];
                arr[j][i] = temp;
            }
        }
    }
    
    private void reverse(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while(left<right) {
            swap(arr, left, right);
            left++;
            right--;
        }
    }
    
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    
}