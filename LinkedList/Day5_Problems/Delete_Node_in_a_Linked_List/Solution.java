/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * https://leetcode.com/problems/delete-node-in-a-linked-list/
 * 
 * Problem: 
 * Write a function to delete a node in a singly-linked list. You will not be given access to the head of the list, instead you will be given access to the node to be deleted directly.

    It is guaranteed that the node to be deleted is not a tail node in the list.
    
    Input: head = [1,2,3,4], node = 3
    Output: [1,2,4]
 */

/**
 * Approach:
 * 
 * Swap values of next node with current node and point given node's next value to nextNode's next value
 * make nextNode's next value to null
 * 
 * Time Complexity = O(1)
 * Space Complexity = O(1)
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode nextNode = node.next;
        int temp = node.val;
        node.val = nextNode.val;
        nextNode.val = temp;
        
        node.next = nextNode.next;
        nextNode.next = null;
    }
}