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
 * https://leetcode.com/problems/reverse-nodes-in-k-group/
 * 
 * Problem:
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

    k is a positive integer and is less than or equal to the length of the linked list. 
    If the number of nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.

    Input: head = [1,2,3,4,5], k = 3
    Output: [3,2,1,4,5]
    
    Input: head = [1,2,3,4,5], k = 2
    Output: [2,1,4,3,5]
 */

/**
 * Approach: 
 * 1. First check if k is 1 then retun head
 * 2. Calculate size if it k>size then return head
 * 3. Iterate for k times first and then reverse iterated List
 * 
 * Time Complexity: O(N) => Linear
 * Space Complexity: O(1)
 */

class Solution {
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || k == 1)
            return head;
            
        ListNode tempNode = head;
        int size = 0;
        
        while(tempNode != null) {
            size++;
            tempNode = tempNode.next;
        }
        
        if(k>size)
            return head;
        
        ListNode newHead = reverseInGroups(head, k); 
            
        return newHead;
    }
    
    private ListNode reverseInGroups(ListNode head, int k) {
        if(head == null)
            return head;
        
        int i=1;
        
        ListNode tempNode = head;
        ListNode previousHead = head;
        
        while(tempNode != null && i<=k) {
            tempNode = tempNode.next;
            i++;
        }
        
        if(tempNode == null && i<=k) {
            return head;
        }
        
        ListNode reversedNode = reverse(head, k);
        previousHead.next = reverseInGroups(tempNode, k);
        
        return reversedNode;
        
    }
    
    private ListNode reverse(ListNode node, int range) {
        ListNode prevNode = null;
    
        ListNode current = node;
        ListNode nextNode = node;
        int j=1;
        
        while(current != null && j<=range) {
            
            nextNode = current.next;
            current.next = prevNode;
            prevNode = current;
            current = nextNode;
            j++;
        }
        
        return prevNode;
    
    }
}