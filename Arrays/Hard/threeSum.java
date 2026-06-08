import java.util.*;

class Solution {
    /**
     * Time Complexity: O(N^2)
     * Space Complexity: O(1) (ignoring the result list)
     * Works for: Positive, Negative, and Zeros.
     */
    public List<List<Integer>> threeSumOptimal(int[] nums, int target) {
    //     List<List<Integer>> result = new ArrayList<>();
    //     int n = nums.length;

    //     Arrays.sort(nums);

    //     for (int i = 0; i < n; i++) {
    //         if (i > 0 && nums[i] == nums[i - 1])
    //             continue;

    //         // complement_a should be (target - nums[i]) to satisfy a + b + c = target
    //         int complement_a = target - nums[i];
    //         int j = i + 1, k = n - 1;

    //         while (j < k) {
    //             if (nums[j] + nums[k] == complement_a) {
    //                 // Create new subList inside the loop to avoid merging multiple triplets
    //                 List<Integer> subList = new ArrayList<>();
    //                 subList.add(nums[i]);
    //                 subList.add(nums[j]);
    //                 subList.add(nums[k]);
    //                 result.add(subList);

    //                 j++;
    //                 k--;
    //                 while (j < k && nums[j] == nums[j - 1])
    //                     j++;
    //                 while (j < k && nums[k] == nums[k + 1])
    //                     k--;
    //             } else if (nums[j] + nums[k] < complement_a) {
    //                 j++;
    //             } else { // Fixed: Changed from duplicate 'else if' to 'else' to handle the > case
    //                 k--;
    //             }
    //         }
    //     }

    //     return result;
    // }
        
        int n = nums.length - 1;
        // Sort the array
        Arrays.sort(nums);
        // Store final result
        List<List<Integer>> ans = new ArrayList<>();

        // First loop for first element
        for (int i = 0; i < n; i++) {
            // Skip duplicates for first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            // Two pointers
            int left = i + 1, right = n - 1;

            // Find pairs for current arr[i]
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    ans.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    left++;
                    right--;

                    // Skip duplicates for left
                    while (left < right && nums[left] == nums[left - 1]) left++;
                    // Skip duplicates for right
                    while (left < right && nums[right] == nums[right + 1]) right--;
                }
                else if (sum < target) left++;
                else right--;
            }
        }
        return ans;
    }

    public List<List<Integer>> threeSumBetter(int[] arr, int target) {
        int n = arr.length - 1;
        // Store unique triplets
        Set<List<Integer>> ans = new HashSet<>();

        // First loop for first element
        for (int i = 0; i < n; i++) {
            // Set to store elements seen in this iteration
            Set<Integer> hashset = new HashSet<>();

            // Second loop for second element
            for (int j = i + 1; j < n; j++) {
                // Calculate third element needed
                int third = -(arr[i] + arr[j]); // -4 -1 -1 0 1 2

                // If third already in set, we found a triplet
                if (hashset.contains(third)) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], third);
                    Collections.sort(temp);
                    ans.add(temp);
                }

                // Add current element to set
                hashset.add(arr[j]);
            }
        }

        // Convert set to list
        return new ArrayList<>(ans);
    }
}

public class threeSum {
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

        System.out.println("Enter target (mainly 0): ");
        int target = sc.nextInt();

        System.out.println("\nArray: " + Arrays.toString(arr));

        List<List<Integer>> result = sol.threeSumOptimal(arr, target);
        System.out.println("\n[Optimal] Triplets that sum to " + target + " are: " + result);

        result = sol.threeSumBetter(arr, target);
        System.out.println("\n[Better] Triplets that sum to " + target + " are: " + result);
    }
}
