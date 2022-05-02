/**
 * https://www.interviewbit.com/problems/path-to-given-node/
 * 
 * Problem:
 *  Given a Binary Tree A containing N nodes.

    You need to find the path from Root to a given node B.

    NOTE:

    No two nodes in the tree have same data values.
    You can assume that B is present in the tree A and a path always exists
 */

/**
 * Approach:
 * 
 * Steps:
 * 1. Corner case, if node == null, return false
 * 2. Add current node's val in path
 * 3. Check for if node.val == target, return true
 * 4. Do the same for left and right sub-trees
 * 5. If found in either left or right sub-trees, return true
 * 6. Else remove the last element from the resulting path and return false
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

/**
 * Definition for binary tree
 * class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) {
 *      val = x;
 *      left=null;
 *      right=null;
 *     }
 * }
 */
public class Solution {
    public int[] solve(TreeNode A, int B) {
        List<Integer> path = new ArrayList<>();

        find(A, B, path);
        
        int[] result = new int[path.size()];
        

        for(int i=0; i<result.length; i++) {
            result[i] = path.get(i);
        }

        return result;
    }

    private boolean find(TreeNode node, int target, List<Integer> path) {
        if (node == null) {
            return false;
        }

        path.add(node.val);

        if (node.val == target)
            return true;

        boolean inLeftSubTree = find(node.left, target, path);
        boolean inRightSubTree = find(node.right, target, path);

        if (inLeftSubTree || inRightSubTree) {
            return true;
        } else {
          path.remove(path.size()-1);
          return false;  
        }

    }
}
