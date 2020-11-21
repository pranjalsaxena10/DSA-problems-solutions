/**
 * https://leetcode.com/problems/majority-element/
 * 
 * Problem: Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.

    You may assume that the array is non-empty and the majority element always exist in the array.
 */

 /**
  * Approach: 
    Taking two variables majority and majorityCount
    1. Treat first element as majority
    2. If next element is same as majority keep updating majorityCount
    3. Or else keep decreasing majorityCount
    4. At each step keep checking if majorityCount is 0 then, this means all elements before it are nullified
        So update majority as current element
  */


  class Solution {
    public int majorityElement(int[] nums) {
        /**
            Implementing Moore's voting algorithm
            Time Complexity = O(n) and Space Complexity O(1)
        */
        
        int majority = 0;
        int majorityCount = 0;
        
        for(int num: nums) {
            if(majority == num) {
                majorityCount++;
            } else 
                if(majorityCount == 0) {
                    majorityCount = 1;
                    majority = num;
                } else {
                    majorityCount--;
                }
        }
        
        return majority;
    }
}