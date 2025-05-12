package Graph;

/*
Link: https://neetcode.io/problems/islands-and-treasure || https://leetcode.com/problems/walls-and-gates/description/
Approach: We are making use of multi-source bfs in this approach, so basically we are going to traverse through the
grid add all gates to our queue and initialize them with 0, so the start and we traverse level by level at each level we
are keeping track of the distance we have found so far and putting that in our Pair object, so the first for loop is to
run each level so that guarantees that each level that we are the INF is getting the closest gate to it, the second
for loop is for checking the sides of the particular cell we are currently at to check if there are other empty rooms
around it.

Time complexity: o(m * n)
space complexity: o(m * n)
 */
class Pair{
    int r;
    int c;
    int d;

    Pair(int r, int c, int d){
        this.r = r;
        this.c = c;
        this.d = d;
    }
}

class Solution {
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        int n = rooms[0].length;
        Queue<Pair> q = new LinkedList<>();

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(rooms[i][j] == 0){
                    //add gates to the queue level 1
                    q.offer(new Pair(i, j, 0));
                }
            }
        }
        int[] drow = { 1, 0, -1, 0};
        int[] dcol = { 0, -1, 0, 1};
        while(!q.isEmpty()){
            int currSize = q.size();
            // ensures each level is traversed first before the next level is gotten to.
            for(int i = 0; i < currSize; i++){
                int row = q.peek().r;
                int col = q.peek().c;
                int dist = q.peek().d + 1;
                q.poll();

                for(int k = 0; k < 4; k++){
                    int nrow = row + drow[k];
                    int ncol = col + dcol[k];

                    if(nrow >= 0 && ncol >= 0 && nrow < m && ncol < n && rooms[nrow][ncol] == Integer.MAX_VALUE){
                        q.add(new Pair(nrow, ncol, dist));
                        rooms[nrow][ncol] = dist;
                    }
                }
            }
        }
    }
}
