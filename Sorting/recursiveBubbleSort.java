import java.util.Scanner;

// Bubble Sort using Recursion - O(n^2)
public class recursiveBubbleSort {
    // Recursive bubble sort function
    static void bubbleSort(int[] arr, int n) {
        // Base case: array of size 1 is already sorted
        if (n == 1) return;

        // Push the largest element to the end
        for (int j = 0; j <= n - 2; j++) {
            if (arr[j] > arr[j + 1]) {
                // Swap arr[j] and arr[j + 1]
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }

        // Recurse for the remaining unsorted array
        bubbleSort(arr, n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter size of array: ");
        int n;
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter number " + (i + 1) + ":");
            arr[i] = sc.nextInt();
        }

        System.out.println("Before Using Bubble Sort:");
        for (int i : arr)
            System.out.print(i + " ");
        System.out.println();

        bubbleSort(arr, n);

        System.out.println("After Using Bubble Sort:");
        for (int i : arr)
            System.out.print(i + " ");
    }
}
