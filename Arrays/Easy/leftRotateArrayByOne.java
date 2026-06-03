import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {

    // Using for-loop: Time complexity: O(n), Space Complexity: O(1)
    public void leftRotateArrayOptimal(int[] nums, int n) {
        // for (int i = 1; i < n; i++) {
        //     int temp = arr[i - 1];
        //     arr[i - 1] = arr[i];
        //     arr[i] = temp;
        // }

        int temp = nums[0];
        
        // Shift elements to the left
        for (int i = 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }

        // Place the first element at the end
        nums[nums.length - 1] = temp;
    }

    // Brute-Force Approach: Time complexity: O(n), Space Complexity (for creating a temporary array): O(n) 
    public int[] leftRotateArrayBruteForce(int[] arr, int n) {
        int[] temp = new int[n];  // Temporary array to store shifted elements

        // Shift elements to the left by one position
        for (int i = 1; i < n; i++) {
            temp[i - 1] = arr[i];
        }
        temp[n - 1] = arr[0];  // First element moves to the last position

        // // Print the rotated array
        // for (int i = 0; i < n; i++) {
        //     System.out.print(temp[i] + " ");
        // }
        // System.out.println();

        return temp;
    }
}

public class leftRotateArrayByOne {

    public static void main(String[] args) {
        // Input array
        Scanner sc = new Scanner(System.in);

        int n;
        System.out.print("Enter size of array: ");
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

        int[] array = arr.clone();

        // Create Solution instance
        Solution sol = new Solution();
        
        System.out.print("\nUsing brute force approach: ");
        int[] temp = sol.leftRotateArrayBruteForce(array, n);

        for (int i = 0; i < n; i++) {
            System.out.print(temp[i] + " ");
        }

        System.out.print("\nUsing optimal approach: ");
        sol.leftRotateArrayOptimal(arr, n);

        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

