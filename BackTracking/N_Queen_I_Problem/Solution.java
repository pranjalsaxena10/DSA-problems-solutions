/**
 * https://leetcode.com/problems/n-queens/
 * 
 * Problem:
 * 
 * The n-queens puzzle is the problem of placing n queens on an n x n chessboard such that no two queens attack each other.

    Given an integer n, return all distinct solutions to the n-queens puzzle.

    Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both 
    indicate a queen and an empty space, respectively.

    Input: n = 4
    Output: [[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
    Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above
    
 */

/**
 * Approach
 * 1. Backtracking approach is implemented 
 * 2. No Matrix is present here, because that code looks like messy
 * 3. Instead List<Integer> colPositions is used which will store col values for probable Queen's positions
 * 4. First row is passed to backTrack function as 0
 * 5. Code will try each possible column position for each row queen, which are not in conflict with 
 *      previously placed queens.
 * 6. Each possible solution needed to be returned as output
 * 
 * 
 * Time Complexity: order of O(N!), since exhaustively all combinations are getting considered
 * Space Complexity: O(N)
 */
class Solution {
    
    private List<List<String>> result;
    
    public List<List<String>> solveNQueens(int n) {
        
        result = new ArrayList<>();
        
        result = backTrack(0, n, new ArrayList<>());
        
        return result;
    }
    
    private List<List<String>> backTrack(int row, int n, List<Integer> colPositions) {
        
        if (row == n) {
           
            List<String> list = new ArrayList<>();
            
            char[] defaultOutput = new char[n];
            Arrays.fill(defaultOutput, '.');
            
            for(int i=0; i<colPositions.size(); i++) {
                
                defaultOutput[colPositions.get(i)] = 'Q';
                list.add(String.valueOf(defaultOutput));
                Arrays.fill(defaultOutput, '.');
                
            }
            
            result.add(list);
            
            return result;
        }
        
        for(int col = 0; col<n; col++) {
            
            colPositions.add(col);
            
            if(isSafe(colPositions)) {
                
                backTrack(row + 1, n, colPositions);
            }
            
            colPositions.remove(colPositions.size() - 1);
        }
        
        return result;
        
    }
    
    private boolean isSafe(List<Integer> colPositions) {
        
        int lastRow = colPositions.size() - 1;
        
        for (int i=0; i<colPositions.size() - 1; i++) {
            
            int diff = Math.abs(colPositions.get(i) - colPositions.get(lastRow));
            
            // This if condition checks for whether same col is there for added queen
            // Also if they are in diagonal positions then return false
            // lastRow - i depicts row diff 
            
            if (diff == 0 || diff == lastRow - i)
                return false;
        }
        
        return true;
    }
}