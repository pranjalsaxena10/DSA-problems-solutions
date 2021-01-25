/**
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 * 
 * Problem:
 * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target, find the smallest element in the list that is larger than the given target.

    Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.

    Examples:
    Input:
    letters = ["c", "f", "j"]
    target = "a"
    Output: "c"

    Input:
    letters = ["c", "f", "j"]
    target = "c"
    Output: "f"

    Input:
    letters = ["c", "f", "j"]
    target = "d"
    Output: "f"

    Input:
    letters = ["c", "f", "j"]
    target = "g"
    Output: "j"

    Input:
    letters = ["c", "f", "j"]
    target = "j"
    Output: "c"

    Input:
    letters = ["c", "f", "j"]
    target = "k"
    Output: "c"
 */

/**
 * Approach:
 * 
 * Similar to finding floor problem 
 * In the reduced subarray part of Binary Search Algo => keep updating result with arr[mid]
 * 
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class Solution {

    public char nextGreatestLetter(char[] letters, char target) {
        
        int left = 0;
        int right = letters.length - 1;
        char result = letters[0];
        
        while(left<=right) {
            int mid = left + (right-left) / 2;
            
            if(letters[mid] <= target) {
                left =  mid + 1;
            } else {
                result = letters[mid];
                right = mid - 1;
            }
        }
        
        return result;
    }
}
