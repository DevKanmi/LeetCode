package Graph;

/*
TC => o(n) + o(2E) why? the queue will run n times and each node would visit its edges at most 2E
SC => o(n) for queue o(n) for list and o(n) for visited array => o(3n) 3 is negligible so o(n)

Step
1. Create the queue with a starting element
2. create an array that checks if that element has been visited before adding it to the queue
3. for each node we pass into the queue, we run a loop that checks for it neigbours, confirm if they are not
visited then add them to our queue.
4. we remove the node at front each time as the loop is done.
5. we are done when the queue becomes empty
6. THIS VISITED ARRAY IS IMPORTANT IT HELPS US KNOW WHEN WE ALREADY VISITED A NODE THAT IS IF THE NODE IS THE NEIGBHOUR
TO PROBABLY ANOTHER NODE IN THE GRAPH

BFS IS ALL ABOUT GOING WIDE MEANING AT A NODE WE ARE CHECKING THE NEIGHBOURS, WE MOVE TO THE NEXT NODE CHECK THE
NEIGBOURS AND SO ON
 */

public class bfs {
        // Function to return Breadth First Search Traversal of given graph.
        public ArrayList<Integer> bfs(ArrayList<ArrayList<Integer>> adj) {
            boolean[] visited = new boolean[adj.size()];
            visited[0] = true;
            Queue<Integer> q = new LinkedList<Integer>();
            ArrayList<Integer> list = new ArrayList<Integer>();
            q.offer(0);

            while(!q.isEmpty()){
                int node = q.poll();
                list.add(node);

                for(int i : adj.get(node)){
                    if(!visited[i]){
                        q.offer(i);
                        visited[i] = true;
                    }
                }
            }
            return list;
        }
    }
