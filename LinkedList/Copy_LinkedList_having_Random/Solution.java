import java.util.HashMap;
import java.util.HashSet;

/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

/**
 * https://leetcode.com/problems/copy-list-with-random-pointer/
 * 
 * Problem:
 * 
 * A linked list is given such that each node contains an additional random pointer which could point to 
 * any node in the list or null.

    Return a deep copy of the list.

    The Linked List is represented in the input/output as a list of n nodes. Each node is represented as 
    a pair of [val, random_index] where:

    val: an integer representing Node.val
    random_index: the index of the node (range from 0 to n-1) where random pointer points to, or null if it 
    does not point to any node.

    Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
    Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]

 */

/**
 * Approach: 
 *
 * 1. Create
 */

class Solution {
    public Node copyRandomList(Node head) {
        if(head == null)
            return head;
        
        Node tempNode = head;
        
        while(tempNode != null) {
            
            Node newNode = new Node(tempNode.val);
            Node nextNode = tempNode.next;
            tempNode.next = newNode;
            newNode.next = nextNode;
            tempNode = nextNode;
            
        }
        
        tempNode = head;
        
        while(tempNode != null) {
            
            tempNode.next.random = tempNode.random != null ? tempNode.random.next : null;
            tempNode = tempNode.next != null ? tempNode.next.next : null;
            
        }
        
        Node newHead = head.next;
        Node original = head;
        Node copy = head.next;
        
        while(original != null && copy != null) {
            
            original.next = original.next != null ? original.next.next : null;
            copy.next = copy.next != null ? copy.next.next: null;
            
            original = original.next;
            copy = copy.next;
        }
        
        return newHead;
    }
}