package LinkedList;
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

// https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList_206 {
    public ListNode reverseList(ListNode head) {
        ListNode reverse = null;
        ListNode current = head;

        while(current != null){
            ListNode temp = current.next;
            current.next = reverse;
            reverse = current;
            current = temp;


        }

        return reverse;
    }
}
