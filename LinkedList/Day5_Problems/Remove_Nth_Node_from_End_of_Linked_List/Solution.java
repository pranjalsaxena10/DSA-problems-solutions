/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */


/**
 * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
 * 
 * 
 * Problem:
 * 
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.

    Follow up: Could you do this in one pass?
 */

/**
 * Approach: 
 * 1. First travel from start upto n steps
 * 2. Now left over part of LinkedList is length - n
 * 3. Once previous iteration is done, we start new variable from start and keep updating it until left over part is
 *      also completed
 * 4. Now this results to the position where node has to be deleted
 * 5. Just perform classic delete, that's all
 * 
 * Time Complexity = O(N)
 * Space Complexity = O(1)
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head == null || head.next == null)
            return null;
        
        ListNode current = head;
        ListNode nStep = current;
        ListNode prev = current;
        
        for(int i=1; i<=n; i++) {
            nStep = nStep.next;
        }
        
        if(nStep == null)
            return prev.next;
        
        while(nStep != null) {
            prev = current;
            current = current.next;
            nStep = nStep.next;
        }
        
        prev.next = prev.next.next;
        
        return head;
    }
}