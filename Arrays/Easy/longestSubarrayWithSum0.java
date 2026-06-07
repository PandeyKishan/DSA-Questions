import java.util.*;

class Solution {
    /**
     * Prefix Sum + HashMap Approach
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * Works for: Positive, Negative, and Zeros.
     * 
     * Logic: 
     * If the prefix sum up to index 'i' is 'S', and the prefix sum up to index 'j' 
     * is also 'S', then the sum of elements between i+1 and j MUST be 0.
     * 
     * Example: arr = [1, 2, -3, 3, 1], k = 0
     * Index | Val | Prefix Sum | HashMap (Sum -> First Index) | Action
     * -------------------------------------------------------------------------
     *   -   |  -  |      0     | {0: -1}                      | Initial state
     *   0   |  1  |      1     | {0: -1, 1: 0}                | New sum, store it
     *   1   |  2  |      3     | {0: -1, 1: 0, 3: 1}          | New sum, store it
     *   2   | -3  |      0     | Seen 0 at index -1!          | len = 2 - (-1) = 3
     *   3   |  3  |      3     | Seen 3 at index 1!           | len = 3 - 1 = 2 (Max stays 3)
     *   4   |  1  |      4     | {0: -1, 1: 0, 3: 1, 4: 4}    | New sum, store it
     * 
     * Result: 3 (Subarray: [1, 2, -3])
     */
    public int longestSubarrayPrefixSum(int[] arr, int k) {
        HashMap<Long, Integer> map = new HashMap<>();
        long sum = 0;
        int max_length = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];

            if (sum == k) {
                max_length = i + 1;
            }

            // otherwise check if this sum was seen before
            else {
                // when seen, zero-sum segment between previous index + 1 and i
                // if (map.containsKey(sum)) {
                //     // maximize length
                //     max_length = Math.max(max_length, i - map.get(sum));
                // }
                // // first time seeing this sum
                // else {
                //     // record index
                //     map.put(sum, i);
                // }
            }

            // ------- FOR ANY VALUE K
            // If (sum - k) was seen before, it means the elements between 
            // that index and current index sum up to k.
            if (map.containsKey(sum - k)) {
                max_length = Math.max(max_length, i - map.get(sum - k));
            }

            // Only store the sum if it's not already in the map.
            // We want the FIRST occurrence to get the LONGEST subarray.
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
            //  -------  
        }

        return max_length;
    }
}

public class longestSubarrayWithSum0 {
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
        
        // For longestSubarrayWithSum0, we usually assume k = 0
        System.out.println("\nEnter sum to be checked: ");
        int k = sc.nextInt();

        int length = sol.longestSubarrayPrefixSum(arr, k);
        System.out.println("\n[Prefix Sum] Longest subarray with sum " + k + " has length: " + length);
    }
}


// If we reach the same sum between a previous, traversed index and current index, that means that all the numbers when added between those two numbers sum to 0. Which is the exact length of the subarray. So to remember the previous index, we store the sum that was at that index, so we can find the exact length of the subarray between those two indexes, that add upto 0.