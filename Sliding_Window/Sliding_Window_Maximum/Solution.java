/**
 * https://leetcode.com/problems/sliding-window-maximum/
 * 
 * Problem:
 * 
 * You are given an array of integers nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.

    Return the max sliding window.

    

    Example 1:

    Input: nums = [1,3,-1,-3,5,3,6,7], k = 3
    Output: [3,3,5,5,6,7]
    Explanation: 
    Window position                Max
    ---------------               -----
    [1  3  -1] -3  5  3  6  7      3
    1 [3  -1  -3] 5  3  6  7       3
    1  3 [-1  -3  5] 3  6  7       5
    1  3  -1 [-3  5  3] 6  7       5
    1  3  -1  -3 [5  3  6] 7       6
    1  3  -1  -3  5 [3  6  7]      7
 * 
 */

/**
 * Approach:
 * 
 * 1. Different Approach than sliding window
 * 2. Calculate index for every element for next Greater element
 * 3. For every element in array, keep moving to nextGreaterElementIndex if that number is still in range of
 *      window size
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {
    
    public int[] maxSlidingWindow(int[] nums, int k) {
        
        if(k == 1)
            return nums;
        
        int[] nextGreaterElementIndex = new int[nums.length];
        Stack<Integer> stack = new Stack<>();
        
        Arrays.fill(nextGreaterElementIndex, nums.length);
        
        for(int i=0; i<nums.length; i++) {
            
            while(!stack.isEmpty() && nums[i] > nums[stack.peek()])
                nextGreaterElementIndex[stack.pop()] = i;
            
            stack.push(i);
        }
        
        int[] result = new int[nums.length - k + 1];
        int it = 0;
        
        for(int i=0; i<=nums.length-k; i++) {
            
            int j=i;
            
            while(nextGreaterElementIndex[j] - i < k)
                j = nextGreaterElementIndex[j];
            
            result[i] = nums[j];
        }
        
        return result;   
    }
}
