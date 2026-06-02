package Easy;
import java.util.Arrays;
import java.util.Scanner;

import Solution;

class Solution {

    // Time Complexity: O(N log N) - Brute Force
    // Method to find the second smallest and second largest elements in the array
    public void getElementsBruteForce(int[] arr, int n) {
        
        // Edge case: when the array has less than 2 elements
        if (n == 0 || n == 1) {
            System.out.println(-1 + " " + -1);  // Print -1 for both second smallest and second largest
            return;
        }

        // Sort the array to easily find the second smallest and second largest elements
        Arrays.sort(arr);

        // Second smallest element is at index 1 after sorting
        int small = arr[1];

        // Second largest element is at index n-2 after sorting
        int large = arr[n - 2];

        // Output the second smallest and second largest elements
        System.out.println("\nSecond smallest is " + small);
        System.out.println("Second largest is " + large);
    }

    // Time Complexity: O(N) - Better Approach
    // Method to find the second smallest and second largest elements in the array
    public void getElementsBetterApproach(int[] arr, int n) {
        
        // Edge case: when the array has less than 2 elements
        if (n == 0 || n == 1) {
            System.out.println(-1 + " " + -1);  // Print -1 for both second smallest and second largest
            return;
        }

        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE; 
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            min = Math.min(min, arr[i]);  // Update the smallest element
            max = Math.max(max, arr[i]);  // Update the largest element
        }

        // Second largest element is at index n-2 after sorting
        for (int i = 0; i < n; i++) {
            if (arr[i] < secondMin && arr[i] != min) {
                secondMin = arr[i];  // Update second smallest if a smaller element is found
            }
            if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }

        // Output the second smallest and second largest elements
        System.out.println("Second smallest is " + secondMin);
        System.out.println("Second largest is " + secondMax);
    }

    // Time Complexity: O(N) - Better Approach
    // Method to find the second smallest and second largest elements in the array
    public void getElementsOptimalApproach(int[] arr, int n) {
        
        // Edge case: when the array has less than 2 elements
        if (n < 2) {
            System.out.println(-1 + " " + -1);  // Print -1 for both second smallest and second largest
            return;
        }

        int min = Integer.MAX_VALUE;
        int secondMin = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE; 
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            if (arr[i] < min) {
                secondMin = min;
                min = arr[i];
            } else if (arr[i] < secondMin && arr[i] != min) { // This runs only if the if condition was false. This means arr[i] is not smaller than the current min. However, it might still be smaller than our current secondMin.
                secondMin = arr[i];
            }
        } 
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                secondMax = max;
                max = arr[i];
            } else if (arr[i] > secondMax && arr[i] != max) {
                secondMax = arr[i];
            }
        }

        // Output the second smallest and second largest elements
        System.out.println("Second smallest is " + secondMin);
        System.out.println("Second largest is " + secondMax);
    }
}

public class secondSmallestLargest {

    public static void main(String[] args) {
        
        // Initialize the array with elements
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

        sol.getElementsBruteForce(arr, n);

        sol.getElementsBetterApproach(arr, n);

        sol.getElementsOptimalApproach(arr, n);
    }
}

/*    *   The else if block: else if (arr[i] < secondMin && arr[i] != min) in the getElementsOptimalApproach method:
This runs only if the if condition was false. This means arr[i] is not smaller than the current min. However, it might still be smaller than our current secondMin.
For example, if min = 10 and secondMin = 20, and you encounter 15. 
       * 15 < 10 is False (The if is skipped).
       * 15 < 20 is True (The else if catches it).
   * Action: Update secondMin = 15. */
