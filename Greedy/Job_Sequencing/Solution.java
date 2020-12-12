/**
 * https://practice.geeksforgeeks.org/problems/job-sequencing-problem-1587115620/1#
 * 
 * Problem: 
 * 
 * Given a set of N jobs where each job i has a deadline and profit associated to it. Each job takes 1 unit of time to complete and only one job can be scheduled at a time. We earn the profit if and only if the job is completed by its deadline. The task is to find the maximum profit and the number of jobs done.

    Input Format:

    Jobs will be given in the form (Job id, Deadline, Profit) associated to that Job.

    Example 1:

    Input:
    N = 4
    Jobs = (1,4,20)(2,1,10)(3,1,40)(4,1,30)
    Output: 2 60
    
    Explanation: 2 jobs can be done with
    maximum profit of 60 (20+40).
    Example 2:

    Input:
    N = 5
    Jobs = (1,2,100)(2,1,19)(3,2,27)
    (4,1,25)(5,1,15)
    Output:2 127

    Explanation: 2 jobs can be done with
    maximum profit of 127 (100+27).
 */

/**
 * Approach:
 * 1. First sort jobs on the basis of profit in decreasing order
 * 2. Now at each moment we have to allocate greatest slot which can meet up deadline
 * 3. Naive approach can be of finding greatest possible slot for each job, but that would cause 
 *      time complexity to be in order of O(n*n), i.e O(n^2)
 * 4. If we can use DisjointSet, data structure, then we could achieve time complexity as order of O(n*logn)
 * 5. DisjointSet is implemented as a new Class having one array as parent, which will store representative 
 *      of each set.
 * 6. For each time, we find out maximum available slot by finding out representative of set 
 *      in which given job deadline is present
 * 7. If available slot or representative of set is positive then we can include it in profit, else we cannot 
 *      include that job, hence ignore
 * 8. Once after profit is considered for every job, we have to update representative of selected slot,
 *      with representative of selected slot - 1
 * 
 * Time Complexity: O(N*logN)
 * Space Complexity: O(max of deadLine of jobs)
 */
class Solution {
    class DisjointSet {
        
        int[] parent;
        
        DisjointSet(int n) {
            parent = new int [n+1];
            for(int i=0; i<=n; i++) {
                parent[i] = i;
            }
        }
        
        int findSet(int s) {
            // base case
            
            if(s == parent[s])
                return s;
                
            parent[s] = findSet(parent[s]);
            
            return parent[s];
        }
        
        void merge(int n, int m) {
            parent[m] = n;
        }
        
    }
    
    int[] jobScheduling(Job arr[], int n){
        
        Arrays.sort(arr, (Job job1, Job job2) -> {
           
            if(job1.profit > job2.profit)
                 return -1;
                 
                 else
                     if (job1.profit < job2.profit)
                         return 1;
                         
                         else
                             return 0;
         });
        
         int maxDeadLine = 0;
        
        for(int i=0; i<n; i++) {
            maxDeadLine = Math.max(arr[i].deadline, maxDeadLine);    
        }
        
        DisjointSet disjointSet = new DisjointSet(maxDeadLine);
        
        int[] result = new int[2];
        
        List<Integer> jobs = new ArrayList<>();
        int profit = 0;
        
        for (int i=0; i<n; i++) {
            
            int greatestAvailableSlot = disjointSet.findSet(arr[i].deadline);
            
            // If maximum available free slot is greater 
            // than 0, then free slot available 

            if(greatestAvailableSlot > 0) {
                // This slot is taken by this job 'i' 
                // so we need to update the greatest free 
                // slot. So future queries for 
                // availableSlot will return maximum slot 
                // from set of "greatestAvailableSlot - 1" 

                profit += arr[i].profit;
                jobs.add(arr[i].profit);
                disjointSet.merge(disjointSet.findSet(greatestAvailableSlot - 1), greatestAvailableSlot);
            }
            
        }
        
        result[0] = jobs.size();
        result[1] = profit;
        
        return result;
    }    
}
