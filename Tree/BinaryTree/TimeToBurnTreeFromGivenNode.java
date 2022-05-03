/**
 *  https://www.interviewbit.com/problems/burn-a-tree/
 *  
 *
 *  Problem:
 *  Given a binary tree denoted by root node A and a leaf node B from this tree.
 *  It is known that all nodes connected to a given node (left child, right child and parent) 
 *  get burned in 1 second. 
 *  Then all the nodes which are connected through one intermediate get burned in 2 seconds, and so on.
 *  You need to find the minimum time required to burn the complete binary tree.
 */

/**
 *  Approach:
 *
 *  We can try to do BFS from the given node and calculate how much time is required to burn
 *  In order to do so, we need to have information of parent references for the nodes respectively
 *  1. Prepare parent reference of each node in some dict suppose HashMap
 *  2. Do BFS from the given node
 *
 *  Time Complexity: O(n)
 *  Space Complexity: O(n)
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
    public int solve(TreeNode A, int B) {
        return timeToBurn(A, B);
    }

    private int timeToBurn(TreeNode node, int startNodeVal) {
        List<TreeNode> path = new ArrayList<>();

        if (!findNode(node, startNodeVal, path)) {
            return 0;
        }

        TreeNode startNode = path.get(path.size()-1);
        Map<TreeNode, TreeNode> parents = prepareParents(node);
        Set<TreeNode> burntNodes = new HashSet<>();
        int totalTime = 0;
        
        Queue<TreeNode> bfs = new LinkedList<>();
        bfs.add(startNode);
        burntNodes.add(startNode); // To keep track of which nodes are already burnt

        while (!bfs.isEmpty()) {
            boolean processed = false;
            int size = bfs.size();

            for (int i=0; i<size; i++) {
                TreeNode currentNode = bfs.poll();

                if (currentNode.left != null && !burntNodes.contains(currentNode.left)) {
                    bfs.add(currentNode.left);
                    burntNodes.add(currentNode.left);
                    processed = true;
                }

                if (currentNode.right != null && !burntNodes.contains(currentNode.right)) {
                    bfs.add(currentNode.right);
                    burntNodes.add(currentNode.right);
                    processed = true;
                }

                TreeNode parentNode = parents.get(currentNode);

                if (parentNode != null && !burntNodes.contains(parentNode)) {
                    bfs.add(parentNode);
                    burntNodes.add(parentNode);
                    processed = true;
                }
            }

            if (processed) 
                totalTime++;
        }
        
        return totalTime;
    }

    private Map<TreeNode, TreeNode> prepareParents(TreeNode node) {
        Map<TreeNode, TreeNode> parents = new HashMap<>();

        Queue<TreeNode> traversal = new LinkedList<>();
        traversal.add(node);

        while(!traversal.isEmpty()) {
            TreeNode currentNode = traversal.poll();

            if (currentNode.left != null) {
                parents.put(currentNode.left, currentNode);
                traversal.add(currentNode.left);
            }

            if (currentNode.right != null) {
                parents.put(currentNode.right, currentNode);
                traversal.add(currentNode.right);
            }
        }

        return parents;
    }

    private boolean findNode(TreeNode node, int target, List<TreeNode> path) {
        if (node == null) {
            return false;
        }

        path.add(node);

        if (node.val == target) {
            return true;
        }

        if (findNode(node.left, target, path) || findNode(node.right, target, path)) {
            return true;
        } else {
            path.remove(path.size()-1);
            return false;
        }
    }
}
