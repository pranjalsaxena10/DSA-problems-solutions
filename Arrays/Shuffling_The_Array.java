/**
 * https://leetcode.com/problems/shuffle-the-array/
 * 
 * Problem:
 * 
 * Given the array nums consisting of 2n elements in the form [x1,x2,...,xn,y1,y2,...,yn].

    Return the array in the form [x1,y1,x2,y2,...,xn,yn].

    

    Example 1:

    Input: nums = [2,5,1,3,4,7], n = 3
    Output: [2,3,5,4,1,7] 
    Explanation: Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
    Example 2:

    Input: nums = [1,2,3,4,4,3,2,1], n = 4
    Output: [1,4,2,3,3,2,4,1]
 */

/**
 * Approach:
 * 
 * To do this in O(n) time and O(1) space
 * since second half of the array should be present at 2 * i + 1 position in resultant array
 * 
 We loop through all nums and swap each nums[i] into its "desired" index. As soon as a number is placed into its "desired" 
 place, we mark it as "negative", so that it won't be processed again when we see it later (yes, because nums[i]'s desired
  index might be after itself, we might see it again later).
Now nums[i] is in its desired place, but how about another number that "is swapped" by nums[i]? 
That number is currently in position "i" now because of the swap. We recursively put that number into its "desired" place 
too, until all the "be-swapped" numbers are also in their desired place.

    After this make every element positive

    Time Complexity: O(n)
    Space Complexity: O(1)
 */
public class Shuffling_The_Array {

    public int[] shuffle(int[] nums, int n) {
        
        int p = 0;
        
        while(p<nums.length) {
            
            int q = p;
            
            while(nums[p] >= 0) {
                q = q >= n ? 2 * (q-n) + 1 : 2 * q;
                
                int temp = nums[p];
                nums[p] = nums[q];
                nums[q] = temp * -1;

            }
            
            p++;
                
        }
        
        for(int i=0; i<nums.length; i++) {
            nums[i] = nums[i] * -1;
        }
        
        return nums;
        
    }    
}
