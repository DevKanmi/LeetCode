package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/*
TC: O(v + e)
SC: O(v + e)

Intuition:
A tree with n nodes must have n-1 edges (add one edge per new node).
So:
If edges ≠ n-1 → immediately false.
If edges = n-1, then no cycles + connectivity are equivalent; check either:
Do a DFS from node 0: if you visit all nodes without finding a back-edge (cycle), it’s a tree.

Approach
1) DFS(graph traversal)
Build adjacency list.
Quick check: edges.length == n-1. If not, return false.
DFS from 0, track visited.
For DFS, pass parent to avoid falsely flagging the immediate back edge(so if the node we are is currently the parent
of that node continue to next element in the list).
If you try to revisit a node that isn’t your parent → cycle → false.
After traversal, ensure all n nodes visited are true means they are connected else it is false.
 */

class GraphValidTree_261 {
    public boolean validTree(int n, int[][] edges) {

        /*
            For a graph to be a valid tree it must follow the 3 conditions
            1. edges.length == n - 1
            2. No cycle in that graph
            3. ALl nodes must be visited, meaning our visited array must be true for
            all elements after the dfs has completed.
        */

        if(edges.length != n -1) return false;

        HashMap<Integer, List<Integer>> map = new HashMap<>(); // We could have used a list where the index is the node and neihgbours is the arraylist
        for(int i = 0; i < n; i++) map.put(i, new ArrayList<>());

        for(int[] edge : edges){
            map.get(edge[0]).add(edge[1]);
            map.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[n];

        if(hasCycle(map,0, -1, vis)) return false;

        //Check if connected
        for(boolean v : vis){
            if(!v) return false;
        }

        return true;
    }

    private boolean hasCycle(HashMap<Integer, List<Integer>> map, int node, int parent, boolean[] vis){
        if(vis[node]) return true;

        vis[node] = true;

        for(int i : map.get(node)){
            //Skip parent
            if(i == parent) continue;
            if(hasCycle(map, i, node, vis)) return true;
        }

        return false;
    }
}
