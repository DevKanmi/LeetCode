package Graph;

import java.util.ArrayList;
import java.util.List;

/*
TC: O( n + edges)
SC: O(n + edges)

Intuition
The graph may not be connected. We need to explore all nodes and group them into connected clusters.
Every time we start a DFS/BFS from an unvisited node, we discover a new component.

So the answer is simply:
Number of times we launch a new DFS = number of connected components.
we have a count variable to keep track of the number of times we launch a new dfs

 */
public class NumberOfConnectedComponentsInAnUndirectedGraph_323 {
        private int[][] edges;
        private int r, c;
        public int countComponents(int n, int[][] edges) {
            //If we have an empty edges it means each node n has no edge and thereby they exist as independent components
            //So just return the number of nodes and no of components in that graph
            if(edges.length == 0) return n;
            this.edges = edges;
            this.r = edges.length;
            this.c = edges[0].length;

            List<List<Integer>> graph = new ArrayList<>();

            for(int i =0; i < n; i++) graph.add(i, new ArrayList<>());

            //Fill the Adjacency list
            for(int[] edge : edges){
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }

            int count = 0;
            boolean[] vis = new boolean[n];

            /*
            So here we are checking each node and its neighbours and performing a dfs from the node to where it reaches
            so now if we return back to this for loop, we expect the nodes that it should have visited to be true, so
            if a node is not visited it means it was not part of that component, and it exists alone so now again we
            perform a dfs on that particular nodes till it visits all the neighbours, and we just increment count after
            each component we return from.
             */
            for(int i = 0; i < n; i++){
                if(!vis[i]){
                    dfs(graph, i, vis);
                    count++;
                }
            }
            return count;
        }

        //Normal dfs procedure
        private void dfs(List<List<Integer>> graph , int i, boolean[] vis){
            if(vis[i]) return;
            vis[i] = true;

            for(int k : graph.get(i)){
                dfs(graph, k, vis);
            }
        }
    }

