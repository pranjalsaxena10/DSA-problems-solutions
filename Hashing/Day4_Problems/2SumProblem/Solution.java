/**
 * https://leetcode.com/problems/two-sum/
 * 
 * Problem:
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.

    You can return the answer in any order.
 */


/**
 * Approach: 
 * First we have to store index of every element with key as number itself and value as index
 * then for each element we check whether this value and target - currentValue is present in map
 * this depicts finding remaining value in subsequent part of array
 * 
 * Time Complexity = O(n)
 * Space Complexity = O(n)
 */

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        
        int[] result = new int[2];
        
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }
        
        for(int i=0; i<nums.length; i++) {
            
            int firstValue = nums[i];
            int secondValue = target - firstValue;
            
            if(map.containsKey(secondValue) && i != map.get(secondValue)) {
                result[0] = i;
                result[1] = map.get(secondValue);
                break;
            }
        }
        
        return result;
    }
}