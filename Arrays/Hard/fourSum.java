import java.util.*;

class Solution {
    /**
     * Time Complexity: O(N^3)
     * Space Complexity: O(no. of quadruplets)
     */
    public List<List<Integer>> fourSumOptimal(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        if (n < 4) return ans;

        // Sort the array to use two-pointer technique
        Arrays.sort(nums);

        for (int i = 0; i < n; i++) {
            // Skip duplicates for the first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            for (int j = i + 1; j < n; j++) {
                // Skip duplicates for the second element
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;

                // Two pointers
                int left = j + 1;
                int right = n - 1;
                
                while (left < right) {
                    // Use long to avoid overflow for large sums
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if (sum == target) {
                        ans.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        left++;
                        right--;

                        // Skip duplicate elements for left and right pointers
                        while (left < right && nums[left] == nums[left - 1]) left++;
                        while (left < right && nums[right] == nums[right + 1]) right--;
                    } else if (sum < target) {
                        left++;
                    } else {
                        right--;
                    }
                }
            }
        }
        return ans;
    }

    /**
     * Time Complexity: O(N^3 * log(N))
     * Space Complexity: O(2 * no. of the quadruplets) + O(N)
     */
    public List<List<Integer>> fourSumBetter(int[] arr, int target) {
        int n = arr.length;
        Set<List<Integer>> set = new HashSet<>();

        // First loop - pick first number
        for (int i = 0; i < n; i++) {
            // Second loop - pick second number
            for (int j = i + 1; j < n; j++) {
                // HashSet for numbers between j and k
                HashSet<Integer> seen = new HashSet<>();

                // Third loop - pick third number
                for (int k = j + 1; k < n; k++) {
                    // Find required fourth number
                    long required = (long) target - arr[i] - arr[j] - arr[k];

                    // If required number already seen → valid quadruplet
                    if (seen.contains((int) required)) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], (int) required);
                        Collections.sort(temp);
                        set.add(temp);
                    }

                    // Add current third number into set
                    seen.add(arr[k]);
                }
            }
        }
        return new ArrayList<>(set);
    }
}

public class fourSum {
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

        List<List<Integer>> result = sol.fourSumOptimal(arr, target);
        System.out.println("\n[Optimal] Triplets that sum to " + target + " are: " + result);

        result = sol.fourSumBetter(arr, target);
        System.out.println("\n[Better] Triplets that sum to " + target + " are: " + result);
    }
}
