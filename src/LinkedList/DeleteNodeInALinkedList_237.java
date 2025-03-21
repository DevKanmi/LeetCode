package LinkedList;

/*
Link: https://leetcode.com/problems/delete-node-in-a-linked-list/
Difficulty: Medium

Approach: this is not the conventional deleting a node, initially what would come to mind is keeping track of the prev
node and if I see the node I want to delete I just update the prev.next -> node.next and the node is taken
out but here we were not given the head of the node, and we did not know what te previous node was

What can we do?
we know what the nodes in front are right, so we could duplicate the node directly in front of the node we want
to delete, what do I mean?
 eg 1->3->5->6->8->10->15, node to delete is 8
 what i can do is replace that node.val with what the val of the node in front
  1->3->5->6->(10)->10->15, In a way we have gotten rid of the node we want to delete sort of but we now have duplicates
   nodes, we now do a smart thing, we now say that the node should point 2 times so node.next.next, so it gets rid
   of the duplicate node and at the same time we have gotten rid of 8
   Output => 1->3->5->6->(10)->15

 */


//Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
 }



public class DeleteNodeInALinkedList_237 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

}
