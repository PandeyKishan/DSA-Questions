package Easy;
import java.util.Scanner;

import Solution;

class Solution {

    public void reverseArray(int[] nums, int start, int end) {
        // if (start >= end) {
        //     return;
        // }
        // // Swapping elements
        // int temp = nums[start];
        // nums[start] = nums[end];
        // nums[end] = temp;
        
        // reverseArray(nums, start + 1, end - 1);

        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }    
    }

    // Using for-loop: Time complexity: O(n), Space Complexity: O(1)
    public int[] rightRotateArrayOptimal(int[] nums, int n, int k) {
        if (n == 0 || k == 0) 
            return nums;
        reverseArray(nums, 0, n - 1);
        k = k % n;
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, n - 1);
        return nums;
    }

    public int[] leftRotateArrayOptimal(int[] nums, int n, int k) {
        if (n == 0 || k == 0) 
            return nums;
        k = k % n;
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, n - 1);
        reverseArray(nums, 0, n - 1);
        return nums;
    }

    public int[] rotateArrayOptimal(int[] nums, int k, String direction) {
        // Get array length
        int n = nums.length;

        // Edge case: do nothing if array is empty or k is 0
        if (n == 0 || k == 0) return nums;

        // Normalize k if greater than n
        k = k % n;

        // If rotation is to the right
        if (direction.equals("right")) {
            // Step 1: reverse entire array
            reverseArray(nums, 0, n - 1);

            // Step 2: reverse first k elements
            reverseArray(nums, 0, k - 1);

            // Step 3: reverse remaining n-k elements
            reverseArray(nums, k, n - 1);
        } 
        // If rotation is to the left
        else if (direction.equals("left")) {
            // Step 1: reverse first k elements
            reverseArray(nums, 0, k - 1);

            // Step 2: reverse remaining n-k elements
            reverseArray(nums, k, n - 1);

            // Step 3: reverse entire array
            reverseArray(nums, 0, n - 1);
        }

        // Return the rotated array
        return nums;
    }
}

public class rotateArrayByK {

    public static void main(String[] args) {
        // Input array
        Scanner sc = new Scanner(System.in);

        int n, k;
        String direction;
        System.out.print("Enter size of array: ");
        n = sc.nextInt();
        System.out.print("Enter value of k: ");
        k = sc.nextInt();
        System.out.print("Enter direction: ");
        direction = sc.next();
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
        int[] ansArray = arr.clone();

        // Create Solution instance
        Solution sol = new Solution();
        
        // System.out.print("\nUsing brute force approach: ");
        // int[] temp = sol.leftRotateArrayBruteForce(array, n);

        // for (int i = 0; i < n; i++) {
        //     System.out.print(temp[i] + " ");
        // }

        // Right rotation
        System.out.print("\nUsing optimal approach - RIGHT ROTATION: ");
        int[] ansRight = sol.rightRotateArrayOptimal(arr, n, k);

        for (int i = 0; i < n; i++) {
            System.out.print(ansRight[i] + " ");
        }

        // Left rotation
        System.out.print("\nUsing optimal approach - LEFT ROTATION: ");
        int[] ansLeft = sol.leftRotateArrayOptimal(array, n, k);

        for (int i = 0; i < n; i++) {
            System.out.print(ansLeft[i] + " ");
        }

        System.out.print("\nUsing optimal approach - RIGHT/LEFT ROTATION: ");
        int[] ans = sol.rotateArrayOptimal(ansArray, k, direction);

        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }
}


/* Normalize k by doing k = k % N

If direction is "right":
    Reverse the entire array
    Reverse the first k elements
    Reverse the rest (from k to end)

If direction is "left":
    Reverse the first k elements
    Reverse the rest (from k to end)
    Reverse the entire array 
    
  When reversing array using recursion vs traditional approach:
  | Feature          │ Traditional (Iterative) Approach │ Recursive Approach                                       |
  | Space Complexity │ $O(1)$ (Constant)                │ $O(N)$ (Stack space)                                     │
  │ Performance      │ Faster. Simple pointer updates.  │ Slower. Overhead of function calls and stack management. │
  │ Safety           │ Safe for any array size.         │ Risk of StackOverflowError for very large arrays.        | */
