// public class printFibonacci {

//     public static void main(String[] args) {
//         int n = 5;

//         // Edge case: if n is 0, print only 0
//         if (n == 0) {
//             System.out.println(0);
//         }
//         // Special case: if n is 1, print first two Fibonacci numbers
//         else if (n == 1) {
//             System.out.println("0 1");
//         }
//         // General case: compute and print Fibonacci series
//         else {
//             int[] fib = new int[n + 1];  // Array to hold Fibonacci numbers
//             fib[0] = 0;
//             fib[1] = 1;

//             // Compute Fibonacci numbers from index 2 to n
//             for (int i = 2; i <= n; i++) {
//                 fib[i] = fib[i - 1] + fib[i - 2];
//             }

//             System.out.println("The Fibonacci Series up to " + n + "th term:");
//             for (int i = 0; i <= n; i++) {
//                 System.out.print(fib[i] + " ");
//             }
//         }
//     }
// }

// More efficient approach:
public class printFibonacci {
    public static void main(String[] args) {
        int n = 5;

        // If n is 0, print only the first term
        if (n == 0) {
            System.out.println("The Fibonacci Series up to " + n + "th term:");
            System.out.println(0);
        } else {
            int secondLast = 0; // (i-2)th term
            int last = 1;       // (i-1)th term

            System.out.println("The Fibonacci Series up to " + n + "th term:");
            System.out.print(secondLast + " " + last + " ");

            int cur;
            for (int i = 2; i <= n; i++) {
                cur = last + secondLast;  // Calculate current term
                secondLast = last;        // Slide the window
                last = cur;
                System.out.print(cur + " ");
            }
        }
    }
}