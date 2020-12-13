/**
 * https://leetcode.com/problems/sudoku-solver/
 * 
 * Problem: 
 * 
 * Write a program to solve a Sudoku puzzle by filling the empty cells.

    A sudoku solution must satisfy all of the following rules:

    Each of the digits 1-9 must occur exactly once in each row.
    Each of the digits 1-9 must occur exactly once in each column.
    Each of the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
    The '.' character indicates empty cells.

    Input: board = [["5","3",".",".","7",".",".",".","."],["6",".",".","1","9","5",".",".","."],[".","9","8",".",".",".",".","6","."],["8",".",".",".","6",".",".",".","3"],["4",".",".","8",".","3",".",".","1"],["7",".",".",".","2",".",".",".","6"],[".","6",".",".",".",".","2","8","."],[".",".",".","4","1","9",".",".","5"],[".",".",".",".","8",".",".","7","9"]]

    Output: [["5","3","4","6","7","8","9","1","2"],["6","7","2","1","9","5","3","4","8"],["1","9","8","3","4","2","5","6","7"],["8","5","9","7","6","1","4","2","3"],["4","2","6","8","5","3","7","9","1"],["7","1","3","9","2","4","8","5","6"],["9","6","1","5","3","7","2","8","4"],["2","8","7","4","1","9","6","3","5"],["3","4","5","2","8","6","1","7","9"]]
 */

/**
 * Approach: Backtracking
 * 
 */
class Solution {
    public void solveSudoku(char[][] board) {
        backtrack(board);   
    }
    
    private boolean backtrack(char[][] board) {
        
        for(int i=0; i<9; i++) {
            for(int j=0; j<9; j++) {
                
                if(board[i][j] != '.')
                    continue;
                
                for(char k = '1'; k <= '9'; k++) {
                    
                    board[i][j] = k;
                    
                    if(isValid(i, j, board) && backtrack(board))
                        return true;
                    
                    board[i][j] = '.';
                }
                
                return false;
            }
        }
        
        return true;
    }
    
    private boolean isValid (int r, int c, char[][] board) {
        
        Set<Character> set = new HashSet<>();
        
        for(int i=0; i<9; i++) {
            
            if(set.contains(board[i][c])) 
                return false;
            
            if(board[i][c] != '.')
                set.add(board[i][c]);
            
        }
        
        set.clear();
        
        for(int j=0; j<9; j++) {
            
            if(set.contains(board[r][j]))
                return false;
            
            if(board[r][j] != '.')
                set.add(board[r][j]);
            
        }
        
        set.clear();

        int x_box = (r/3) * 3;
        int y_box = (c/3) * 3;
        
        for(int i=x_box; i<x_box + 3; i++) {
            
            for(int j=y_box; j<y_box + 3; j++) {
                
                if(set.contains(board[i][j]))
                    return false;
                
                if(board[i][j] != '.')
                    set.add(board[i][j]);
            }
            
        }
        
        return true;
    }
}