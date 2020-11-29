/**
 * https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * 
 * Problem: Given a string s, find the length of the longest substring without repeating characters.
 * 
 */

/**
 * Approach:
 * 1. Keep maintaining map with current char as key and value as it's index
 * 2. When any duplicate is encountered at end(index) 
 *    then this means there is some duplicate within range as start ... end
 *    We get that index as the value stored in the map for that character
 * 3. Start index as "start" should be start = max(start, map.get(currentCharacter) + 1);
 * 4. Keep updating answer as maximum of range as answer = max(end-start+1, answer)
 * 
 */

class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        
        int start = 0;
        int end = 0;
        
        int answer = 0;
        
        while(end<s.length()) {
            char current = s.charAt(end);
            
            if (!map.containsKey(current)) {
                
                map.put(current, end); 
                
            } else {
                
                start = Math.max(map.get(current) + 1, start);
                map.put(current, end);
                
            }
            
            answer = Math.max(answer, end-start+1);
            end++;
            
        }
        
        return answer;
        
    }    
}