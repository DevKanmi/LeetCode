package LinkedList;
/*
This is an Implementation of Doubly Linked List in Java
1. Setup the Node for a doubly linkedList containing the data and then the back and next pointer
2. Conversion of an array to a DLL
3. Deletion of a Node
    a. at Head.
    b. at Tail.
    c. at the Kth Index.
    d. A particular node
 */
class Node{
    int data;
    Node next;
    Node back;

    Node(int data1, Node next1, Node back1){
        this.data = data1;
        this.next = next1;
        this.back = back1;
    }

    Node(int data1){
        this.data = data1;
        this.next = null;
        this.back = null;
    }
}
public class DoublyLinkedList {
    private static void print(Node head){
        while(head != null){
            System.out.print(head.data + " ");
            head = head.next;
        }

        System.out.println();
    }
    private static Node convertArrayToDLL(int[] arr){
         Node head = new Node(arr[0]);
         Node prev = head;

         for(int i = 1; i< arr.length; i++){
             Node temp = new Node(arr[i], null, prev);
             prev.next = temp;
             prev = temp;
         }

         return head;
    }

    private static Node DeleteHead(Node head){
        if(head == null || head.next == null){
            return null;
        }

        Node prev = head;
        head = head.next;
        head.back = null;
        prev.next = null;

        return head;
    }

    private static Node DeleteTail(Node head){

        if(head == null || head.next == null){
            return null;
        }

        Node tail = head;

        while(tail.next!= null){
            tail = tail.next;
        }
        Node prev = tail.back;
        prev.next = null;
        tail.back = null;

        return head;
    }

    private static Node deleteKth(Node head, int k){
        if(head == null){
            return null;
        }
        Node temp = head;
        int count = 0;

        while(temp.next != null){
            count++;
            if(count == k) break;
            temp = temp.next;
        }

        Node prev = temp.back;
        Node front = temp.next;

        if(prev == null && front == null){
            return null;
        } else if (prev == null) {
            return DeleteHead(head);
        } else if (front == null) {
            return DeleteTail(head);
        }

        prev.next = front;
        front.back = prev;
        temp.back = null;
        temp.next = null;

        return head;
    }

    private static void deleteNode(Node node){
        Node prev = node.back;
        Node front = node.next;

        if(node.next == null){
            prev.next = null;
            node.back = null;
            return;
        }

        prev.next = front;
        front.back = prev;
        node.next = node.back = null;


    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 6, 9, 7, 2, 4};
        Node head = convertArrayToDLL(arr);
        print(head);

        Node removeKth = deleteKth(head,2);
        print(removeKth);

        Node newTail = DeleteTail(head);
        print(newTail);

        deleteNode(head.next.next);
        print(head);

        Node newHead = DeleteHead(head);
        print(newHead);

    }
}

