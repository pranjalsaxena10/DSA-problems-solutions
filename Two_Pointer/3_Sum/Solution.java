/**
 * https://leetcode.com/problems/3sum/
 * 
 * Problem:
 * 
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

    Notice that the solution set must not contain duplicate triplets.

    

    Example 1:

    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]
 */

/**
 * Approach is similar to 4 Sum
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(1)
 */

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        
        for(int i=0; i<nums.length-1; i++) {
            if(i != 0 && nums[i] == nums[i-1])
                continue;
            
            int left = i+1;
            int right = nums.length - 1;
            int first = nums[i];
            
            while(left<right) {
                
                int tempSum = first + nums[left] + nums[right];
                
                if(tempSum < 0) {
                    
                    left++;
                    
                } else
                    
                    if(tempSum > 0) {
                        
                        right--;
                        
                    } else {
                        
                        List<Integer> answer = new ArrayList<>();
                        answer.add(first);
                        answer.add(nums[left]);
                        answer.add(nums[right]);

                        int lastLeft = nums[left];
                        int lastRight = nums[right];
                        result.add(answer);
                        
                        while(left<right && nums[left] == lastLeft)
                            left++;
                        
                        while(left<right && nums[right] == lastRight)
                            right--;
                        
                    }
            }
            
        }
        
        return result;
    }
}