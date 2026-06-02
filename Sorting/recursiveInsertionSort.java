import java.util.Scanner;

// Insertion Sort using Recursion - O(n^2)
class Solution {
    // Recursive bubble sort function
    public void insertionSort(int[] arr, int n, int i) {
        // Base case: array of size 1 is already sorted
        if (n == 1) return;

        int j = i - 1;
        int key = arr[i];

       while (j >= 0 && arr[j] > key) {
            arr[j + 1] = arr[j];
            j--;
        }

        arr[j + 1] = key;

        // Recurse for the remaining unsorted array
        insertionSort(arr, n - 1, i + 1);
    }

    public void insertionSortUsingRecursion(int[] arr, int n, int i) {
        // Base case
        if (i == n) return;

        int j = i;
        // Move the current element back until it's in the correct place
        while (j > 0 && arr[j - 1] > arr[j]) {
            // Swap arr[j] and arr[j-1]
            int temp = arr[j - 1];
            arr[j - 1] = arr[j];
            arr[j] = temp;
            j--;
        }

        // Recur for the next index
        insertionSort(arr, i + 1, n);
    }
}            

public class recursiveInsertionSort {
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

        int[] arr1 = arr;

        System.out.println("Before Using Insertion Sort:");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();

        sol.insertionSort(arr, n, 1);

        System.out.println("After Using Normal Insertion Sort:");
        for (int i : arr)
            System.out.print(i + " ");

        sol.insertionSortUsingRecursion(arr1, n, 0);

        System.out.println("\nAfter Using Recursive Insertion Sort:");
        for (int i : arr1)
            System.out.print(i + " ");
    }
}
