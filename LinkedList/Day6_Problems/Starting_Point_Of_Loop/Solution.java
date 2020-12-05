/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/**
 * https://leetcode.com/problems/linked-list-cycle-ii/
 * 
 * Problem: 
 * 
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

    There is a cycle in a linked list if there is some node in the list that can be reached again 
    by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.

    Notice that you should not modify the linked list
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null)
            return null;
        
        ListNode fast = head, slow = head;
        
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            
            if(fast == slow) {
                break;
            }
        }
        
        if(slow != fast) {
            return null;
        }
        slow = head;
        
        while(fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }
        
        return slow;
    }
}