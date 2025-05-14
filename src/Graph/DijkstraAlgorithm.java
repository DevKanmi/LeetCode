package Graph;

import java.util.List;
import java.util.PriorityQueue;

class Pair {
    int distance;
    int node;

    public Pair(int distance, int node){
        this.distance = distance;
        this.node = node;
    }
}

public class DijkstraAlgorithm {

    private static int[] dijkstra(int V, List<List<List<Integer>>>  adj, int S){

        //Min- heap
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.distance - y.distance);

        int[] dist = new int[V];
        for(int i = 0; i < V; i++) dist[i] = (int)(1e9);

        dist[S] = 0;
        pq.offer(new Pair(0, S));
        while(!pq.isEmpty()){
            int dis = pq.peek().distance;
            int node = pq.peek().node;
            pq.poll();

            for(int i =0; i < adj.get(node).size(); i++){
                int edgeWeight = adj.get(node).get(i).get(1);
                int adjNode = adj.get(node).get(i).get(0);

                if(dis + edgeWeight < dist[adjNode]){
                    dist[adjNode] = dis + edgeWeight;
                    pq.add(new Pair(dist[adjNode], adjNode));
                }
            }
        }
     return dist;
    }
}
