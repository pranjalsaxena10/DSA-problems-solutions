/**
 * https://leetcode.com/problems/longest-consecutive-sequence/
 * Problem: 
 * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.

    Follow up: Could you implement the O(n) solution? 
 */

/**
 * Approach:
 * 
 * 1. Use HashMap instead of HashSet since HashMap is faster than HashSet
 * 2. For each number we keep checking in map whether we have number - 1 and number + 1
 * 3. If we have we keep updating smaller and larger number and also keep removing smaller and larger number from map
 *      in order to free up extra memory since it is of no longer use after it is considered
 * 4. Keep tracking of maximum length as larger - smaller - 1;
 *      because larger - smaller - 1 gives only range excluding smaller and larger which are not found in map
 */

class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Integer> map = new HashMap();
        int answer = 0;
        
        for(int i=0; i<nums.length; i++) {
            map.put(nums[i], 1);
        }
        
        for(int i=0; i<nums.length; i++) {
            int num = nums[i];
            
            if(!map.containsKey(num))
                continue;
            
            int smaller = num - 1;
            int larger = num + 1; 

            while(map.containsKey(smaller)) {
                map.remove(smaller);
                smaller--;
            }

            while(map.containsKey(larger)) {
                map.remove(larger);
                larger++;
            }

            answer = Math.max(answer, larger - smaller - 1);
        }
        
        return answer;
    }
}