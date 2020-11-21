/**
 * https://leetcode.com/problems/unique-paths/
 * 
 * Problem: A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

    The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

    How many possible unique paths are there?
 */

/**
 * Approach1: Explained with example
 * 
 * Suppose test case is given as m=3, n=7 => which means 3 rows and 7 columns
 * Possible ways is we can only move in right or in downward direction
 * We have to reach to bottom right corner by using above mentioned moves
 * At each cell we can definitely say that we will be reaching to it only from either top or left, because of the 
 * restriction in moves to be taken
 * Ways of reaching (0,0) will be 0 since it is starting point
 * 
 * Suppose rows and cols depicts size of matrix respectively and "ways" is a function depicting unique ways
 * So, for 0 < j < cols, ways(0, j) will be 1, since we can only reach these cells from their respective left cell
 * for 0 < i < rows, ways(i, 0) will also be 1, since we can only reach these cells from their respective upward/top cell
 * 
 * Another interesting fact is, we can reach to this conclusion that at any cell (i, j);
 * ways(i, j) = ways(i-1, j) + ways(i, j-1)
 * This sort of formula is based on the restriction imposed
 * This is typical Overlapping subproblem and Dynamic Programming solution can be implemented 
 * 
 * Below is matrix representation for test case as m=3 and n=7
 *  0	1	1	1	1	1	1
    1	2	3	4	5	6	7
    1	3	6	10	15	21	28


    Time Complexity = O(n^2)
    Space Complexity = O(n^2)
 */

/**
 * Approach2: Combinatorics Solution
 * 
 * Suppose test case is m=3 and n=2
 * 
 * Permissible moves either go down or go right
 * 
 * Suppose D=> Downward and R=> Right
 * We can choose following ways:
 * 
 * 1. RRD
 * 2. RDR
 * 3. DRR
 * 
 * So it can be seen that, it is combinatorics problem where have to choose R or D and then permute in all possible ways
 * 
 * Now generalizing => 
 * m => rows n=> cols
 * 
 * 1. No of R's can be n-1
 * 2. No. of D's can be m-1
 * Now have in total (m - 1) + (n - 1) choices which turn out to be m+n-2
 * 
 * Out of these plausible choices we have to either choose R or D.
 * Final Solution would be ans = (m+n-2)                    (m+n-2)
 *                                      C            or             C
 *                                       (m-1)                        (n-1)
 * 
 * Putting value for Appraoach 1 test case in this solution:
 * m=3 and n=7
 * m+n-2 = 3+7-2 = 8
 * Answer would be either 8C2 or 8C6 which turns out to be (8*7)/(2*1) => 56/2 => 28
 * 
 * Time Complexity would be O(n) or O(m) means linear
 * Space Complexity would be O(1)  
 */                 

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int [m][n];
        
        return gridPaths(dp, m-1, n-1);
    }
    
    private int gridPaths(int[][] dp, int i, int j) {
        if(i==0 || j == 0)
            return 1;
        
        if(dp[i][j] != 0)
            return dp[i][j];
        
        dp[i][j] = gridPaths(dp, i-1, j) + gridPaths(dp, i, j-1);
        
        return dp[i][j];
    }
}