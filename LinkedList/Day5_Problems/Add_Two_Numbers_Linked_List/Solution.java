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
 * https://leetcode.com/problems/add-two-numbers/
 * 
 * Problem: 
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.

    You may assume the two numbers do not contain any leading zero, except the number 0 itself.

    Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    Output: [8,9,9,9,0,0,0,1]
 */

/**
 * Approach:
 * 
 * 1. At each value of node in either list do sum of both values if non null
 * 2. Update sum with carry which will be initialized to 0 initially
 * 3. Create newNode for sum % 10 and add it to new LinkedList
 * 4. Update carry to sum / 10.
 * 
 * Time Complexity = O(n)
 * Space Complexity = O(1)
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode answerNode = new ListNode();
        
        ListNode tempNode = answerNode;
        
        int carry = 0;
        
        while(l1 != null || l2 != null || carry != 0) {
            int tempSum = 0;
            
            if(l1 != null) {
                tempSum += l1.val;
                l1 = l1.next;
            }
            
            if(l2 != null) {
                tempSum += l2.val;
                l2 = l2.next;
            }
            
            tempSum += carry;
            
            ListNode newNode = new ListNode(tempSum%10);
            carry = tempSum / 10;
            tempNode.next = newNode;
            tempNode = tempNode.next;
            
        }
        
        return answerNode.next;
    }
}