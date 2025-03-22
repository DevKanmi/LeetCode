package LinkedList;

/*
Link:
Difficulty:

Approach:
here i made use of a dummy node, important thing to note "IF YOU WOULD NEED TO CREATE A NEW LIST, DUMMY NODE MAKES
THINGS EASIER", so here the idea was two add 2 different nodes of a linkedlist with both not of equal length,
so before we could add a 'node' we had to check if it was null first, which gave me some insights into how linkedlist
do, so we had a carry variable set to 0 and we had a while loop chedking till both nodes were zero,
the thing now was that both were of different length, so while one might have reached the end the other could
still be having nodes, so before we added the values we always had to check if both list nodes were == null
only if they were not null is when we added their values to the sum variable, now after this was done we created a Node
for the sum value and pointed the dummyNode.next to that new node and update the dummyNode to be at that newNode
now before we could move on to each next value in the list we had to check if we are not at the end of any of the list
unless we would get  a null excepton trying to point( null -> another null) now if we are not at null, move on to the
next value in the list till we are done with both list.

at the end we have to take care of the carry that might have been created, to do that we check if carry is set to 1, if
it is we then update the nodes, create a new node of that carry and point the dummy node to the carry node

we return dummy.next and not dummy why?
remember we created a NewNode with dummy not being the true start of the list, the true start of the list we need is
at the next value of dummy, where we started adding.
 */

public class AddTwoNumbers_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sumNode = new ListNode(-1);
        ListNode node1 =  l1;
        ListNode node2 = l2;
        ListNode curr = sumNode;
        int carry = 0;

        while(node1 != null || node2 != null){
            int sum = 0 + carry;
            if(node1 != null) sum = sum + node1.val;
            if(node2 != null) sum = sum + node2.val;

            ListNode newNode = new ListNode(sum % 10);
            carry = sum/10;

            curr.next = newNode;
            curr = curr.next;
            if(node1 != null) node1 = node1.next;
            if(node2 != null) node2 = node2.next;
        }

        if(carry == 1){
            ListNode carryNode = new ListNode(carry);
            curr.next = carryNode;
        }

        return sumNode.next;
    }
}
