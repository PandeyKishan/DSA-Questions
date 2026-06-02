import java.util.Scanner;

class Solution {
    // Forward Recursion
    // Recursive function to print sum
    public void sumOfN(int N, int sum) {
        if (N < 1) {
            System.out.print("Sum: " + sum);
            return;
        }

        sum = sum + N;

        sumOfN(N - 1, sum);
    }


    // Using formula
    public int sumOfNaturalNumbersUsingFormula(int N) {
        // Apply formula directly
        return (N * (N + 1)) / 2;
    }

    public int sumOfNaturalNumbers(int N) {
        // Base case: if N is 1, return 1
        if (N == 1) {
            return 1;
        }
        // Recursive case: current number + sum of previous numbers
        return N + sumOfNaturalNumbers(N - 1);
    }
}

public class sumOfN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter N: ");
        int N = sc.nextInt();

        sol.sumOfN(N, 0);

        int sum = sol.sumOfNaturalNumbersUsingFormula(N);
        System.out.print("\nSum using formula: " + sum);

        sum = sol.sumOfNaturalNumbers(N);
        System.out.print("\nSum using recursion: " + sum);
        
        sc.close();
    }
}
