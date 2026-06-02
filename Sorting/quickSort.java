import java.util.Scanner;

// Quick Sort - O(nlogn - best, average case) && O(n^2 - worst case when pivot is smallest or largest)
// Take a pivot element, set it's correct position and then partition the array into smaller subarrays i.e. left and right half and then do the same.
// The core idea behind Quicksort lies in partitioning the array around a pivot element such that all elements smaller than the pivot lie to its left and all greater elements lie to its right. 
// This positioning ensures that the pivot is in its correct sorted place. By doing this for each recursive call, the problem is broken down into smaller subproblems where each side of the pivot can be independently sorted. 
// This divide-and-conquer strategy allows Quicksort to sort parts of the array separately.
class Solution {
    // Function to perform quicksort
    public void quickSort(int[] arr, int low, int high) {
        // Base case
        if (low < high) {
            // Find pivot index
            int pivotIndex = partition(arr, low, high);

            // Sort left subarray
            quickSort(arr, low, pivotIndex - 1);

            // Sort right subarray
            quickSort(arr, pivotIndex + 1, high);
        }
    }

    // Function to partition array
    private int partition(int[] arr, int low, int high) {
        // Choose last element as pivot
        int pivot = arr[high];

        // Initialize i
        int i = low - 1;

        // Traverse from low to high-1
        for (int j = low; j < high; j++) {
            // If element <= pivot
            if (arr[j] <= pivot) {
                // Increment i and swap
                i++;
                int temp = arr[i];
                arr[i] = arr[j];        
                arr[j] = temp;                                               
            }
        }

        // Place pivot in correct position
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        // Return pivot index
        return i + 1;
    }
}

public class quickSort {
    public static void main(String[] args) {
        // Input array
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array: ");
        int n;
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter number " + (i + 1) + ":");
            arr[i] = sc.nextInt();
        }

        // Create object
        Solution sol = new Solution();

        // Call quickSort
        sol.quickSort(arr, 0, arr.length - 1);

        // Print sorted array
        for (int num : arr)
            System.out.print(num + " ");
    }
}


/* Let's trace the execution for [9, 4, 7, 3, 1] using the logic in quickSort.java, where the last element of the current range is the
  pivot.

  Initial State: [9, 4, 7, 3, 1]
  Global Call: quickSort(0, 4)

  ---

  Level 1: quickSort(0, 4)
   * Pivot: 1 (at index 4).
   * Partitioning:
       * j=0 to 3: No element is <= 1.
       * Swap: Swap arr[low] (9) with pivot (1).
       * Result: [1, 4, 7, 3, 9]
       * pivotIndex = 0.
   * Call L1: quickSort(0, -1) -> Base Case Fails (0 < -1). Returns.
   * Call L2: quickSort(1, 4) -> Go to Level 2.

  ---

  Level 2: quickSort(1, 4) (Working on [4, 7, 3, 9])
   * Pivot: 9 (at index 4).
   * Partitioning:
       * 4 <= 9, 7 <= 9, 3 <= 9. All are smaller.
       * Swap: 9 is swapped with itself at the end.
       * Result: [1, 4, 7, 3, 9] (Pivot 9 is now fixed at index 4).
       * pivotIndex = 4.
   * Call L1: quickSort(1, 3) -> Go to Level 3.
   * Call L2: quickSort(5, 4) -> Base Case Fails. Returns.

  ---

  Level 3: quickSort(1, 3) (Working on [4, 7, 3])
   * Pivot: 3 (at index 3).
   * Partitioning:
       * j=1 (4): Not <= 3.
       * j=2 (7): Not <= 3.
       * Swap: Swap arr[1] (4) with pivot (3).
       * Result: [1, 3, 7, 4, 9] (Pivot 3 is now fixed at index 1).
       * pivotIndex = 1.
   * Call L1: quickSort(1, 0) -> Base Case Fails. Returns.
   * Call L2: quickSort(2, 3) -> Go to Level 4.

  ---

  Level 4: quickSort(2, 3) (Working on [7, 4])
   * Pivot: 4 (at index 3).
   * Partitioning:
       * j=2 (7): Not <= 4.
       * Swap: Swap arr[2] (7) with pivot (4).
       * Result: [1, 3, 4, 7, 9] (Pivot 4 is now fixed at index 2).
       * pivotIndex = 2.
   * Call L1: quickSort(2, 1) -> Base Case Fails. Returns.
   * Call L2: quickSort(3, 3) -> Base Case Fails. Returns.

  ---
  The Return Journey (The "Bubbling Up")
   1. Level 4 finishes and returns to Level 3.
   2. Level 3 finishes (both its L1 and L2 are done) and returns to Level 2.
   3. Level 2 finishes and returns to the top-level Level 1.
   4. Level 1 finishes.

  Final Sorted Array: [1, 3, 4, 7, 9]

  Key Observation
  Notice that in Level 1, the pivot 1 was the smallest element. This resulted in an "unbalanced" split where the left side was empty and
  the right side had 4 elements. This is why Quick Sort can sometimes be slow ($O(N^2)$) if the pivot is always the smallest or largest
  element!
  
  Key Difference from Merge Sort
   * In Merge Sort, the work happens after the recursive calls (the merge step).
   * In Quick Sort, the work happens before the recursive calls (the partition step). By the time the recursion reaches the base case,
     the elements are already in their correct positions! */
