import java.util.*;

// Insertion Sort - O(n^2)
class insertionSort {

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

        // For every element in the array 
        for (int i = 1; i < n; i++) {
            int element = arr[i]; // Current element as key 
            int j = i - 1;
            // Shift elements that are greater than key by one position and keep shifting till a smaller element is reached
            // traversing stops there and j is at next the smaller element than the key
            while(j >= 0 && arr[j] > element) {
                arr[j + 1] = arr[j]; // we are not swapping here; we are just shifting values
                j--;
            }
            arr[j + 1] = element; // Insert key at correct position after the next smaller element
        }

        System.err.println("Sorted Array: ");
        for (int i : arr) {
            System.err.print(i + " ");
        }
    }     
}

