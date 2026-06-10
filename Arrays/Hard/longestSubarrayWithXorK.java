import java.util.*;

class Solution {
    /**
     * Prefix XOR + HashMap Approach
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int longestSubarrayWithXorK(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int xor = 0;
        int maxLen = 0;

        for (int i = 0; i < arr.length; i++) {
            xor ^= arr[i];

            // Case 1: The prefix itself XORs to K
            if (xor == k) {
                maxLen = i + 1;
            }

            // Case 2: Check if xor ^ some_previous_xor == k
            // By property: some_previous_xor = xor ^ k
            int target = xor ^ k;
            if (map.containsKey(target)) {
                maxLen = Math.max(maxLen, i - map.get(target));
            }

            // Store only the first occurrence to maximize the length
            if (!map.containsKey(xor)) {
                map.put(xor, i);
            }
        }

        return maxLen;
    }
}

public class longestSubarrayWithXorK {
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int[] arr1 = {4, 2, 2, 6, 4};
        int k1 = 6;
        System.out.println("Input: " + Arrays.toString(arr1) + ", K: " + k1);
        System.out.println("Output: " + sol.longestSubarrayWithXorK(arr1, k1)); // Expected: 4 ([4, 2, 2, 6])

        int[] arr2 = {5, 6, 7, 8, 9};
        int k2 = 5;
        System.out.println("\nInput: " + Arrays.toString(arr2) + ", K: " + k2);
        System.out.println("Output: " + sol.longestSubarrayWithXorK(arr2, k2)); // Expected: 1 ([5])
    }
}
