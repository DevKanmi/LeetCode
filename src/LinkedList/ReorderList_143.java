package LinkedList;



 /* class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  } */


public class ReorderList_143 {
    public void reorderList(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;

        //Find the Middle node to divide the list
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }

        //Reverse Second half
        ListNode list2 = slow.next;
        ListNode prev = slow.next = null;

        while(list2 != null){
            ListNode temp = list2.next;
            list2.next = prev;
            prev = list2;
            list2 = temp;
        }

        //Merge the list
        ListNode list1 = head;
        list2 = prev;
        while(list2 != null){
            ListNode temp1 = list1.next;
            ListNode temp2 = list2.next;
            list1.next = list2;
            list2.next = temp1;
            list1 = temp1;
            list2 = temp2;
        }

    }
}
