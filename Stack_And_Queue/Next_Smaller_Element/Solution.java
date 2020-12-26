/**
 * https://www.geeksforgeeks.org/next-smaller-element/
 * https://www.interviewbit.com/problems/nearest-smaller-element/
 * 
 * In interviewbit problem next smaller element is asked to be returned from left of array
 * 
 * Problem:
 * 
 * Given an array, print the Next Smaller Element (NSE) for every element. The Smaller smaller Element for an 
 * element x is the first smaller element on the right side of x in array. Elements for which no smaller element 
 * exist (on right side), consider next smaller element as -1.

    Examples:
    a) For any array, rightmost element always has next smaller element as -1.
    b) For an array which is sorted in increasing order, all elements have next smaller element as -1.
    c) For the input array [4, 8, 5, 2, 25}, the next smaller elements for each element are as follows.

    Element         NSE
        4      -->   2
        8      -->   5
        5      -->   2
        2      -->   -1
        25     -->   -1
 */

/**
 * Approach:
 * 
 * 1. Stack is used to store index of larger and equal elements
 * 2. Keep checking whether element at current index in array is smaller than element at index stored at top
 *      of stack, if condition is satisfied then update nextSmaller array, accordingly
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class Solution {
    
    public static long[] nextSmallerElement(long[] arr, int n) { 
        
        Stack<Integer> stack = new Stack<>();
        long[] nextSmaller = new long[n];
        int index = 0;
        long defaultValue = -1;
        Arrays.fill(nextSmaller, defaultValue);
        
        for(int i=0; i<n; i++) {
            
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                index = stack.pop();
                nextSmaller[index] = arr[i];
            }
            stack.push(i);
            
        }
        
        
        return nextSmaller;
    }   
}
