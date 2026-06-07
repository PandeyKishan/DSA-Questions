import java.util.*;

class Solution {
    // Function to set entire row and column to 0 if an element in the matrix 
    public int[][] rotateMatrixOptimal(int[][] matrix) {
        int[][] transposed = transpose(matrix);

        int transposeRow = transposed.length;
        int transposeCol = transposed[0].length;

        // Process each row independently - reverse each row
        for (int i = 0; i < transposeRow; i++) {
            int left = 0;
            int right = transposeCol - 1;

            // Reverse the elements within the current row
            while (left < right) {
                int temp = transposed[i][left];
                transposed[i][left] = transposed[i][right];
                transposed[i][right] = temp;

                // Move pointers toward the center
                left++;
                right--;
            }
        }
        return transposed;
    }

    public int[][] transpose(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        if(m == n) {
            for(int i = 0; i < m; i++) {
                for(int j = i; j < n; j++) {
                    swap(matrix, i, j);
                }
            }
        } else {
            int[][] transposed = new int[n][m];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    transposed[j][i] = matrix[i][j];
                }
            }
            return transposed;    
        }    
        return matrix;
    }

    public void swap(int[][] matrix, int i, int j) {
        int temp = matrix[i][j];
        matrix[i][j] = matrix[j][i]; 
        matrix[j][i] = temp;
    }
}

public class rotateMatrixBy90 {
    public static void main(String[] args) {
        // Example matrix
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        // int[][] matrix = {{0, 1, 1, 2}, {2, 0, 3, 1}, {4, 5, 0, 5}, {5, 6, 7, 0}};
        
        // Create Solution object
        Solution sol = new Solution();


        // System.out.println("\nTranspose of matrix: ");

        // int[][] result = sol.transpose(matrix);

        System.out.println("\nOptimal Solution: ");

        int[][] result = sol.rotateMatrixOptimal(matrix);
        
        // Print result
        for (int[] row : result) {
            for (int val : row) {
                System.out.print(val + " ");
            }
            System.out.println();
        }
    }

    //   0 1 2
    // 0 1,2,3
    // 1 4,5,6
    // 2 7,8,9

    //   1,2,3     1,4
    //   4,5,6     2,5
}   //             3,6  

// [row][0] -> [0][?]
// [row][1] -> [1][?]
// [row][2] -> [2][?]