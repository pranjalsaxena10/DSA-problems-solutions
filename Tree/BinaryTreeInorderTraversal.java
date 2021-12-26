/**
 * https://leetcode.com/problems/binary-tree-inorder-traversal/
 * 
 * Problem:
 * 
 * Given the root of a binary tree, return the inorder traversal of its nodes' values.
 */

/**
 * Approach:
 * 
 * For Iterative Solution, use stack and push nodes into stack until we reach leftmost end,
 * Whenever current node is null, 
 * 1. pop node from stack 
 * 2. print the value 
 * 3. update current node as current = poppedNode.right
 * 
 * Time Complexity: Linear
 * Space Complexity: Linear
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        
        List<Integer> result = new ArrayList<>();
        iterativeSolution(root, result);
        // recursiveSolution(root, result);
        return result;
    }
    
    private void iterativeSolution(TreeNode root, List<Integer> result) {
        
        Stack<TreeNode> stack = new Stack<>();
        TreeNode current = root;
        
        while (current != null || !stack.isEmpty()) {
            
            while (current != null) {
                stack.push(current);
                current = current.left;    
            }
            
            if (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                result.add(node.val);
                current = node.right;
            }
            
        }
        
    }
    
    private void recursiveSolution(TreeNode root, List<Integer> result) {
        
        if (root == null) {
            return;
        }
        
        recursiveSolution(root.left, result);
        result.add(root.val);
        recursiveSolution(root.right, result);
        
        return;
    }
}