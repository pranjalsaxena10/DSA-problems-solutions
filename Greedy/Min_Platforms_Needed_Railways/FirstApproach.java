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
 * 1. Sort intervals on the basis of arrival time
 * 2. Prepare PriorityQueue which will have departure time stored for each sorted interval
 * 3. For each iteration keep checking if at any moment pq is empty then this means 1 extra platform is needed
 * 4. Also for every iteration check, arrival time <= pq.peek, then this means 1 extra platform is needed
 * 5. If arrival time > pq.peek, then this means no overlap is there, so min element can be pulled out from PQ
 * 6. Keep inserting each interval's end time in PQ
 * 
 * Time Complexity: O(N * logN)
 * Space Complexity: O(N)
 */

public class FirstApproach {
    
    static int findPlatform(int arr[], int dep[], int n) {

        int[][] schedule = new int[n][2];
        
        for (int i=0; i<n; i++) {
            schedule[i][0] = arr[i];
            schedule[i][1] = dep[i];
        }
        
        Arrays.sort(schedule, (first, second) -> {
            if (first[0] > second[0])
                return 1;
                else
                    if (first[0] < second[0])
                        return -1;
                        else
                            return 0;
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int platforms = 0;
        
        for (int i=0; i<n; i++) {
            
            int arrival = schedule[i][0];
            int departure = schedule[i][1];
            
            if (pq.isEmpty()) {
                
                platforms++;
            
            } else {
                
                if (arrival <= pq.peek()) {
                    
                    platforms++;
                    
                } else {
                    
                    pq.poll();
                    
                }
                
            }
            
            pq.add(departure);
        }
        
        return platforms;
    }   
}
