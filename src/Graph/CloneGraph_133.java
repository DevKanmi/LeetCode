package Graph;

/*
TC: O(v + E)  we get to visit every node and edge just once and perform a o(1) check from the hashmap
SC: O(N) → recursion stack (DFS) or queue (BFS) + map storage.

Approach :
Think about copying one node, you make a new node with the same value, But then… what about its neighbors?

Each neighbor must also be cloned, but their neighbors too, and so on.
⚠️ Problem: If we just keep creating new nodes without tracking, we’ll end up in an infinite loop
 (since graphs have cycles).
✅ Solution: We need a map (hashmap) to remember (TO AVOID INFINITE LOOP):
For each original node, what’s the corresponding cloned node?
This way:
If we encounter the same node again → we don’t re-clone, we just return the already cloned node.

 */

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

import java.util.HashMap;
import java.util.Map;

class Solution {

    //Our visited map
    private Map<Node, Node> visited = new HashMap<>();


    public Node CloneGraph_133(Node node) {
        if(node == null) return node;

        //Check if we have visited a particular node before, we have unique values so if we are just return that particular node, we do this to avoid cycles in a graph.
        if(visited.containsKey(node)) {
            return visited.get(node);
        }

        //Add a node and its clone to the visited map
        Node clone = new Node(node.val);
        visited.put(node, clone);

        //Building the neighbours of the cloned node using the original node neighbours
        for(Node n : node.neighbors){
            clone.neighbors.add(cloneGraph(n));
        }

        return clone;

    }
}