package com.personal.leetcode.twoPointers;

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

    public class ListNode {
         int val;
         ListNode next;
         ListNode() {}
         ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }
    public ListNode deleteDuplicates(ListNode head) {
       
        // sentinel
        ListNode sentinel = new ListNode(0, head);
        
        ListNode pred = sentinel;
        
        while(head != null) {
            
            if(head.next != null && head.val == head.next.val) {
                //move till the end of duplicated sublist
                while(head.next != null && head.val == head.next.val) {
                    head = head.next;
                }
                
                // skip all duplicates
                pred.next = head.next;
                
            }else { // move predecessor
                pred = pred.next;
            }
            
            // move forward
             head = head.next;
        }
        
        return sentinel.next;
    }
}