/**
 * https://leetcode.com/problems/intersection-of-two-linked-lists/
 * 
 * Problem: 
 * Write a program to find the node at which the intersection of two singly linked lists begins.

    For example, the following two linked lists:
    Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
    Output: Reference of the node with value = 8
    Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect).
    From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,6,1,8,4,5]. 
    There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 */

/**
 * Approach: 
 * 1. Check if headA and headB are equal if it is the case then headA
 * 2. Calculate lengthA and lengthB for both Lists
 * 3. Iterate in the longer list upto diff of length of lists
 * 4. Check when both list variables point to same location
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        
        if(headA == headB)
            return headA;
        
        int lengthA = 0;
        int lengthB = 0;
        
        ListNode tempA = headA;
        ListNode tempB = headB;
        
        while(tempA != null || tempB != null) {
            
            if(tempA != null) {
                lengthA++;
                tempA = tempA.next;    
            }
            
            if(tempB != null) {
                lengthB++;
                tempB = tempB.next;
            }
            
        }
        
        tempA = headA;
        tempB = headB;
        
        if(lengthA > lengthB) {
            
            int count = 1;
            
            while(count++ <= (lengthA - lengthB)) {
                tempA = tempA.next;
            }
            
        } else 
            if(lengthB > lengthA) {
                
                int count = 1;
            
                while(count++ <= (lengthB - lengthA)) {
                    tempB = tempB.next;
                }
                
            }
        
        if(tempA == tempB)
            return tempA;
        
        boolean intersectionFound = false;
        
        while(tempA != null && tempB != null) {
            
            if(tempA.next == tempB.next) {
                intersectionFound = true;
                break;
            }
            
            tempA = tempA.next;
            tempB = tempB.next;
            
        }
        
        if(intersectionFound)
            return tempA.next;
        else 
            return null;
    }
}