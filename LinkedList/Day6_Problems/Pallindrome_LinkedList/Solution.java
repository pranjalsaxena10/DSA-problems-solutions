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
 * https://leetcode.com/problems/palindrome-linked-list/
 * 
 * Problem: 
 * 
 * Given a singly linked list, determine if it is a palindrome.
 * 
 * Example 1:

    Input: 1->2
    Output: false
    
    Example 2:

    Input: 1->2->2->1
    Output: true
 */

/**
 * Approach:
 * 
 * 1. Find middle of List
 * 2. Reverse the second half
 * 3. Compare two halves
 * 
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */

class Solution {
    public boolean isPalindrome(ListNode head) {
        
        ListNode middleNode = middleOfLinkedList(head);
        ListNode reversedNode = reverse(middleNode);
        
        ListNode firstHalf = head;
        ListNode secondHalf = reversedNode;
        
        while(secondHalf != null) {
            
            if(firstHalf.val != secondHalf.val)
                return false;
            
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
            
        }
        
        return true;
    }
    
    private ListNode middleOfLinkedList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        
        ListNode prev = null;
        ListNode tempNode = head;
        ListNode nextNode = head;
        
        while(tempNode != null) {
            nextNode = tempNode.next;
            tempNode.next = prev;
            prev = tempNode;
            tempNode = nextNode;
        }
        
        return prev;
    }
}