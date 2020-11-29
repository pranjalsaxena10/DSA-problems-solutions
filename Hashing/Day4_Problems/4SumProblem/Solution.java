/**
 * https://leetcode.com/problems/4sum/
 * 
 * Problem:
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

    Notice that the solution set must not contain duplicate quadruplets.
 * 
 */


/**
 * Approach: First sort the array and then apply brute force
 * This is nothing but optimized brute force
 * 
 * TimeComplexity: O(n^3)
 */

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        
        for(int i=0; i<nums.length - 2; i++) {
            for(int j=i+1; j<nums.length-1; j++) {
                
                int first = nums[i];
                int second = nums[j];
                
                int left = j+1;
                int right = nums.length - 1;
                int sum = target - nums[i] - nums[j];
                
                while(left<right) {
                    int tempSum = nums[left] + nums[right];
                    
                    if(sum < tempSum) {
                        
                        right--;
                        
                    } else if(sum > tempSum) {
                        
                        left++;
                        
                    } else {
                        
                        List<Integer> tempList = new ArrayList<>();
                        tempList.add(first);
                        tempList.add(second);
                        tempList.add(nums[left]);
                        tempList.add(nums[right]);
                        result.add(tempList);
                       
                        while(left<right && nums[left] == tempList.get(2))
                            left++;
                        
                        while(left<right && nums[right] == tempList.get(3))
                           right--;
                    }
                }
                
                while(j + 1 < nums.length && nums[j+1] == nums[j])
                   j++;
            }
            
            while(i + 1 < nums.length && nums[i+1] == nums[i])
               i++;
        }
        
        return result;
    }
}