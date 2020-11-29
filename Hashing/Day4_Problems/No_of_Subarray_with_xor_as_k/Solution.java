/**
 * https://www.interviewbit.com/problems/subarray-with-given-xor/
 * https://www.geeksforgeeks.org/count-number-subarrays-given-xor/
 * 
 * Problem: 
 * Given an array of integers A and an integer B.

    Find the total number of subarrays having bitwise XOR of all elements equals to B.
    Example Input
    Input 1:

    A = [4, 2, 2, 6, 4]
    B = 6

    Input 2:

    A = [5, 6, 7, 8, 9]
    B = 5
 */


/**
 * Approach: 
 * 1. We keep maintaining a map with key as XOR and value as it's count
 * 2. Keep doing each element xor with one variable stored initially 
 * 3. There are two cases in which we can find subarray xor as given target
 * 
 * Case 1: Suppose we have current xor till ith index as "xor"
 *          if we do target ^ xor and get value as => C and there may be a possibility that C would be encountered
 *          previously so if we keep tracking xor of all elements till current index with their count
 *          then simply we update answer with count stored in map for that xorValue
 * 
 * Case 2: current xor itself is equal to target, in this case we can directly update final answer by 1
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {
    public int solve(ArrayList<Integer> A, int B) {
        Map<Integer, Integer> map = new HashMap<>();
        int answer = 0;
        int xor = 0;
        
        for(int i=0; i<A.size(); i++) {
            xor ^= A.get(i);
            
            if(map.containsKey(xor^B)) {
                answer += map.get(xor^B);
            }
            
            if(xor == B) {
                answer++;
            }
            
            if(map.containsKey(xor)) {
                map.put(xor, map.get(xor) + 1);
            } else {
                map.put(xor, 1);
            }
        }
        
        return answer;
    }
}