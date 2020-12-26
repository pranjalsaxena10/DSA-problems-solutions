/**
 * https://leetcode.com/problems/largest-rectangle-in-histogram/
 * 
 * Problem:
 * 
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

    Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

    The largest rectangle is shown in the shaded area, which has area = 10 unit.

    Example:

    Input: [2,1,5,6,2,3]
    Output: 10
 */

/**
 * Approach:
 * 
 * 1. Idea is to find out pre and next indices of next smaller element for every array element
 * 2. Once we get both of these arrays, we calculate width of each rectangle as:
 *   left = pre[i] + 1, right = next[i] - 1 & width = right - left + 1
 *      height will be heights[i].
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {
    
    public int largestRectangleArea(int[] heights) {
        
        Stack<Integer> stack = new Stack<>();
        int[] pre = new int[heights.length];
        int[] next = new int[heights.length];
        
        Arrays.fill(pre, -1);
        Arrays.fill(next, heights.length);
        
        for(int i=0; i<heights.length; i++) {
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                next[stack.pop()] = i;
            }

            stack.push(i);
        }
        
        stack.clear();
        
        for(int i=heights.length-1; i>=0; i--) {
            while(!stack.isEmpty() && heights[i] < heights[stack.peek()]) {
                pre[stack.pop()] = i;
            }

            stack.push(i);
        }
        
        int area = 0;
        
        for(int i=0; i<heights.length; i++) {
            int left = pre[i] + 1;
            int right = next[i] - 1;
            area = Math.max(area, (right - left + 1) * heights[i]);
        }
        
        return area;
    }
}