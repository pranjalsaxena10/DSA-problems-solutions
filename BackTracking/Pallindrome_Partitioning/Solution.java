/**
 * https://leetcode.com/problems/palindrome-partitioning/
 * 
 * Problem:
 * Given a string s, partition s such that every substring of the partition is a palindrome. Return all possible palindrome partitioning of s.

    A palindrome string is a string that reads the same backward as forward.

    

    Example 1:

    Input: s = "aab"
    Output: [["a","a","b"],["aa","b"]]
 */

/**
 * Approach:
 * Backtracking
 */
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        
        backtrack(s, 0, result, new ArrayList<String>());
        
        return result;
    }
    void backtrack(String s, int start, List<List<String>> result, List<String> temp) {
        if(start == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        
        for(int i=start; i<s.length(); i++) {
            
            if(isPallindrome(s, start, i)) {
                
                temp.add(s.substring(start, i+1));
                backtrack(s, i+1, result, temp);
                
                temp.remove(temp.size() - 1);
            }
            
        }
        
    }
    
    boolean isPallindrome(String str, int start, int end) {
        while(start < end) {
            if(str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        
        return true;
    }
}