/**
 * https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1
 * 
 * Problem: 
 * Given an array A[] of size N having distinct elements, the task is to find the next greater element for 
 * each element of the array in order of their appearance in the array.

    Next greater element of an element in the array is the nearest element on the right which is greater than the 
    current element.

    If there does not exist next greater of current element, then next greater element for current element is -1. 
    For example, next greater of the last element is always -1.

    Example 1:

    Input: 
    N = 4, arr[] = [1 3 2 4]
    Output:
    3 4 4 -1
    Explanation:
    In the array, the next larger element 
    to 1 is 3 , 3 is 4 , 2 is 4 and for 4 ? 
    since it doesn't exist, it is -1.
 */

/**
 * Approach:
 * 
 * 1. Stack is used to store index of smaller and equal elements
 * 2. Keep checking whether element at current index in array is greater than element at index stored at top
 *      of stack, if condition is satisfied then update nexGreater array, accordingly
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class Solution {
    
    public static long[] nextLargerElement(long[] arr, int n) { 
        
        Stack<Integer> stack = new Stack<>();
        long[] nextGreater = new long[n];
        int index = 0;
        long defaultValue = -1;
        Arrays.fill(nextGreater, defaultValue);
        
        for(int i=0; i<n; i++) {
            
            while(!stack.isEmpty() && arr[i] > arr[stack.peek()]) {
                index = stack.pop();
                nextGreater[index] = arr[i];
            }
            stack.push(i);
            
        }
        
        
        return nextGreater;
    }   
}
