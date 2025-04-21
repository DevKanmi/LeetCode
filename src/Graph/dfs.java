package Graph;

/*
STEPS:
1. create a visited array to check nodes that have been visited to not allow them to be added multiple times
2. Idea is basic use of recursion we have a starting node and we have neigbhours in the adj list, so for each neigbhour
we run a dfs till we get to we are done with the loop then we continue to the second neigbour run a dfs till each
node is visited

DFS IS MORE ABOUT HOW DEEP EACH NEIGHBOUR OF A NODE GOES COMPARES TO HOW WIDE, SO WE PICK A NODE GO ALL THE WAY IN TILL
WE REACH AN ALREADY VISITED NODE OR TRAVERSE THROUGH IT ALL THEN WE CAN RETURN.

TC => O(N) + O(2E) UNDIRECTED
DIRECTED O(E) DEPENDS ON NUMBER OF EDGES

SC => O(N) + O(N0 + 0(N) => 0(N)
 */

public class dfs {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfs(ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        boolean[] visited = new boolean[adj.size()];

        dfs(0, visited, list, adj);

        return list;

    }

    private void dfs(int node, boolean[] visited, List<Integer> list, ArrayList<ArrayList<Integer>> adj){
        visited[node] = true;
        list.add(node);

        for(int i : adj.get(node)){
            if(!visited[i]){
                dfs(i, visited, list, adj);
            }
        }
    }
}
