/**
 * https://practice.geeksforgeeks.org/problems/search-in-a-matrix17201720/1#
 * 
 * Problem:
 * Given a matrix mat[][] of size N x M, where every row and column is sorted in increasing order, and a number X is given. The task is to find whether element X is present in the matrix or not.


    Example 1:

    Input:
    N = 3, M = 3
    mat[][] = 3 30 38 
            44 52 54 
            57 60 69
    X = 62
    Output:
    0
    Explanation:
    62 is not present in the
    matrix, so output is 0

    Example 2:

    Input:
    N = 1, M = 6
    mat[][] = 18 21 27 38 55 67
    X = 55
    Output:
    1
    Explanation:
    55 is present in the
    matrix at 5th cell.
 * 
 */

/**
 * Approach:
 * 
 * Start from top right position in matrix
 * If mat[i][j] < target go in downward direction
 * If mat[i][j] > target go in left direction
 * 
 * Time Complexity: O(n+m)
 * Space Complexity: O(1)
 */

public class Solution {
    public static int matSearch(int mat[][], int N, int M, int X)
    {
        // your code here
        
        int i = 0;
        int j = M - 1;
        
        while(isValid(i, j, N, M)) {
            if(mat[i][j] == X)
                return 1;
            else
                if(mat[i][j] < X)
                    i++;
                else
                    j--;
        }
        
        return 0;
    }
    
    private static boolean isValid(int r, int c, int n, int m) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}
