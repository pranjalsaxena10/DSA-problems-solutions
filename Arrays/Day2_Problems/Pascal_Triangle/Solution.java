import java.util.Collections;
import java.util.List;

/**
 * Problem: Pascal Triangle
 * https://leetcode.com/problems/pascals-triangle/
 */

 /**
  * Pretty Simple - Approach -> Just observe the pattern!
  */
class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        
        if(numRows == 0)
            return result;
        
        result.add(Collections.singletonList(1));

        for(int i=1; i<numRows; i++) {
            
            List<Integer> previous = result.get(i-1);
            List<Integer> tempList = new ArrayList<>();
            tempList.add(1);

            for(int j=0; j<previous.size()-1; j++) {
                tempList.add(previous.get(j) + previous.get(j+1));
            }

            tempList.add(1);
            result.add(tempList);

        }

        return result;
    }
}