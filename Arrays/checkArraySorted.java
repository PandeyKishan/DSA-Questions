import java.util.Scanner;

class Solution {

    // Time Complexity: O(N^2) - Brute Force
    public boolean checkArraySorted(int[] arr, int n) {
        if (n == 0 || n == 1) 
            return true;

        for (int i = 0; i < n; i++) {
            int key = arr[i];
            for (int j = i + 1; j < n; j++) {
                if (key > arr[j]) {
                    return false;
                }
            }
        }

        return true;
    }

    // Time Complexity: O(N^2) - Brute Force
    public boolean checkArraySortedUsingRecursion(int[] arr, int n, int i) {
        if (n == 0 || n == 1 || i == n) 
            return true;
       
        for (int j = i + 1; j < n; j++) {
            if (arr[i] > arr[j]) {
                return false;
            }
        }
        
        return checkArraySortedUsingRecursion(arr, n, i + 1);
    }

    public boolean isSortedOptimalApproach(int[] arr, int n) {
        for (int i = 1; i < n; i++) {
            if (arr[i] < arr[i - 1])  // If any element is smaller than the previous one, return false
                return false;
        }
        return true;  // Return true if the array is sorted
    }
}

public class checkArraySorted {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        System.out.println("Enter size of array: ");
        int n;
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter number " + (i + 1) + ":");
            arr[i] = sc.nextInt();
        }
        System.err.print("Array: ");
        for (int number : arr) {
            System.err.print(+ number + " ");
        }

        boolean sorted = sol.checkArraySorted(arr, n);

        if (!sorted) {
            System.err.println("\nArray isn't sorted");
        } else {
            System.err.println("\nArray is sorted");
        }

        sorted = sol.checkArraySortedUsingRecursion(arr, n, 0);

        if (!sorted) {
            System.err.println("\nArray isn't sorted");
        } else {
            System.err.println("\nArray is sorted");
        }

        sorted = sol.isSortedOptimalApproach(arr, n);

        if (!sorted) {
            System.err.println("\nArray isn't sorted");
        } else {
            System.err.println("\nArray is sorted");
        }    
    }    
}
