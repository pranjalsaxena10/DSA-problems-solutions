/**
 * https://www.interviewbit.com/problems/search-in-bitonic-array/#
 * 
 * Problem:
 * Given a bitonic sequence A of N distinct elements, write a program to find a given element B in the bitonic
 *  sequence in O(logN) time.

    NOTE:

    A Bitonic Sequence is a sequence of numbers which is first strictly increasing then after a point strictly 
    decreasing.


    Problem Constraints
    3 <= N <= 105

    1 <= A[i], B <= 108

    Given array always contain a bitonic point.

    Array A always contain distinct elements.



    Input Format
    First argument is an integer array A denoting the bitonic sequence.

    Second argument is an integer B.



    Output Format
    Return a single integer denoting the position (0 index based) of the element B in the array A if B doesn't
    exist in A return -1.



    Example Input
    Input 1:

    A = [3, 9, 10, 20, 17, 5, 1]
    B = 20
    Input 2:

    A = [5, 6, 7, 8, 9, 10, 3, 2, 1]
    B = 30


    Example Output
    Output 1:

    3
    Output 2:

    -1


    Example Explanation
    Explanation 1:

    B = 20 present in A at index 3
    Explanation 2:

    B = 30 is not present in A

 */


/**
 * Approach:
 * 
 * Find peak element of given bitonic array and in left subarray and right subarray perform binary search
 * 
 * Time Complexity: O(log n)
 * Space Complexity : O(1)
 */
public class Solution {

    public int solve(ArrayList<Integer> A, int B) {

        int index = isPeakElementPresent(A);
        if(index != -1) {
            int left = 0;
            int right = index;
            
            while(left<=right) {
                int mid = left + (right-left)/2;
                
                if(A.get(mid) == B)
                    return mid;
                else
                    if(A.get(mid) < B)
                        left = mid + 1;
                    else
                        right = mid - 1;
            }
            
            left = index;
            right = A.size() - 1;
            
            while(left<=right) {
                int mid = left + (right-left)/2;
                
                if(A.get(mid) == B)
                    return mid;
                else
                    if(A.get(mid) > B)
                        left = mid + 1;
                    else
                        right = mid - 1;
            }
            
        }
        
        return -1;
    }
    
    private int isPeakElementPresent(ArrayList<Integer> arr) {
        int left = 0;
        int right = arr.size()-1;
        int n = arr.size();
        
        while(left<=right) {
            int mid = left + (right-left)/2;
            
            if(mid == 0 || mid == n-1) {
                break;
            }
            
            if(arr.get(mid) > arr.get(mid+1) && arr.get(mid) > arr.get(mid+1))
                return mid;
            else
                if(arr.get(mid) < arr.get(mid+1))
                    left = mid + 1;
                else
                    right = mid - 1;
        }
        
        return -1;
    }
}
