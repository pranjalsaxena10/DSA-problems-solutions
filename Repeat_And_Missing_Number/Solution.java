/**
 * https://www.geeksforgeeks.org/find-a-repeating-and-a-missing-number/
 */

/**
 * This code is to find out repeating and missing element in given array having elements within range as 1...n
 * One condition is also there that repeating element only occurs twice
 */

/**
 * There are many approaches for this but time and space optimal approach is discussed here
 * 
 * Approach 1: 
 * By using arithmetic calculations
 * But this could cause arithmetic overflows
 * 
 * Approach 2:
 * 1. Prepare XOR of every number from 1 to n suppose it evaluates as "xorA"
 * 2. Do XOR for each element in array (arr) 
 * 3. Final XOR -> xorA will be having result as xorA = repeating element ^ missing element
 * 4. We have to get repeating and missing element as separate but not XOR of them
 * 4. Find out right most set bit in xorA
 * 5. Now we have to seggregate numbers present in arr and 1 <= num <= n to two different sets "x and y" 
 *    which have previous identified bit set as 0 or 1 
 * 6. Once it is done it will be pretty sure that either x or y will be repeating and other one would be
 *    missing.
 * 7. To find out this iterate through array again and if either x or y is present in given array break the
 *    loop and mention that element as repeating and other one as missing.  
 */

public class Solution {
    
    int[] findTwoElement(int arr[], int n) {
        int xorA = 0;
        
        for(int num: arr) {
            xorA ^= num;    
        }
        
        for(int i=1; i<=n; i++) {
            xorA ^= i;
        }
        
        int rightMostSetBitNo = xorA & ~(xorA - 1);
        int x = 0, y = 0;
        
        for(int num: arr) {
            if((rightMostSetBitNo & num) != 0) {
                x ^= num; 
            }
                  
            else {
                y ^= num;
            }
                
        }
        
        for(int i=1; i<=n; i++) {
            if((rightMostSetBitNo & i) != 0) {
                x ^= i; 
            }
                  
            else {
                y ^= i;
            }
        }
        
        
        int rep = 0, missing = 0;
        
        for(int num: arr) {
            if(num == x || num == y) {
                rep = num;
                break;
            }
        }
        missing = rep ^ x ^ y;
        
        int[] ans = new int[2];
        ans[0] = rep;
        ans[1] = missing;
        return ans;
    }
}
