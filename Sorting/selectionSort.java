import java.util.*;

// Selection Sort - O(n^2)
// We select a minimum element each time and sort it to it's correct position i.e. from the beginning of the array.
class selectionSort {

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

        // Traverse through all array elements
        for (int i = 0; i < n - 1; i++) { // traversing till n - 1 since the last element will always be in it's sorted position when n - 1 elements are sorted and at their correct position
            int minIndex = i; // Assume current index holds the minimum

            // Find the minimum element in the remaining array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j; // Update minIndex if smaller is found
                }
            }

            // Swap the found minimum element with the first element of unsorted part
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }

        System.err.println("Sorted Array: ");
        for (int i : arr) {
            System.err.print(i + " ");
        }
    }     
}
