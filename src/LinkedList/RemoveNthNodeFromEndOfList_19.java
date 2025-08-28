package LinkedList;

/*
Approach: the idea behind this question is the use of 2 pointers to create a gap, so in our first brute force
approach of o( 2 * len) we simple run a first traversal and count the nodes in a list and the we subtract it from the
nth node we are looking to remove and we find out that the value we get is the node before that node we want to
remove so what we simply now do is run another traversal that will not keep reducing the res == 0 and then at o we now
take the point the prev node.next - node.next.next now we can optimize this cause we notice that if we have a fast pointer
that we can move n times forward and we now start moving both the slow and fast after doing that, we end up with the slow
pointer being at the previous node when the fast is null and we can simply just move the slow.next = slow.next.next,
now before that we check an edge case of if at the end of the first for loop fast == null it means we are to remove the
first node and we can simply return head.next if not we have a while loop of (fast.next != null) move at same pace,,
we can also make us of a dummy node but if we do we get to move fast by n + 1 times.

the tc - o(len of list) because the fast is moved in the for loop n times and in the while loop len of list - n times
sc - 0(1) no additional space is created.
 */
public class RemoveNthNodeFromEndOfList_19 {
    public ListNode RemoveNthFromEndOfList(ListNode head, int n) {

        ListNode fast = head;
        ListNode slow = head;

        for(int i = 0;  i < n; i++){
            fast = fast.next;
        }

        if(fast == null){
            return head.next;
        }

        while( fast.next != null){
            slow = slow.next;
            fast = fast.next;
        }

        slow.next = slow.next.next;
        return head;
    }
}
