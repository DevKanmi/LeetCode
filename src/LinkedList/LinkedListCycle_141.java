package LinkedList;

/*
Link : https://leetcode.com/problems/linked-list-cycle/description/
Difficulty: Easy
 */

class ListNode{
    int data;
    ListNode next;

    ListNode(int data1, ListNode next1){
        this.data = data1;
        this.next = next1;
    }

    ListNode(int data1){
        this.data = data1;
        this.next = null;
    }
}

public class LinkedListCycle_141 {
    public boolean hasCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) return true;
        }
        return false;
    }
}
