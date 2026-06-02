import java.util.Arrays;
import java.util.Scanner;

class Solution {

    // Time Complexity: O(N log N) - Brute Force
    // Function to sort the array and return the largest element
    public int findLargestElementUsingSorting(int[] arr) {
        // Sort the array in ascending order
        Arrays.sort(arr); // The time complexity of Java's Arrays.sort() method is generally (O(N log N)).
        
        // Return the last element (largest element) after sorting
        return arr[arr.length - 1];
    }

    // Time Complexity: O(N) - Optimal Approach
    public int findLargestElement(int[] arr, int n) {
        int max = arr[0];  // Initialize max with the first element in the array

        // Iterate through the array to find the maximum element
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {  // If the current element is greater than max, update max
                max = arr[i];
            }
        }

        return max;  // Return the largest element found
    }
}

public class largestElement {
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

        int largestElement = sol.findLargestElementUsingSorting(arr);

        System.err.println("\nLargest Element of the array (using Sorting) is: " + largestElement);

        largestElement = sol.findLargestElement(arr, n);

        System.err.println("\nLargest Element of the array (using iteration, without sorting) is: " + largestElement);
    }    
}
