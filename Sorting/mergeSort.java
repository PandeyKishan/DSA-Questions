import java.util.*;

// Merge Sort - O(nlogn)
// Uses divide and conquer algorithm by dividing the array into smaller sub-arrays recursively until a single element is reached for both sides and sorting both left and right halves 
class Solution {
    // Function to merge two halves
    public void merge(int[] arr, int low, int mid, int high) {
        // Create temp array
        List<Integer> temp = new ArrayList<>();
        int left = low, right = mid + 1;

        // Merge both sorted parts
        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right])
                temp.add(arr[left++]);
            else
                temp.add(arr[right++]);
        }

        // Add remaining left elements
        while (left <= mid)
            temp.add(arr[left++]);

        // Add remaining right elements
        while (right <= high)
            temp.add(arr[right++]);

        // Copy back to original array
        for (int i = low; i <= high; i++)
            arr[i] = temp.get(i - low); // By using i - low, the function becomes "location independent"—it can sort and merge any small window anywhere inside the big array.
    }

    // Recursive merge sort
    public void mergeSort(int[] arr, int low, int high) {
        if (low >= high)
            return;

        // Find mid index
        int mid = (low + high) / 2;

        // Sort left half
        mergeSort(arr, low, mid);

        // Sort right half
        mergeSort(arr, mid + 1, high);

        // Merge both halves
        merge(arr, low, mid, high);
    }
}

public class mergeSort {
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
        Solution sol = new Solution();
        sol.mergeSort(arr, 0, arr.length - 1);
        System.err.println("Sorted Array: ");
        for (int i : arr) {
            System.err.print(i + " ");
        }
        System.out.println();
    }
}

/* To understand the "Copy back to original array" step:
 ✦ Let's look at the merge call for the right half of our previous example.
  The original section of the array was [1, 5, 3] at indices 3, 4, and 5.

  At the start of the merge function for this section:
   * low = 3
   * mid = 4
   * high = 5

  1. The Merging Phase
  The code compares the left side ([1, 5] at indices 3-4) and the right side ([3] at index 5). 
  After the while loops finish, our temp list looks like this:
  temp = [1, 3, 5]
  (Note: These are at indices 0, 1, and 2 within the temp list itself).

  2. The Copy Back Loop
  Now the code runs:
  for (int i = 3; i <= 5; i++) { arr[i] = temp.get(i - 3); }

  Iteration 1:
   * i = 3
   * i - low is 3 - 3 = 0
   * Action: arr[3] = temp.get(0) 
   * Result: Index 3 of the big array now holds 1.

  Iteration 2:
   * i = 4
   * i - low is 4 - 3 = 1
   * Action: arr[4] = temp.get(1)
   * Result: Index 4 of the big array now holds 3.

  Iteration 3:
   * i = 5
   * i - low is 5 - 3 = 2
   * Action: arr[5] = temp.get(2)
   * Result: Index 5 of the big array now holds 5.

  The Final Outcome
  The original array's section from index 3 to 5, which was [1, 5, 3], has been overwritten and is now [1, 3, 5].

  The reason this worked is that i - 3 "translated" the big array positions (3, 4, 5) perfectly into the small list positions (0, 1, 2). */

  // ********************************************************************* FINAL MERGE *********************************************************************************

/* The "Final Conquer" is handled by the merge(arr, low, mid, high) function. At this stage, the computer doesn't see the whole array as one mess; it sees two separate, already
  sorted piles that need to be zipped together.

  Here is the step-by-step breakdown of merge(arr, 0, 2, 5) for our example:

  1. The Setup
  The function sets up two pointers (like fingers pointing at the numbers) and an empty temporary list:
   * Pointer left starts at index 0 (pointing at 2).
   * Pointer right starts at index 3 (pointing at 1).
   * temp list: []

  2. The Comparison Phase (The while loop)
  The computer compares the numbers at the two pointers and picks the smaller one to put into temp.

   * Step A: Compare arr[left] (2) and arr[right] (1).
       * 1 is smaller.
       * Add 1 to temp. Move right to index 4.
       * temp: [1]

   * Step B: Compare arr[left] (2) and arr[right] (3).
       * 2 is smaller.
       * Add 2 to temp. Move left to index 1.
       * temp: [1, 2]

   * Step C: Compare arr[left] (4) and arr[right] (3).
       * 3 is smaller.
       * Add 3 to temp. Move right to index 5.
       * temp: [1, 2, 3]

   * Step D: Compare arr[left] (4) and arr[right] (5).
       * 4 is smaller.
       * Add 4 to temp. Move left to index 2.
       * temp: [1, 2, 3, 4]

   * Step E: Compare arr[left] (7) and arr[right] (5).
       * 5 is smaller.
       * Add 5 to temp. Move right to index 6.
       * Right pointer is now out of bounds! The loop stops.
       * temp: [1, 2, 3, 4, 5]

  3. Cleaning Up (The "Remainder" loops)
  Because the right pointer finished first, the 7 on the left side is still sitting there. The code has two small loops to catch any leftovers:
   * It adds the remaining 7 from the left side to temp.
   * Final temp: [1, 2, 3, 4, 5, 7]

  4. The Copy Back
  Finally, the function takes the numbers from the temp list and overwrites the original arr from index low (0) to high (5).

   1 for (int i = low; i <= high; i++)
   2     arr[i] = temp.get(i - low); */  