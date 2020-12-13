/**
 * https://leetcode.com/problems/permutations/
 * 
 * Problem: 
 * Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

    

    Example 1:

    Input: nums = [1,2,3]
    Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 */

/**
 * Approach: 
 * 1. Start for range as [0...nums.length-1] as [left...right]
 * 2. Iterate for i=left to i=right
 * 3. For every iteration swap nums[i] and nums[left]
 * 4. Backtrack for left + 1
 * 5. Once it's done revert previous swapping operation performed
 * 
 * Time Complexity: O(N * N!)
 * Space Complexity: O(1)
 */
class Solution {
    private List<List<Integer>> result ;
    
    public List<List<Integer>> permute(int[] nums) {
        
        result = new ArrayList<>();
        backtrack(0, nums.length - 1, nums);
        
        return result;
    }
    
    private void backtrack(int left, int right, int[] nums) {
        
        if(left == right) {
            prepareOutput(nums);
            return;
        }
        
        for(int i=left; i<=right; i++) {
            
            swap(nums, i, left);
            backtrack(left+1, right, nums);
            swap(nums, i, left);
            
        }
    }
    
    private void prepareOutput(int[] nums) {
        
        List<Integer> tempList = new ArrayList<>();
        
        for(int i=0; i<nums.length; i++) {
            tempList.add(nums[i]);
        }
        
        result.add(tempList);
        
    }
    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}