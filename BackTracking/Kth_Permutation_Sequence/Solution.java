/**
 * Approach:
 * 
 * There could be two solutions: 
 * 
 * Solution - 1:
 * 
 * 1. Use Backtracking and store all permutations in the form of strings 
 * 2. Return kth string present in list
 * 
 * Solution - 2:
 * 
 * First solution will be having huge time complexity, Since backtracking is used
 * Else, we can use below mathematical solution
 * 
 * 1. For each position, there would be (n-pos)! group size
 * 2. Like if n=4, this leads to 3! group size, out of which we have to find which group does kth permutation 
 *      would belong, by using something as index = k / (n-pos)!
 * 3. If we have to find suppose 9th permutation, then we first decrement it by 1 and then 
 *      k = 8 and index = 8 / (4-1)! => index = 1 which means '2' would be starting char
 *      after that we have to shift elements present to left in order to remove it
 *      For next iteration k would change as k = k % (n-pos)!
 * 
 * Time Complexity: O(n^2)
 * Space Complexity: O(n)
 * 
 */
class Solution {
    
    public String getPermutation(int n, int k) {
        int factorial = 1;
        char[] nums = new char[n];
        char one = '1';
        nums[0] = one;
        
        for(int i=2; i<=n; i++) {
            factorial *= i;
            one += 1;
            nums[i-1] = one;
        }
        
        --k;
        char[] result = new char[n];
        int it = 0; 
        
        // factorial will be having value as n!
        
        for(int i=1; i<=n; i++) {
            factorial = factorial / (n-i+1);
            int index = k / factorial;
            
            result[it++] = nums[index];
           
            for(int j=index; j<n-1; j++) {
                nums[j] = nums[j+1];
            }
            
            k = k % factorial;
        }
        
        return new String(result);
    }
}