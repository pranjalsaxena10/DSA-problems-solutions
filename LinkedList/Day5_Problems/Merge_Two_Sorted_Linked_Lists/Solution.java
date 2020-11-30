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
class ListNode {
  int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

/**
 * https://leetcode.com/problems/merge-two-sorted-lists/
 * 
 * Problem:
 * Merge two sorted linked lists and return it as a new sorted list. The new list should be made by splicing together the nodes of the first two lists.

    Example 1:
    Input: l1 = [1,2,4], l2 = [1,3,4]
    Output: [1,1,2,3,4,4]
 */

/**
 * Approach: Similar to merge in MergeSort
 * Time Complexity: O(N)
 * Space Complexity: O(1)
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null)
            return null;
        
        if(l1 == null)
            return l2;
        
        if(l2 == null)
            return l1;
        
        ListNode first = l1;
        ListNode second = l2;
        ListNode mergedNode = null;
        
        if(first.val<second.val) {
            
            mergedNode = first;
            first = first.next;
            
        } else {
            
            mergedNode = second;
            second = second.next;
        
        }
        
        ListNode tempNode = mergedNode;
        
        while(first != null && second != null) {
            
            int value = 0;
            
            if(first.val <= second.val) {
                
                tempNode.next = first;
                first = first.next;
                
            } else {
            
                tempNode.next = second;
                second = second.next;
                
            }
            
            tempNode = tempNode.next;
            
        }
        
        while(first!=null) {
            
            tempNode.next = first;
            tempNode = tempNode.next;
            first = first.next;
            
        }
        
        while(second!=null) {
            
            tempNode.next = second;
            tempNode = tempNode.next;
            second = second.next;
        }
        
        return mergedNode;
    }
    
}