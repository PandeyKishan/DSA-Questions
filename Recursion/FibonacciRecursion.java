import java.util.Scanner;

public class FibonacciRecursion {
    // Recursive function to return the nth Fibonacci number
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of terms (N): ");
        int n = sc.nextInt();

        System.out.println("Fibonacci Sequence up to " + n + " terms:");
        for (int i = 0; i < n; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
        
        sc.close();
    }
}
