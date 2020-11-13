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