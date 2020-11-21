/**
 * https://leetcode.com/problems/powx-n/
 * 
 * Problem: Implement pow(x, n), which calculates x raised to the power n (i.e. xn).
 */


/**
 * Approach is explained with example
 * Suppose we have to find 2^10:
 * 2^10 => 4^5 => 4 * 4^4 => 4 * 16^2 => 4 * 256 => 1024
 */

class Solution {
    public double myPow(double x, int n) {
        double ans = 1;
        double pow = n<0 ? Math.abs((double)n): n;
        
        while(pow>0) {
            
            if(pow%2==0) {
                x *= x;  
                pow = pow / 2;
            
            } else {
                ans *= x;    
                pow--;
            }
        }    
        
        if(n<0) {
            double one = 1;
            return one / ans;
        }
        return ans;
    }
    
}