/**
 * https://practice.geeksforgeeks.org/problems/minimum-platforms-1587115620/1#
 * 
 * Problem: 
 * 
 * 
    Given arrival and departure times of all trains that reach a railway station. Find the minimum number of platforms required for the railway station so that no train is kept waiting.
    Consider that all the trains arrive on the same day and leave on the same day. Arrival and departure time can never be the same for a train but we can have arrival time of one train equal to departure time of the other. At any given instance of time, same platform can not be used for both departure of a train and arrival of another train. In such cases, we need different platforms,

    

    Example 1:

    Input: N = 6 
    arr[] = [0900  0940 0950  1100 1500 1800]
    dep[] = [0910 1200 1120 1130 1900 2000]
    Output: 3
    Explanation: 
    Minimum 3 platforms are required to 
    safely arrive and depart all trains.
 */

/**
 * Approach:
 * 1. Sort arrival and departure individually
 * 2. Start from 2nd index of arrival and 1st index of departure
 * 3. Keep checking if arrival <= departure, then this means overlap is there 
 *      hence platform count should be updated by 1.
 * 4. When arrival > departure then platform count can be decreased by 1
 * 5. At each iteration, maintain max count of platforms
 * 
 * Time Complexity: O(N * logN)
 * Space Complexity: O(1)
 */

public class SecondApproach {

    static int findPlatform(int arr[], int dep[], int n) {

        Arrays.sort(arr);
        Arrays.sort(dep);
        int arrival = 1;
        int departure = 0;
        int platforms = 1;
        int result = 1;
        
        while (arrival<arr.length && departure<dep.length) {
            
            if (arr[arrival] <= dep[departure]) {
                platforms++;
                arrival++;
                
            } else {
                platforms--;
                departure++;
            }
            
            result = Math.max(result, platforms);
            
        }
        
        return result;
    }    
}
