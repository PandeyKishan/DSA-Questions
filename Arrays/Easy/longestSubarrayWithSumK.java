package Easy;
import java.util.*;

import Solution;

class Solution {
    /**
     * Brute Force Approach
     * Time Complexity: O(N^2)
     * Space Complexity: O(1)
     * Works for: Positive, Negative, and Zeros.
     */
    public int longestSubarray(int[] arr, int k) {
        int max_length = 0;
        for (int i = 0; i < arr.length; i++) {
            long sum = 0;
            for (int j = i; j < arr.length; j++) {
                sum += arr[j];
                if (sum == k) {
                    max_length = Math.max(max_length, j - i + 1);
                }
            }
        }
        return max_length;
    }

    /**
     * Sliding Window (Two-Pointer) Approach
     * Time Complexity: O(2N) -> O(N)
     * Space Complexity: O(1)
     * Works for: ONLY non-negative integers (Positive and Zeros).
     * 
     * Example: arr = [1, 2, 3, 1, 1, 1, 1], k = 3
     * 1. right=0, sum=1 (sum < 3)
     * 2. right=1, sum=1+2=3 (sum == 3) -> max_length = max(0, 1-0+1) = 2
     * 3. right=2, sum=3+3=6 (sum > 3) -> shrink from left: 
     *    left=1, sum=6-1=5; 
     *    left=2, sum=5-2=3 (sum == 3) -> max_length = max(2, 2-2+1) = 2
     * 4. right=3, sum=3+1=4 (sum > 3) -> shrink from left: left=3, sum=4-3=1
     * 5. right=4, sum=1+1=2 (sum < 3)
     * 6. right=5, sum=2+1=3 (sum == 3) -> max_length = max(2, 5-3+1) = 3
     * 7. right=6, sum=3+1=4 (sum > 3) -> shrink from left: left=4, sum=4-1=3
     *    (sum == 3) -> max_length = max(3, 6-4+1) = 3
     * Result: 3
     */
    public int longestSubarraySlidingWindow(int[] arr, int k) {
        int left = 0, right = 0;
        long sum = 0;
        int max_length = 0;
        int n = arr.length;

        while (right < n) {
            sum += arr[right];

            // If sum exceeds k, shrink the window from the left
            while (left <= right && sum > k) {
                sum -= arr[left];
                left++;
            } //  [10, 5, 2, 7, 1, 9]

            // If sum matches k, update max_length
            if (sum == k) {
                max_length = Math.max(max_length, right - left + 1);
            }

            right++;
        }
        return max_length;
    }
}

public class longestSubarrayWithSumK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter number " + (i + 1) + ":");
            arr[i] = sc.nextInt();
        }

        System.out.println("\nArray: " + Arrays.toString(arr));
        System.out.println("Enter sum K: ");
        int k = sc.nextInt();

        // 1. Brute Force
        int lenBrute = sol.longestSubarray(arr, k);
        System.out.println("\n[Brute Force] Longest subarray length: " + lenBrute);

        // 2. Sliding Window
        int lenSliding = sol.longestSubarraySlidingWindow(arr, k);
        System.out.println("[Sliding Window] Longest subarray length: " + lenSliding);
        
        System.out.println("\nNote: Sliding window only works correctly for non-negative integers.");
    }
}