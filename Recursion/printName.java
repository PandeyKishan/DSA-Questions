import java.util.Scanner;

class Solution {
    // Recursive function to print name count times
    public void printName(String name, int count, int N) {
        // Base case: if count equals N, stop recursion
        if (count == N)
            return;

        // Print the name
        System.out.println(name);

        // Recursive call with incremented count
        printName(name, count + 1, N);
    }
}

public class printName {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter name: ");
        String name = sc.nextLine();

        System.out.print("Enter N: ");
        int N = sc.nextInt();

        sol.printName(name, 0, N);
        
        sc.close();
    }
}
