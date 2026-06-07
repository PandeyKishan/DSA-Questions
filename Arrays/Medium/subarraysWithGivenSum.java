import java.util.*;

class Solution {
    /**
     * HashMap + Prefix Sum Approach
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int countSubArraysOptimal(int[] arr, int n, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int preSum = 0, count = 0;

        // Setting 0 in the map initially to handle subarrays starting from index 0
        map.put(0, 1);
        for (int i = 0; i < n; i++) {
            // add current element to prefix sum:
            preSum += arr[i];

            // Calculate the prefix sum we need to remove (preSum - k)
            int remove = preSum - k;

            // Add the frequency of 'remove' to count:
            count += map.getOrDefault(remove, 0);

            // Update the count of current prefix sum in the map
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return count;
        // 3 1 2 4, k = 6
        // curr_sum = 3 + 1 + 2 + 4
        // count = 0 {remove: -3, -2, 0, 4} -> count = 1 + 1
        // map: [0 -> 1, 3 -> 1, 4 -> 2, 6 -> 1]
    }
    public int countSubArraysBetter(int[] arr, int n, int k) {
            // Size of the array
        // Initialize count of subarrays
        int count = 0;

        // Traverse all possible start indices
        for (int i = 0; i < n; i++) {
            // Initialize sum for current subarray
            int sum = 0;

            // Traverse all possible end indices from start
            for (int j = i; j < n; j++) {
                // Add current element to sum
                sum += arr[j];

                // If sum equals k, increment count
                if (sum == k) {
                    count++;
                }
            }
        }

        // Return total count of subarrays
        return count;
    }
}

public class subarraysWithGivenSum {
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

        System.out.println("Enter target sum: ");
        int sum = sc.nextInt();

        int answer = sol.countSubArraysOptimal(arr, n, sum);

        System.out.println("\n[Optimal] The number of subarrays with target " + sum + ": " + answer);

        answer = sol.countSubArraysBetter(arr, n, sum);

        System.out.println("\n[Better] The number of subarrays with target " + sum + ": " + answer);

        // answer = sol.longestSequenceOptimal(arr, n);

        // System.out.println("\n[Optimal] The longest consecutive sequence of the array has a length of: " + answer);
    }
}
