/**
 * https://leetcode.com/problems/combination-sum/
 * 
 * Problem: 
 * Given an array of distinct integers candidates and a target integer target, return a list of all unique combinations of candidates where the chosen numbers sum to target. You may return the combinations in any order.

    The same number may be chosen from candidates an unlimited number of times. Two combinations are unique if 
    the frequency of at least one of the chosen numbers is different.

    It is guaranteed that the number of unique combinations that sum up to target is less than 150 combinations 
    for the given input.

    

    Example 1:

    Input: candidates = [2,3,6,7], target = 7
    Output: [[2,2,3],[7]]
    Explanation:
    2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
    7 is a candidate, and 7 = 7.
    These are the only two combinations.

    Constraints:

    1 <= candidates.length <= 30
    1 <= candidates[i] <= 200
    All elements of candidates are distinct.
    1 <= target <= 500
 */

/**
 * Approach:
 * Backtracking Approach seems suitable to generate all possible unique combinations
 */
class Solution {
    private List<List<Integer>> result;
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        
        return backtrack(0, target, new ArrayList<>(), candidates);
    }
    
    private List<List<Integer>> backtrack(int start, int target, List<Integer> tempResult, int[] candidates) {
        
        if(target < 0)
            return result;
        
        if(target == 0) {
            result.add(new ArrayList<>(tempResult));
            return result;
        }
        for(int i=start; i<candidates.length; i++) {
            tempResult.add(candidates[i]);
            backtrack(i, target-candidates[i], tempResult, candidates);
            tempResult.remove(tempResult.size()-1);
        }
        
        return result;
            
    }
}