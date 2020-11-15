/**
 * https://leetcode.com/problems/sort-colors/
 */

/**
 * Approach:
1. Have 3 variables to hold index of 0, 1 and 2 as zero -> 0, one -> 1, second -> 2
2. If current element is 0 then we have to make room for it so, in order to do it we need to move 2's, 1's. 
    For 1 and 2 as well same logic is to be implemented to have space for 1 and 2 as well.
 */

class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, one = 0, second = 0;
        
        for(int i=0; i<nums.length; i++) {
            
            switch(nums[i]) {
                case 0:
                    nums[second++] = 2;
                    nums[one++] = 1;
                    nums[zero++] = 0;
                    break;
                    
                case 1:
                    nums[second++] = 2;
                    nums[one++] = 1;
                    break;
                    
                case 2:
                    nums[second++] = 2;
                    break;
            }
            
        }
    }
}