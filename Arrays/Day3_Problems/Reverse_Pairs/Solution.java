/**
 * https://leetcode.com/problems/reverse-pairs/
 * Problem: 
 * Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].

    You need to return the number of important reverse pairs in the given array.
 */

/**
 * Approach is just similar with Inversion of Array problem
 * https://www.geeksforgeeks.org/counting-inversions/
 */

class Solution {
    public int reversePairs(int[] nums) {
        int[] temp = new int[nums.length];
        
        return mergeSort(temp, nums, 0, nums.length - 1);
    }
    
    private int mergeSort(int[] temp, int[] arr, int low, int high) {
        if(low >= high)
            return 0;
        
        int mid = (low+high) >> 1;
        
        int reversePairs = mergeSort(temp, arr, low, mid);
        reversePairs += mergeSort(temp, arr, mid+1, high);
        
        reversePairs += merge(temp, arr, low, mid, high);
        
        return reversePairs;
    }
    
    private int merge(int[] temp, int[] arr, int left, int mid, int right) {
        int reversePairs = 0;
        
        int i = left;
        int j = mid + 1;
        
        while(i<=mid && j<=right) {
            if(arr[i] > (long)2*arr[j]) {
                reversePairs += (mid-i+1);
                j++;
            } else {
                i++;
            }
        }
        
        i = left;
        j = mid+1;
        int k=left;
        
        while(i<=mid && j<=right) {
            
            if(arr[i]<=arr[j]) {
                
                temp[k++] = arr[i++];
                
            } else {
                
                temp[k++] = arr[j++];
                
            }
        }
        
        while(i<=mid) {
            temp[k++] = arr[i++];
        }
        
        while(j<=right) {
            temp[k++] = arr[j++];
        }
        
        for(int p=left; p<=right; p++) {
            arr[p] = temp[p];
        }
        
        return reversePairs;
    }
}