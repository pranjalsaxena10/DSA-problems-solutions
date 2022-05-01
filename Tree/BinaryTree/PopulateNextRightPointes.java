/**
 * https://leetcode.com/problems/populating-next-right-pointers-in-each-node/
 * 
 * Problem:
 *  You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

    struct Node {
        int val;
        Node *left;
        Node *right;
        Node *next;
    }
    Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

    Initially, all next pointers are set to NULL.

    Example:
    Input:
                            1
                    2               3
                4       5       6       7

    Output:
                            1 -> NULL
                    2     ->         3 -> NULL
                4   ->   5   ->  6   ->   7 -> NULL
 */

/**
 * Approach:
 * 
 * Idea is to keep going left down the tree while tracking Right Node reference
 *  and for each recursive step update node.left = nextNode (previous tracked ref)
 *  and when no more left nodes are there, do recursion of right subtree with nextNode ref as node.next.left
 *  if it is not null
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/



class Solution {
    public Node connect(Node root) {
        populateNext(root, null);
        return root;
    }
    
    private void populateNext(Node node, Node nextNode) {
        if (node == null)
            return;
            
        node.next = nextNode;
        
        populateNext(node.left, node.right);
        
        populateNext(node.right, node.next == null ? null : node.next.left);
        
    }
}