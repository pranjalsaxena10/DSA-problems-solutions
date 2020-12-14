/**
 * https://practice.geeksforgeeks.org/problems/rat-in-a-maze-problem/1#
 * 
 * Problem:
 * 
 * Consider a rat placed at (0, 0) in a square matrix of order N*N. It has to reach the destination at (N-1, N-1). Find all possible paths that the rat can take to reach from source to destination. The directions in which the rat can move are 'U'(up), 'D'(down), 'L' (left), 'R' (right). Value 0 at a cell in the matrix represents that it is blocked and cannot be crossed while value 1 at a cell in the matrix represents that it can be traveled through.

    Example 1:

    Input: N = 4, m[][] = {{1, 0, 0, 0},
                        {1, 1, 0, 1}, 
                        {1, 1, 0, 0},
                        {0, 1, 1, 1}}
    Output: DDRDRR DRDDRR
    Explanation: The rat can reach the 
    destination at (3, 3) from (0, 0) by two 
    paths ie DRDDRR and DDRDRR when printed 
    in sorted order we get DDRDRR DRDDRR.
 */


/**
 * Approach:
 * 1. For each cell check we can go Up, Down, Left, Right.
 * 2. Exhaustively check for all directions by backtracking
 * 
 * Time Complexity: O((3^N)^2)
 * Space Complexity: O(N^2)
 */

public class Solution {

    private static PriorityQueue<String> pq;
    
    public static ArrayList<String> printPath(int[][] m, int n) {
        pq = new PriorityQueue<>();
        
        boolean[][] visited = new boolean[n][n];
        
        ArrayList<String> result = new ArrayList<>();
        
        if(m[0][0] == 0)
            return result;
        
        pq = backtrack(0, 0, m, m.length, m[0].length, "", visited);
        
        while(!pq.isEmpty()) {
            result.add(pq.poll());
        }
        
        return result;
    }
    
    private static PriorityQueue<String> backtrack(int r, int c, int[][] m, int rows, int cols, String sb, boolean[][] visited) {
        
        if (r == rows-1 && c == cols-1) {
        
           pq.add(sb);
           
           return pq;
        }
        
        int[] x = {-1, 1, 0, 0};
        int[] y= {0, 0, 1, -1};
        
        visited[r][c] = true;
        
        for(int i=0; i<4; i++) {
            int newX = x[i] + r;
            int newY = y[i] + c;
            
            switch(i) {
                case 0: sb += "U"; 
                        break;
                        
                case 1: sb += "D";
                        break;
                
                case 2: sb += "R";
                        break;
                
                case 3: sb += "L";
                        break;
                        
            }

            if(isValid(newX, newY, m, visited)) {
                backtrack(newX, newY, m, rows, cols, sb, visited);
            }
            
            sb = sb.substring(0, sb.length()-1);
            
        }
        
        visited[r][c] = false;
        
        return pq;
    }
    
    
    private static boolean isValid(int i, int j, int[][] m, boolean[][] visited) {
        int r = m.length;
        int c = m[0].length;
        
        return (i>=0) && (i<r) && (j>=0) && (j<c) && m[i][j] == 1 && !visited[i][j];
    }
    
}
