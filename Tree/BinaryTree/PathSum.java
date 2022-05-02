/**
 * https://leetcode.com/problems/path-sum/
 * 
 * Problem:
 * Given the root of a binary tree and an integer targetSum, 
    return true if the tree has a root-to-leaf path such that adding up all the values 
    along the path equals targetSum.
    A leaf is a node with no children.
 */

/**
 * Approach:
 * 
 * Steps:
 * 1. Corner case, if node == null, return false
 * 2. if node == leafNode then check for node.val == targetSum ? return true : return false
 * 3. Do the same for left and right sub-trees
 * 4. If found in either left or right sub-trees, return true
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(1) (But Recursive Stack Space is used)
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
 
class Solution {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null)
            return false;
        
        return findSum(root, targetSum);
    }
    
    private boolean findSum(TreeNode node, int targetSum) {
        
        if (node == null) {
            return false;
        }
        
        if (node.left == null && node.right == null) {
            if (node.val == targetSum)
                return true;
            else
                return false;
        }
        
        return findSum(node.left, targetSum - node.val) || findSum(node.right, targetSum - node.val);
    }
}