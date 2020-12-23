import java.util.*;
import java.lang.*;
import java.io.*;

/**
 * https://practice.geeksforgeeks.org/problems/k-th-element-of-two-sorted-array/0#
 * 
 * Problem:
 * Given two sorted arrays A and B of size M and N respectively and an element k. The task is to find the element that would be at the k’th position of the final sorted array.

    Input:
    First line consists of test cases T. First line of every test case consists of 3 integers N, M and K, denoting M number of elements in A, N number of elements in B and kth position element. Second and Third line of every test case consists of elements of A and B respectively.

    Output:
    Print the element at the Kth position.

    Constraints:
    1 <= T <= 200
    1 <= N, M <= 106
    1 <= Ai, Bi <= 106
    1 <= K <= N+M

    Example:
    Input:
    1
    5 4 5
    2 3 6 7 9
    1 4 8 10

    Output:
    6

    Explanation:
    Testcase 1: Element at 5th position after merging both arrays will be 6.
 */

/**
 * Approach:
 * It is just similar to finding median of two sorted arrays, diff is just that in median case we have to 
 * size / 2 th element, in nutshell but here in this ques it's about finding kth element
 * 
 * We have to check for edge case like in some cases of partitions, it could happen that partition2 could go 
 * beyond range as: partition2 < 0 || partition2 > 2nd array length
 * 
 * If it goes:
 * as partition2 < 0 which means we are too much on the right side of 1st array, 
 *  so we make right = partition1 - 1;
 * 
 * as partition2 > 2nd array length which means are too much on left side of 1st array,
 *  so we make left = partition1 + 1;
 * 
 * m:- 1st array length
 * n:- 2nd array length
 * 
 * Time Complexity: O(log(min(m, n))) 
 * Space Complexity: O(1)
 */
class Solution {
	public static void main (String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int t=Integer.parseInt(sc.nextLine());
	    
	    while(t-->0) {
	        String[] firstLine = sc.nextLine().split(" ");
	        int n = Integer.parseInt(firstLine[0]);
	        int m = Integer.parseInt(firstLine[1]);
	        int k = Integer.parseInt(firstLine[2]);
	        
	        String[] secondLine = sc.nextLine().split(" ");
	        String[] thirdLine = sc.nextLine().split(" ");
	        
	        int[] nums1 = new int[n];
	        int[] nums2 = new int[m];
	        
	        for(int i=0; i<n; i++) {
	            nums1[i] = Integer.parseInt(secondLine[i]); 
	        }
	        
	        for(int i=0; i<m; i++) {
	            nums2[i] = Integer.parseInt(thirdLine[i]); 
	        }
	        
	        System.out.println(findKthElement(nums1, nums2, k));
	        
	    }
	    
    }
	 
	private static int findKthElement(int[] nums1, int[] nums2, int k) {
        int m = nums1.length;
        int n = nums2.length;
        
        if(m<=n) {
            return findKthElementUtil(nums1, nums2, k);
        } else {
            return findKthElementUtil(nums2, nums1, k);
        }
        
    }
    
    private static int findKthElementUtil(int[] arr1, int[] arr2, int k) {
        
        int left = 0;
        int right = arr1.length;
        
        int m = arr1.length;
        int n = arr2.length;
        int ans = -1;
        
        while(left <= right) {
            
            int partition1 = left+right+1>>1;
            int partition2 = k - partition1;
            
            if(partition2 < 0) {
                right = partition1 - 1;
                continue;
            } 
            
            if(partition2 > n) {
                left = partition1 + 1;
                continue;
            }
            
            int max1 = partition1 == 0 ? Integer.MIN_VALUE : arr1[partition1-1];
            int max2 = partition2 == 0 ? Integer.MIN_VALUE : arr2[partition2-1];
            int min1 = partition1 == m ? Integer.MAX_VALUE : arr1[partition1];
            int min2 = partition2 == n ? Integer.MAX_VALUE : arr2[partition2];
            
            if(max1 <= min2 && max2 <= min1) {
                ans = Math.max(max1, max2);   
                return ans;    
            } else 
            
                if(max1 > min2)
                    right = partition1 - 1;
                else
                
                    left = partition1 + 1;
            
        }
        
        return ans;

    }
}