package Trees;
class Node {
    int data;
    Node left;
    Node right;

    // Constructor to initialize
    // a node with a given key
    public Node(int key){
        data = key;
        left = null;
        right = null;
    }
}
public class TreeDef {
    public static void main(String[] args) {

        Node root = new Node(1);

        root.left = new Node(2);
        root.right = new Node(3);
        root.left.right = new Node(4);

    }
}
