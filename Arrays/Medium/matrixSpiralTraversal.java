import java.util.*;

class Solution {
    /**
     * Time Complexity: O(m * n) 
     * Space Complexity: O(1) 
    */
    // Function to set entire row and column to 0 if an element in the matrix 
    public ArrayList<Integer> spiralTraversal(int[][] matrix) {
        // Result list to store the spiral order
        ArrayList result = new ArrayList<>();

        // Initialize boundaries
        int top = 0;                        // Starting row
        int bottom = matrix.length - 1;     // Ending row
        int left = 0;                       // Starting column
        int right = matrix[0].length - 1;   // Ending column

        // Loop until all elements are traversed
        while (top <= bottom && left <= right) {

            // Traverse the top row from left to right
            for (int i = left; i <= right; i++) {
                result.add(matrix[top][i]);
            }
            top++; // Move the top boundary downward

            // Traverse the right column from top to bottom
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // Move the right boundary leftward

            // Traverse the bottom row from right to left (only if rows remain)
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    result.add(matrix[bottom][i]);
                }
                bottom--; // Move the bottom boundary upward
            }

            // Traverse the left column from bottom to top (only if columns remain)
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // Move the left boundary rightward
            }
        }

        // Return the spiral order result
        return result;
    }
}

public class matrixSpiralTraversal {
    public static void main(String[] args) {
        // Example matrix
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        // int[][] matrix = {{0, 1, 1, 2}, {2, 0, 3, 1}, {4, 5, 0, 5}, {5, 6, 7, 0}};
        
        // Create Solution object
        Solution sol = new Solution();

        System.out.println("\nOptimal Solution: ");

        ArrayList<Integer> result = sol.spiralTraversal(matrix);
        
        System.out.println("Array: " + result);
    }
}

/*   C0  C1  C2  C3
   [ 1,  2,  3,  4]  R0
   [ 5,  6,  7,  8]  R1
   [ 9, 10, 11, 12]  R2
   [13, 14, 15, 16]  R3
   [17, 18, 19, 20]  R4

    Initial State
   * top = 0, bottom = 4
   * left = 0, right = 3
   
    ---
   
  Round 1: The Outer Boundary

  1. Top Row (Left to Right)
   * Loop: i from 0 to 3 at matrix[top][i]
   * Elements: 1, 2, 3, 4
   * Update: top = 1

  2. Right Column (Top to Bottom)
   * Loop: i from 1 to 4 at matrix[i][right]
   * Elements: 8, 12, 16, 20
   * Update: right = 2

  3. Bottom Row (Right to Left) — if (top <= bottom) check
   * Check: 1 <= 4? Yes.
   * Loop: i from 2 down to 0 at matrix[bottom][i]
   * Elements: 19, 18, 17
   * Update: bottom = 3

  4. Left Column (Bottom to Top) — if (left <= right) check
   * Check: 0 <= 2? Yes.
   * Loop: i from 3 down to 1 at matrix[i][left]
   * Elements: 13, 9, 5
   * Update: left = 1

  ---

  Round 2: The Inner Layer
  Current boundaries: top=1, bottom=3, left=1, right=2

  1. Top Row
   * Loop: i from 1 to 2
   * Elements: 6, 7
   * Update: top = 2

  2. Right Column
   * Loop: i from 2 to 3
   * Elements: 11, 15
   * Update: right = 1

  3. Bottom Row — if (top <= bottom) check
   * Check: 2 <= 3? Yes.
   * Loop: i from 1 down to 1 (only one element)
   * Element: 14
   * Update: bottom = 2

  4. Left Column — if (left <= right) check
   * Check: 1 <= 1? Yes.
   * Loop: i from 2 down to 2 (only one element)
   * Element: 10
   * Update: left = 2

  ---

  Round 3: The Final Check (Where the if matters)
  Current boundaries: top=2, bottom=2, left=2, right=1

   1. Top Row: Loop i from 2 to 1. Loop condition i <= right (2 <= 1) is False. No elements added. top becomes 3.
   2. Right Column: Loop i from 3 to 2. Loop condition i <= bottom (3 <= 2) is False. No elements added. right becomes 0.
   3. Bottom Row: 
       * Check if (top <= bottom) -> if (3 <= 2)? False.
       * Logic: This prevents the code from trying to "re-print" element 10 or 14 in reverse because we've run out of unique rows.
   4. Left Column:
       * Check if (left <= right) -> if (2 <= 0)? False.
       * Logic: Prevents re-printing elements in a column that has already been shrunk to zero width.

  Final Result: [1, 2, 3, 4, 8, 12, 16, 20, 19, 18, 17, 13, 9, 5, 6, 7, 11, 15, 14, 10] 

*/