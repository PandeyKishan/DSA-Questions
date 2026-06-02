package Easy;
import java.util.*;

import Solution;

class Solution {
    // Function to move zeroes to the end
    public void moveZeroes(int[] nums) {
        // Pointer to the first zero
        int j = -1;

        // Find the first zero
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                j = i;
                break;
            }
        }

        // If no zero found, return
        if (j == -1) return;

        // Start from the next index of first zero
        for (int i = j + 1; i < nums.length; i++) {
            // If current element is non-zero
            if (nums[i] != 0) {
                // Swap with nums[j]
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                // Move j to next zero
                j++;
            }
        }
    }

    public void moveZeroesLeetcode(int[] arr) {
        int i = -1;
        for (int j = 0; j < arr.length; j++) {
            if (arr[j] != 0) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }            
}

public class moveZeroesToEnd {
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

        int[] nums = arr.clone();

        System.out.println("Array: ");
        for (int number : arr) {
            System.out.print(+ number + " ");
        }

        sol.moveZeroes(arr);
        sol.moveZeroesLeetcode(nums);

        System.out.println("Output array: ");
        // Print the result
        for (int num : arr)
            System.out.print(num + " ");

        System.out.println("Output array (Leetcode): ");
        // Print the result
        for (int num : nums)
            System.out.print(num + " ");
    }
}
