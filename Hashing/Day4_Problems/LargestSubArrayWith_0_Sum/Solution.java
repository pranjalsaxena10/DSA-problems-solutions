/**
 * https://practice.geeksforgeeks.org/problems/largest-subarray-with-0-sum/1
 * Problem: 
 * 
 * Given an array having both positive and negative integers. The task is to compute the length of the largest subarray with sum 0.

    Example 1:

    Input:
    N = 8
    A[] = {15,-2,2,-8,1,7,10,23}
    Output: 5
    Explanation: The largest subarray with
    sum 0 will be -2 2 -8 1 7.
 */

/**
 * Approach:
 * 
 * 1. Maintain a map which stores sum calculated until that index and value as index
 * 2. For each element keep adding it to variable as sum
 * 3. At each iteration check whether sum encountered till now is present in map or not
 * 4. If it is present then this means, at that particular index sum would be zero for subarray excluding 
 *      element present at index stored as value in map
 * 5. So this answer = Math.max(answer, i - hashMap.get(sum)), keeps on tracking length for this subarray
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */


class Solution {
    int maxLen(int arr[], int n)
    {
        // Your code here
        
        Map<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);
        int sum = 0;
        int answer = 0;
        
        for(int i=0; i<n; i++) {
            sum += arr[i];
            
            if(hashMap.containsKey(sum)) {
                answer = Math.max(answer, i - hashMap.get(sum));
            } else {
                hashMap.put(sum, i);
            }
        }
        
        return answer;
    }
}
