package Arrays;

/*
TC: o(n * n) (no of rows * no of columns) => o(n^2); => Each element is only visited once
SC : o(1) => No additional data structure was required to solve it.

Approach : The first one is swapping the edges appropriately, then shrink them;
2nd is the use of Matrix properties
    => Step 1 is to transpose it : swapping rows and columns
    => Step 2 is to reverse the matrix : Swap the first column with the last and shrink the boundaries
 */

public class RotateImage_48 {
    public void rotate(int[][] matrix) {
        int m = matrix.length;

        //Transpose the matrix -> Turning each row to column;
        for(int i = 0; i < m; i++){
            for(int j = i + 1; j < m; j++){
                int temp = matrix[j][i];
                matrix[j][i] = matrix[i][j];
                matrix[i][j] = temp;
            }
        }

        //Reverse the matrix  -> Swap the first and last increase rb and decrease lb(right bound and left bound)
        int rb = 0, lb = m - 1;

        while(rb < lb){
            int i = 0;
            while(i < m){
                int temp = matrix[i][rb];
                matrix[i][rb] = matrix[i][lb];
                matrix[i][lb] = temp;
                i++;
            }

            rb++;
            lb--;
        }
}
