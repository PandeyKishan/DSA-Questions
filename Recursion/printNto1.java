import java.util.Scanner;

class Solution {
    // Forward Recursion
    // Recursive function to print N to 1
    public void printNto1(int N) {
        // Base case: if count equals N, stop recursion
        if (N < 1)
            return;

        // Print the number
        System.out.println(N);

        // Recursive call with incremented count
        printNto1(N - 1);

        // Backtracking - when printing numbers backwards
        // Base case: if current exceeds n, stop recursion
        // public void printNto1(int N) {
        // if (N < 1)
        //     return;

        // // Recursive call with next number
        // printNto1(N - 1);

        // // Print current number during backtracking
        // System.out.println(N);
    }
}

public class printNto1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter N: ");
        int N = sc.nextInt();

        sol.printNto1(N);
        
        sc.close();
    }
}
