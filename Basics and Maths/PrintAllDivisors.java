import java.util.*;

class Solution {
    public List<Integer> getDivisors(int N) {
        // Brute-Force Approach
        // List<Integer> res = new ArrayList<>();
        // for (int i = 1; i <= N; i++) {
        //     if (N % i == 0) {
        //         res.add(i);
        //     }
        // }
        // return res;

        // Optimal Approach
        List<Integer> res = new ArrayList<>();


        // Loop from 1 to square root of N
        for (int i = 1; i <= Math.sqrt(N); i++) {
            // Check if i divides N
            if (N % i == 0) {
                // Add i to result
                res.add(i);

                // If N / i is different from i, add N / i too
                if (i != N / i) {
                    res.add(N / i);
                }
            }
        }

        // Return the list of divisors
        Collections.sort(res);
        return res;
    }
}

public class PrintAllDivisors {
    public static void main(String[] args) {
        // Create object of Solution class
        Solution sol = new Solution();

        // Input number
        int N = 36;

        // Call the function to get divisors
        List<Integer> result = sol.getDivisors(N);

        // Print the result
        System.out.print("Divisors of " + N + ": ");
        for (int val : result) {
            System.out.print(val + " ");
        }
        System.out.println();
    }
}
