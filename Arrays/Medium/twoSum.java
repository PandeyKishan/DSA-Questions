import java.util.*;

class Solution {
    /**
     * One-Pass HashMap Approach
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * Works for: Positive, Negative, and Zeros.
     */
    public int[] twoSum(int[] arr, int target) {
        // Map to store: Value -> Index
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int complement = target - arr[i];

            // If we found the complement in the map, we found our pair!
            // This naturally avoids using the same index twice because 
            // the current element hasn't been added to the map yet.
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }

            // Otherwise, store current number and its index
            map.put(arr[i], i);
        }

        return new int[]{-1, -1};

        // {2,6,5,8,11}, target = 14
        // Map:        2 -> 0, 6 -> 1, 5 -> 2, 8 -> 3, 11 -> 4
        // Complement: 12,     8,      9,      6,      3
    }

    public int[] twoSumOptimal(int[] arr, int target) {
        // Map to store: Value -> Index
        int[][] numsWithIndex = new int[arr.length][2];

        // Store element with original index
        for (int i = 0; i < arr.length; i++) {
            numsWithIndex[i][0] = arr[i];
            numsWithIndex[i][1] = i;
        }    

        // Sort by the value to apply two-pointer
        Arrays.sort(numsWithIndex, (a, b) -> Integer.compare(a[0], b[0]));

        int left = 0, right = arr.length - 1;
        while (left < right) {
            int sum = numsWithIndex[left][0] + numsWithIndex[right][0];
            if (sum == target) {
                // Return original indices of the two numbers found
                return new int[] {numsWithIndex[left][1], numsWithIndex[right][1]};
            } else if (sum < target) {
                // Increase sum by moving left pointer forward
                left++;
            } else {
                // Decrease sum by moving right pointer backward
                right--;
            }
        }

        return new int[]{-1, -1};
    }
}

public class twoSum {
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

        System.out.println("Enter target: ");
        int target = sc.nextInt();

        int[] answer = sol.twoSum(arr, target);
        
        // Fix: Check for -1 instead of > 0, because 0 is a valid index.
        if (answer[0] != -1) {
            System.out.println("arr[" + answer[0] + "] + arr[" + answer[1] + "] = " + target);
            System.out.println("Indices: [" + answer[0] + ", " + answer[1] + "]");
        } else {
            System.out.println("There exist no such two numbers whose sum is equal to the target.");
        }

        answer = sol.twoSumOptimal(arr, target);

        // Fix: Check for -1 instead of > 0, because 0 is a valid index.
        if (answer[0] != -1) {
            System.out.println("arr[" + answer[0] + "] + arr[" + answer[1] + "] = " + target);
            System.out.println("Indices: [" + answer[0] + ", " + answer[1] + "]");
        } else {
            System.out.println("There exist no such two numbers whose sum is equal to the target.");
        }
    }
}
