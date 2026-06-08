import java.util.*;

class Solution {
    /**
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     * Works for: Positive, Negative, and Zeros.
     */
    public List<Integer> majorityElementsBetter(int[] arr) {
        int n = arr.length;
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int min = n / 3 + 1; 
        
        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);

            // Add to result only when the count just reaches mini
            if (map.get(arr[i]) == min) {
                result.add(arr[i]);
            }
        }

        // If all number from 1 to n are present then n+1 
        // is smallest missing number
        return result;
    }

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * Works for: Positive, Negative, and Zeros.
     */
    public List<Integer> majorityElementsOptimal(int[] nums) {
        int count1 = 0, count2 = 0; // Counters for the potential majority elements
        int candidate1 = 0, candidate2 = 0; // Potential majority element candidates

        // First pass to find potential majority elements.
        for (int i = 0; i < nums.length; i++) {
            // If count1 is 0 and the current number is not equal to candidate2, update candidate1.
            if (count1 == 0 && nums[i] != candidate2) {
                count1 = 1;
                candidate1 = nums[i];               // [1 2 1 1 3 3 3]
            }                                       // 
                                                    // count1 = 2, candidate1 = 1
                                                    // count2 = 3, candidate2 = 3
            // If count2 is 0 and the current number is not equal to candidate1, update candidate2.
            else if (count2 == 0 && nums[i] != candidate1) {
                count2 = 1;
                candidate2 = nums[i];
            } 
            // Update counts for candidate1 and candidate2.
            else if (candidate1 == nums[i]) {
                count1++;
            } else if (candidate2 == nums[i]) {
                count2++;
            } 
            // If the current number is different from both candidates, decrement their counts.
            else {
                count1--;
                count2--;
            }
        }

        List<Integer> result = new ArrayList<>();
        int threshold = nums.length / 3; // Threshold for majority element

        // Second pass to count occurrences of the potential majority elements.
        count1 = 0;
        count2 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (candidate1 == nums[i]) {
                count1++;
            } else if (candidate2 == nums[i]) {
                count2++;
            }
        }

        // Check if the counts of potential majority elements are greater than n/3 and add them to the result.
        if (count1 > threshold) {
            result.add(candidate1);
        }
        if (count2 > threshold && candidate2 != candidate1) {
            result.add(candidate2);
        }

        return result;
    }
}

public class majorityElementV2 {
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

        List<Integer> result = sol.majorityElementsBetter(arr);
        System.out.println("\n[Better] Majority element(s) in the array is: " + result);

        result = sol.majorityElementsOptimal(arr);
        System.out.println("\n[Optimal] Majority element(s) in the array is: " + result);
    }
}
