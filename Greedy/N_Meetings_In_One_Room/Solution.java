/**
 * https://practice.geeksforgeeks.org/problems/n-meetings-in-one-room-1587115620/1
 * 
 * Problem: 
 * 
 * There is one meeting room in a firm. There are N meetings in the form of (S[i], F[i]) where S[i] is start time of meeting i and F[i] is finish time of meeting i.

    What is the maximum number of meetings that can be accommodated in the meeting room? Also note start time of one chosen meeting can't be equal to the end time of the other chosen meeting.

    Example 1:

    Input:
    N = 6
    S[] = {1,3,0,5,8,5}
    F[] = {2,4,6,7,9,9}
    Output: 1 2 4 5
    Explanation: Four meetings can held with
    given start and end timings.

 */

/**
 * Approach:
 * 
 * 1. Meetings should be sorted first on the basis of end time
 * 2. Initialize result as 1
 * 3. Check in sorted list if any overlap is not present then result can be increased and timeLimit would 
 *      be updated with current meeting endTime
 * 4. Ignore if any overlap is present
 * 
 * Time Complexity: O(N*LogN)
 * Space Complexity: O(1)
 */

class Solution {

    static void maxMeetings(int start[], int end[], int n) {
        // add your code here
        List<List<Integer>> meetings = new ArrayList<>();
        
        for(int i=0; i<n; i++) {
            List<Integer> meeting = new ArrayList<>();
            
            meeting.add(start[i]);
            meeting.add(end[i]);
            
            meetings.add(meeting);
        }
        
        int result = 1;

        meetings.sort((List<Integer> first, List<Integer> second) -> {
            return first.get(1) - second.get(1);
        });
        
        int timeLimit = meetings.get(0).get(1);
        
        for(int i=1; i<n; i++) {
            
            int startTime = meetings.get(i).get(0);
            int endTime = meetings.get(i).get(1);
            
            if(startTime >= timeLimit) {
            
                result++;
                timeLimit = endTime;
                
            }
        }
    }    
}
