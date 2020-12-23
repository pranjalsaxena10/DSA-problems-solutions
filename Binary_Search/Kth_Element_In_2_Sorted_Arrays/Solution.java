import java.util.*;
import java.lang.*;
import java.io.*;

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