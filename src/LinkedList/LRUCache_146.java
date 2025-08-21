package LinkedList;

import java.util.HashMap;

/*
The trick to solving this question is the use of a map to get in 0(1) and the use of a DLL to help put in 0(1), and
in LRU to put a node we simply just remove a node at the tail which is the currently recently used node and the update
the head to add that new node, so we need 2 functions deleteNode and addToHead, those 2 functions is what we use to
manipulate the Linkedlist and the get and put function in our design of the LRU.
 */
class ListNode{
    int key, val;
    ListNode prev, next;
    ListNode(int key, int val){
        this.key = key;
        this.val = val;
    }
}

public class LRUCache_146 {
    HashMap<Integer, ListNode> map = new HashMap<>();
    ListNode head = new ListNode(-1, -1);
    ListNode tail = new ListNode(-1,-1);
    int capacity;

    public LRUCache_146(int capacity){
        this.capacity = capacity;
        head.next = tail;
        tail.prev = head;

    }

    public int get(int key){
            if(!map.containsKey(key)) return key;
            ListNode node = map.get(key);
            deletNode(node);
            addToHead(node);

            return node.val;
    }

    public void put(int key, int value){

        if(map.containsKey(key)){
            ListNode node = map.get(key);
            node.val = value;
            deletNode(node);
            addToHead(node);
        }

        else{
            if(map.size() == capacity){
                ListNode removeLRUNode = tail.prev;
                map.remove(removeLRUNode.key);
                deletNode(removeLRUNode);
            }

            ListNode node = new ListNode(key, value);
            addToHead(node);
            map.put(key, node);
        }

    }

    public void deletNode(ListNode node){
        ListNode temp1 = node.next;
        ListNode temp2 = node.prev;

        temp1.prev= temp2;
        temp2.next = temp1;
    }

    public void addToHead(ListNode node){
        ListNode temp1 = head.next;
        node.next = temp1;
        temp1.prev = node;
        head.next = node;
        node.prev = head;
    }
}
