/**
 * https://leetcode.com/problems/sum-of-subarray-minimums/
 * 
 * Problem:
 * 
 * Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.

    Since the answer may be large, return the answer modulo 10^9 + 7.

    Example 1:

    Input: [3,1,2,4]
    Output: 17
    Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4]. 
    Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.

 */

/**
 * Approach:
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 * 
 * Proof of multiplication give us the number of sub arrays:
    we have an array: A = [2, 9, 7, 8, 3, 4, 6, 1], and we want to find how many subarrays of A has minimum number 
    is 3.

    Let's assume distance between 3 to 2 (minimum number to first number greater 3 to the left (3 -> 9)) is m.
    and distance between 3 to 1 (minimum number to first number greater 3 to the right (3 -> 6)) is n.
    So the array A has total length m + n - 1 (3 appears twice)

    The number of subarray we have for the array A with length m + n - 1 
    is 1 + 2 + 3 + 4 + ... + m + n - 1 = Summation(1 + (m + n - 1)), 
    which is equal difference series 
    sum S3 = n (a1 + an) / 2 = (m + n - 1) (m + n - 1 + 1) / 2 = (m + n - 1) (m + n) / 2

    Since 3 is the minimum number and we need to subtract number of subarrays which exclusive 3, which are 
    subarrays [9,7,8] with length 3 or m - 1 and [4,6] with length 2 or n - 1, 
    number of subarrays for [9,7,8] is S1 = (m - 1 + 1)(m - 1) / 2 = m(m - 1) / 2 and 
    for [4,6] is S2 = n(n - 1) / 2

    Finally, we have

    S3 - S2 - S1 = (m + n - 1)(m + n)/2 - m(m - 1)/2 - n(n - 1)/2 
                        = (n^2 + mn - n + mn + m^2 - m - n^2 + n - m^2 + m) / 2
                        = 2mn / 2
                        = mn 
 */

class Solution {
    
    public int sumSubarrayMins(int[] arr) {
    
        Stack<Integer> stack = new Stack<>();
        int[] pre = new int[arr.length];
        int[] next = new int[arr.length];
        
        Arrays.fill(pre, -1);
        Arrays.fill(next, arr.length);
        int mod = 1000000007;
        
        for(int i=0; i<arr.length; i++) {
            while(!stack.isEmpty() && arr[i] < arr[stack.peek()]) {
                next[stack.pop()] = i;
            }

            stack.push(i);
        }
        
        stack.clear();
        
        for(int i=arr.length-1; i>=0; i--) {
            while(!stack.isEmpty() && arr[i] <= arr[stack.peek()]) {
                pre[stack.pop()] = i;
            }

            stack.push(i);
        }
        
        long sum = 0;
        
        for(int i=0; i<arr.length; i++) {
            int right = i - pre[i];
            int left = next[i] - i;
             
            long product = left*right;
            product = (product * arr[i]) % mod;
            
            sum = (sum + product) % mod;
        }
        
        return (int) sum;   
    }
    
}