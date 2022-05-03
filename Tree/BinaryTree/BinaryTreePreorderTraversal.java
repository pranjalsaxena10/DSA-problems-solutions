/**
 * https://leetcode.com/problems/binary-tree-preorder-traversal/
 * 
 * Problem:
 * 
 * Given the root of a binary tree, return the preorder traversal of its nodes' values.
 */

/**
 * Approach:
 * 
 * For Iterative Solution, keep printing current node value
 * use stack and push right child of current node into stack until we reach leftmost end,
 * Whenever current node is null,
 * 1. pop node from stack
 * 2. update current node as current = poppedNode
 * 
 * Time Complexity: Linear
 * Space Complexity: Linear
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        
        iterativeSolution(root, result);
        
        return result;
    }
    
    private void iterativeSolution(TreeNode root, List<Integer> result) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        
        while (current != null || !stack.isEmpty()) {
            
            while (current != null) {
                result.add(current.val);
                
                if (current.right != null) {
                    stack.push(current.right);
                }
                
                current = current.left;
            }
            
            if (!stack.isEmpty()) {
                current = stack.pop();
            }
            
        }
    }
    
    private void recursiveSolution(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        
        result.add(node.val);
        recursiveSolution(node.left, result);
        recursiveSolution(node.right, result);
    }
}