package Graph;

/*
Link: https://leetcode.com/problems/rotting-oranges/
Difficulty: Medium
TC: O(N * M)
SC: O(N * M)

Algo:

 */

class Pair {
    int row;
    int col;
    int tm;

    public Pair(int row, int col, int tm) {
        this.row = row;
        this.col = col;
        this.tm = tm;
    }
}

public class RottingOranges_994 {
    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<Pair> q = new LinkedList<>();
        int[][] visited = new int[n][m];

        int cntfresh = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new Pair(i, j, 0));
                    visited[i][j] = 2;
                } else {
                    visited[i][j] = 0;
                }
                if (grid[i][j] == 1)
                    cntfresh++;
            }
        }

        int tm = 0;
        int drow[] = { 0, +1, 0, -1 };
        int dcol[] = { +1, 0, -1, 0 };
        int cnt = 0;

        while (!q.isEmpty()) {
            int r = q.peek().row;
            int c = q.peek().col;
            int t = q.peek().tm;
            tm = Math.max(t, tm);
            q.poll();

            for (int k = 0; k < 4; k++) {
                int nrow = r + drow[k];
                int ncol = c + dcol[k];
                if (nrow >= 0 && ncol >= 0 && nrow < n && ncol < m && visited[nrow][ncol] == 0
                        && grid[nrow][ncol] == 1) {
                    q.offer(new Pair(nrow, ncol, t + 1));
                    visited[nrow][ncol] = 2;
                    cnt++;
                }
            }
        }

        if (cnt != cntfresh)
            return -1;

        return tm;
    }
}
