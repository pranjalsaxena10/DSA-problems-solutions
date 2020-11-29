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
 * https://leetcode.com/problems/reverse-linked-list/
 * 
 * Problem :
 * 
 * Reverse a singly linked list.

    Example:

    Input: 1->2->3->4->5->NULL
    Output: 5->4->3->2->1->NULL
 */


/**
 * Approach: Both recursive and iterative approach is here
 * 
 */

class Solution {
    public ListNode reverseList(ListNode head) {
        // return reverseListUtil(head, null);
        
        return reverseListIterativeUtil(head);
    }
    
    ListNode reverseListUtil(ListNode head, ListNode prev) {
        if(head == null)
            return prev;
        
        ListNode nextNode = head.next;
        head.next = prev;
        
        return reverseListUtil(nextNode, head);
    }
    
    ListNode reverseListIterativeUtil(ListNode head) {
        ListNode previous = null;
        ListNode temp = head;
        
        while(temp != null) {
            ListNode nextNode = temp.next;
            temp.next = previous;
            previous = temp;
            temp = nextNode;
            
        }
        
        return previous;
    }
}