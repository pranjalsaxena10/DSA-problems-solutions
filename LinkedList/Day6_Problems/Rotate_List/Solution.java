/**
 * https://leetcode.com/problems/rotate-list/
 * 
 * Problem: 
 * 
 * Given the head of a linked list, rotate the list to the right by k places.
 * 
 * Input: head = [1,2,3,4,5], k = 2
    Output: [4,5,1,2,3]

    Input: head = [0,1,2], k = 4
    Output: [2,0,1]
 */

/**
 * Approach:
 * Right rotation by k places means finding (k%size)th node from end of LinkedList 
 * and making that node as new header and last node of LinkedList will now point to original header
 * Previous node of (k%size)th node from end of LinkedList will be having next parameter as null 
 * and will now be the last node of rotated LinkedList
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */

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
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null)
            return head;
        
        /**
        *   for size calculation
        */
        
        int size = 0;
        ListNode tempNode = head;
        
        while(tempNode != null) {
            size++;
            tempNode = tempNode.next; 
        }
        
        /**
        *   Right rotation by k places means finding (k%size)th node from end of LinkedList 
        *   and making that node as new header and last node of LinkedList will now point to previous header
        *   Previous node of (k%size)th node from end of LinkedList will be having next parameter as null 
        *   and will now be the last node of rotated LinkedList
        */
        
        int positionFromEnd = k % size;
        
        if(positionFromEnd == 0)
            return head;
        
        tempNode = head;
        
        for(int i=1; i<=positionFromEnd; i++) {
            tempNode = tempNode.next;
        }
        
        ListNode newHead = head;
        ListNode prevNode = null;
        
        while(tempNode != null) {
            prevNode = newHead;
            newHead = newHead.next;
            tempNode = tempNode.next;
        }
        
        prevNode.next = null;
        
        tempNode = newHead;
        
        while(tempNode.next != null) {
            tempNode = tempNode.next;
        }
        
        tempNode.next = head;
        
        return newHead;
    }
}