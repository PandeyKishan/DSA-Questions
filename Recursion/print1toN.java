import java.util.Scanner;

class Solution {
    // Forward Recursion
    // Recursive function to print 1 to N
    // public void print1toN(int count, int N) {
    //     // Base case: if count equals N, stop recursion
    //     if (count > N)
    //         return;

    //     // Print the number
    //     System.out.println(count);

    //     // Recursive call with incremented count
    //     print1toN(count + 1, N);

        // Backtracking - when printing numbers backwards
        // Base case: if current exceeds n, stop recursion
        public void print1toN(int count, int N) {
        if (count > N)
            return;

        // Recursive call with next number
        print1toN(count + 1, N);

        // Print current number during backtracking
        System.out.println(count);
    }
}

public class print1toN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter N: ");
        int N = sc.nextInt();

        sol.print1toN(1, N);
        
        sc.close();
    }
}
