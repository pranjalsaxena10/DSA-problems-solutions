/**
 * https://leetcode.com/problems/valid-parentheses/
 * 
 * Problem:
 * 
 * Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

    An input string is valid if:

    Open brackets must be closed by the same type of brackets.
    Open brackets must be closed in the correct order.
    

    Example 1:

    Input: s = "()"
    Output: true
    Example 2:

    Input: s = "()[]{}"
    Output: true
 */

/**
 * Approach:
 * 
 * 1. For each character in string check if it is opening bracket "( { [" and if it is push it in stack
 * 2. If character is closing bracket then pop from stack and check top element is having expected opening bracket
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for(int i=0; i<s.length(); i++) {
            char ch = s.charAt(i);
            
            if(isOpeningBracket(ch))
                stack.push(ch);
            
            if(isClosingBracket(ch)) {
                if(stack.isEmpty())
                    return false;
                
                char top = stack.pop();
                
                if(!isValid(ch, top)) 
                    return false;
            }
            
                
        }
        
        return stack.isEmpty();
        
    }
    
    boolean isOpeningBracket(char ch) {
        return ch == '(' || ch == '[' || ch == '{';
    }
    
    boolean isClosingBracket(char ch) {
        return ch == ')' || ch == ']' || ch == '}';
    }
    
    boolean isValid(char ch, char top) {
        if((ch == ')' && top != '(') || (ch == ']' && top != '[') || (ch == '}' && top != '{'))
            return false;
        
        return true;
            
    }
}