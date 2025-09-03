package BackTracking;

/*
TC: o(m * n * 4^L) (branching up to 4 directions per step).
SC: o(L) recursion depth (plus constant grid mutation).

Approach: we want to search for a word in a grid
things to note:
1. We can only use one cell, no reusing of cell, we solve that by mutating the cell we visit and if done we undo it
2. we can only move up, down left or right, we can do that by using normal dfs
3. we backtrack when we mark as visit and unmark (the idea of take and don't take, concept behind backtracking)
4. the word start can be anywhere on the grid not necessarily at the beginning.

 */

public class WordSearch_79 {
        private int m, n;
        private char[][] board;
        private String word;

        public boolean exist(char[][] board, String word) {
            //this.variables always means we are referring to the class variable
            this.m = board.length;
            this.n = board[0].length;
            this.board = board;
            this.word = word;

            for(int i = 0; i < m; i++){
                for(int j = 0; j < n; j++){
                    if(dfs(i, j, 0)) return true;
                }
            }

            return false;
        }

        private boolean dfs(int r, int c, int k){

            //Base case there are 2 base cases, one if we reach the word length and second if out of bounds or not same
            if(k == word.length()) return true;

            if( r < 0 || r >= m || c < 0 || c >= n || board[r][c] != word.charAt(k)){
                return false;
            }

            //Mark word as visited *TAKE*
            char vis = board[r][c]; // Store in temp var incase we need to univist if isFound is false so we can reuse
            board[r][c] = '#';

            boolean isFound = dfs(r + 1, c, k + 1)
                    || dfs(r - 1, c, k + 1)
                    || dfs(r, c + 1, k + 1)
                    || dfs(r, c - 1, k+ 1);


            //Mark as unvisited incase found is false, so it does not affect us in other paths *DON'T TAKE*
            board[r][c] = vis;

            return isFound;
        }
    }
