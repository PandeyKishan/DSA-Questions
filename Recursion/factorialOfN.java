import java.util.Scanner;

class Solution {
    // Forward Recursion
    // Recursive function to print factorial of N
    public void sumOfN(int N, double factorial) {
        if (N < 1) {
            System.out.print("Factorial: " + factorial);
            return;
        }

        factorial = factorial * N;

        sumOfN(N - 1, factorial);
    }

    public double factorialOfN(int N) {
        // Base case: if N is 1, return 1
        if (N == 0) {
            return 1;
        }
        // Recursive case: current number * sum of previous numbers
        return N * factorialOfN(N - 1);
    }

    public double factorial(int X) {
        double ans = 1;

        // Loop from 1 to X to compute factorial
        for (int i = 1; i <= X; i++) {
            ans = ans * i;
        }

        // Return the final result
        return ans;
    }
}

public class factorialOfN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter N: ");
        int N = sc.nextInt();

        sol.sumOfN(N, 1);

        double factorial = sol.factorialOfN(N);
        System.out.print("\nFactorial using recursion: " + factorial);

        factorial = sol.factorial(N);
        System.out.print("\nFactorial using iteration: " + factorial);
        
        sc.close();
    }
}
