import java.util.*;

class Solution {
    /**
     * Time Complexity: O(N^2)
     * Space Complexity: O(N^2)
     */
    public List<List<Integer>> printPascalsTriangle(int n) {
        List<List<Integer>> list = new ArrayList<>();
        int sum;
        for(int i = 0; i <= n - 1; i++) {
            List<Integer> subList = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                sum = 0;
                if(j == 0 || i == j)
                    subList.add(1);
                else {
                    int number1 = list.get(i - 1).get(j - 1); // [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
                    int number2 = list.get(i - 1).get(j);

                    sum = number1 + number2;

                    subList.add(sum);
                    
                }
                // System.out.println(subList);
            }
            list.add(subList);
        }
        return list;
    }

    /**
     * Time Complexity: O(min(c,r−c))
     * Space Complexity: O(1)
     */
    // Function to compute binomial coefficient (nCr)
    public long findPascalElement(int r, int c) {
        // Element is C(r-1, c-1)
        int n = r - 1;
        int k = c - 1;

        long result = 1;

        // Compute C(n, k) using iterative formula
        for (int i = 0; i < k; i++) {
            result *= (n - i);
            result /= (i + 1);
        }

        return result;
    }

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    // Function to generate the Nth row of Pascal's Triangle
    public List<Long> getNthRow(int N) {
        // Result list to store the row
        List<Long> row = new ArrayList<>();
        
        // First value of the row is always 1
        long val = 1;
        row.add(val);
        
        // Compute remaining values using the relation:
        // C(n, k) = C(n, k-1) * (n-k) / k
        for (int k = 1; k < N; k++) {
            val = val * (N - k) / k;
            row.add(val);
        }
        
        return row;
    }
}
/* 
    0 1 2  3  4 5
0   1
1   1 1
2   1 2 1
3   1 3 3  1
4   1 4 6  4  1
5   1 5 10 10 5 1
 */

public class pascalsTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        
        System.out.println("Enter number of rows in Pascal's Triangle: ");
        int n = sc.nextInt();

        List<List<Integer>> result = sol.printPascalsTriangle(n);

        System.err.println("List: " + result);

        
        System.out.println("Enter row and column of element to access: ");
        int row = sc.nextInt();
        int column = sc.nextInt();

        System.out.println("\nRow: " + row + "\nColumn: " + column);

        long number = sol.findPascalElement(row, column);
        System.out.println("\n[Optimal] Element at row "+ row + " and column " + column + " is: " + number);

        System.out.println("Enter row to get: ");
        int N = sc.nextInt();

        List<Long> requiredRow = sol.getNthRow(N);
        System.out.println(N + "th row: " + requiredRow);
    }
}