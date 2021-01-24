/**
 * https://leetcode.com/problems/count-of-smaller-numbers-after-self/
 * 
 * Problem:
 * 
 * You are given an integer array nums and you have to return a new counts array. The counts array has the property 
 * where counts[i] is the number of smaller elements to the right of nums[i].

    Example 1:

    Input: nums = [5,2,6,1]
    Output: [2,1,1,0]
    Explanation:
    To the right of 5 there are 2 smaller elements (2 and 1).
    To the right of 2 there is only 1 smaller element (1).
    To the right of 6 there is 1 smaller element (1).
    To the right of 1 there is 0 smaller element.
 */

/**
 * Time Complexity: O(n*logn)
 * Space Complexity: O(n)
 */
class Pair {
    int val;
    int index;
    Pair(int val, int index) {
        this.val = val;
        this.index = index;
    }
}

public class Count_Of_Smaller_Numbers_After_Self {

    public List<Integer> countSmaller(int[] nums) {
        Pair[] arr = new Pair[nums.length];
        Pair[] input = new Pair[nums.length];
        
        List<Integer> response = new ArrayList<>(nums.length);
        int[] result = new int[nums.length];
        
        for(int i=0; i<nums.length; i++) {
            Pair p = new Pair(nums[i], i);
            input[i] = p;
        }
        
        util(input, 0, nums.length - 1, arr, result);
        
        for(int i=0; i<result.length; i++) {
            response.add(result[i]);
        }
        
        return response;
    }
    
    private void util(Pair[] nums, int left, int right, Pair[] arr, int[] result) {
        int mid = (left+right)/2;
        int noOfPairs = 0;
        
        if(left<right) {
           util(nums, left, mid, arr, result);
           util(nums, mid+1, right, arr, result);
           merge(left, right, mid, nums, arr, result);
        }
        
    }
    
    private void merge(int left, int right, int mid, Pair[] nums, Pair[] arr, int[] result) {
        int i = left;
        int j = mid+1;
        int k = left;
        int l = mid;
        int m = right;
        
        while(l>=left && m>=j) {
            if(nums[l].val > nums[m].val) {
                result[nums[l].index] += (m-j+1);
                l--;
            } else {
                m--;
            }
        }
        
        while(i<=mid && j<=right) {
            
            if(nums[i].val <= nums[j].val) {
                arr[k++] = nums[i++];
            }
            else {
                // result.set(i, mid-i+1);
                // count += (mid-i+1);
                arr[k++] = nums[j++];
            }
        }
        
        while(i<=mid) {
            arr[k++] = nums[i++];
        }
        
        while(j<=right) {
            arr[k++] = nums[j++];
        }
        
        for(int p=left; p<=right; p++) {
            nums[p] = arr[p];
        }
        
    }
}