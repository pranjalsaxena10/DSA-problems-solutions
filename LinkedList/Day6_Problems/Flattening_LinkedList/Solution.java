/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/


/**
 * https://leetcode.com/problems/flatten-a-multilevel-doubly-linked-list/
 * 
 * Problem:
 * 
 * You are given a doubly linked list which in addition to the next and previous pointers, 
 * it could have a child pointer, which may or may not point to a separate doubly linked list. 
 * These child lists may have one or more children of their own, and so on, to produce a multilevel data structure, 
 * as shown in the example below.
 * 
 * Flatten the list so that all the nodes appear in a single-level, doubly linked list. 
 * You are given the head of the first level of the list.
 * 
 * Input: head = [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 * Output: [1,2,3,7,8,11,12,9,10,4,5,6]
 */

/**
 * How multilevel linked list is represented in test case:

    We use the multilevel linked list from Example 1 above:

    1---2---3---4---5---6--NULL
            |
            7---8---9---10--NULL
                |
                11--12--NULL
    The serialization of each level is as follows:

    [1,2,3,4,5,6,null]
    [7,8,9,10,null]
    [11,12,null]
    To serialize all levels together we will add nulls in each level to signify no node connects to the upper 
    node of the previous level. The serialization becomes:

    [1,2,3,4,5,6,null]
    [null,null,7,8,9,10,null]
    [null,11,12,null]

    Merging the serialization of each level and removing trailing nulls we obtain:

    [1,2,3,4,5,6,null,null,null,7,8,9,10,null,null,11,12]
 */

/**
 * Approach:
 * 
 * 1. Store dfs for the Doubly Linked List
 * 2. Make new List and return
 * 
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
class Solution {
    private List<Node> dfs = new ArrayList<>();
    
    public Node flatten(Node head) {
        
        if(head == null)
            return head;
        
        flattenUtil(head, null);
        
        Node newHead = new Node();
        Node temp = newHead;
        Node prev = null;
        
        for(int i=0; i<dfs.size(); i++) {
            Node newNode = new Node(dfs.get(i).val);
            temp.next = newNode;
            newNode.prev = prev;
            prev = newNode;
            temp = newNode;
            
            
        }
        return newHead.next;
    }
    
    private void flattenUtil(Node tempNode, Node prevNode) {
       
        if(tempNode == null)
            return;
        
        dfs.add(tempNode);
        flattenUtil(tempNode.child, tempNode);
        flattenUtil(tempNode.next, tempNode);
        
    }
}