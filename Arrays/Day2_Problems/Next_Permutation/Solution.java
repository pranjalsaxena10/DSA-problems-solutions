/**
 * Problem: Next Permutation
 * https://leetcode.com/problems/next-permutation/submissions/
 */

/**
 * Approach: 
 * 1. Start from last and find out (i-1)th position where nums[i] > nums[i-1]
 * 2. If no such position is found, reverse the whole given array
 * 3. Let the location is found as position
 *      Find out greatest index whose elements is greater than nums[position]
 *      suppose this number is found at xth location
 * 4. Swap these two numbers as nums[position] and nums[x]
 * 5. Reverse array starting from position+1 and nums.length-1
 * 6. In place solution is done with time complexity as O(n+logn)
 */

class Solution {
    public void nextPermutation(int[] nums) {
        int position = -1;
        
        for(int i=nums.length-1; i>0; i--) {
            if(nums[i-1] < nums[i]) {
                position = i-1;
                break;
            }
        }
        
        if(position == -1) {
            reverse(nums, 0, nums.length-1);
            return;
        }
        
        int left = position + 1;
        int right = nums.length - 1;
        int target = nums[position];
        
        while(right >= left && nums[right] <= target)
            right--;
        
        swap(nums, position, right);
        reverse(nums, position+1, nums.length-1);
           
    }
    
    void reverse(int[] nums, int left, int right) {
        
        while(left <= right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }
    
    void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}