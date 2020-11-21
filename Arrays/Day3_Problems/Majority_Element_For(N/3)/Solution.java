/**
 * https://leetcode.com/problems/majority-element-ii/
 * 
 * Problem:
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

    Follow-up: Could you solve the problem in linear time and in O(1) space?
 */

/**
  * Approach: 
    Similar to https://leetcode.com/problems/majority-element/
  */


class Solution {
    public List<Integer> majorityElement(int[] nums) {
        /**
            Implementing Moore's voting algorithm
            Time Complexity = O(n) and Space Complexity O(1)
        */
        
        int majority = 0, secondMajority = 0;
        int majorityCount = 0, secondMajorityCount = 0;
        
        for(int num: nums) {
            
            if(num == majority) {
                majorityCount++;
                
            } else
                if(num == secondMajority) {
                    
                    secondMajorityCount++;
                    
                } else 
                    if(majorityCount == 0) {

                        majority = num;
                        majorityCount = 1;
                        
                    } else 
                        if(secondMajorityCount == 0) {

                            secondMajority = num;
                            secondMajorityCount = 1;

                        } else {

                            majorityCount--;
                            secondMajorityCount--;

                        }
            
            
        }
        
        majorityCount = 0;
        secondMajorityCount = 0;
        int targetFreq = (int) Math.floor(nums.length/3);
        
        for(int num: nums) {
            if(num == majority)
                majorityCount++;
            
            if(num == secondMajority)
                secondMajorityCount++;
        }
        
        
        List<Integer> result = new ArrayList<>();
        
        if(majority == secondMajority) {
            
            if (majorityCount > targetFreq) {
            
                result.add(majority);
                return result;
                
            }    
        }
        
        if(majorityCount > Math.floor(nums.length/3))
            result.add(majority);
        
        if(secondMajorityCount > Math.floor(nums.length/3))
            result.add(secondMajority);
        
        return result;
    }
}