import java.util.*;

class Solution {
    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
        // Function to find maximum sum of subarrays
    public int maxSubArray(int[] nums) {
        /* Initialize maximum sum with
           the smallest possible integer */
        int maxi = Integer.MIN_VALUE;

        // Iterate over each starting index of subarrays
        for (int i = 0; i < nums.length; i++) {
            
            /* Variable to store the sum
               of the current subarray */
            int sum = 0; 
            
            /* Iterate over each ending index
               of subarrays starting from i */
            for (int j = i; j < nums.length; j++) {
                
                /* Add the current element nums[j] to
                   the sum i.e. sum of nums[i...j-1] */
                sum += nums[j];

                /* Update maxi with the maximum of its current
                   value and the sum of the current subarray */
                maxi = Math.max(maxi, sum);
            }
        }

        // Return the maximum subarray sum found
        return maxi;
    }
    /**
     * Kadane's Algorithm
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     *  The core idea is to traverse the array while maintaining a "local" sum that represents the best subarray sum ending at the  current position.
     */
    public int maxSubArrayOptimal(int[] nums) {
        int global_sum = Integer.MIN_VALUE, curr_sum = 0;
        for (int i = 0; i < nums.length; i++) {
            curr_sum += nums[i];
            global_sum = Math.max(global_sum, curr_sum);
            if(curr_sum < 0) {
                curr_sum = 0;
            }
        }
        return global_sum;
    }

    public int maxSubArrayPrintOptimal(int[] nums) {
        
        // Maximum sum
        long global_sum = Long.MIN_VALUE; 
        
        // Current sum of subarray
        long curr_sum = 0; 
        
        // Starting index of current subarray
        int start = 0; 
        
        // Indices of the maximum sum subarray
        int ansStart = -1, ansEnd = -1; 
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            
            // Update starting index if sum is reset
            if (curr_sum == 0) {
                start = i;
            }
            
            // Add current element to the sum
            curr_sum += nums[i]; 
            
            // Update global_sum and subarray indices if current sum is greater
            if (curr_sum > global_sum) {
                global_sum = curr_sum;
                ansStart = start;
                ansEnd = i;
            }
            
            // Reset sum to 0 if it becomes negative
            if (curr_sum < 0) {
                curr_sum = 0;
            }
        }
        // Printing the subarray - when we just need to print it, there's no need to create a new array and store it. We can just use the two index (start and end) to print the subarray.
        System.out.print("The subarray is: [");
        for (int i = ansStart; i <= ansEnd; i++) {
            System.out.print(nums[i] + ", ");
        }
        System.out.println("]");

        // Return the maximum subarray sum found
        return (int) global_sum;
    }
}

public class maximumSubarraySum {
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

        int answer = sol.maxSubArray(arr);

        System.out.println("\nMax subarray of the array is: " + answer);

        answer = sol.maxSubArrayOptimal(arr);

        System.out.println("\n[Optimal] Max subarray of the array is: " + answer);

        answer = sol.maxSubArrayPrintOptimal(arr);

        System.out.println("\n[Optimal] Max subarray of the array is: " + answer);
    }
}

/*   When to Identify This Pattern
  You should consider Kadane's or a similar "running sum" approach when a problem asks for:

   1. Contiguous Subsegments: The problem specifically mentions "subarray" or "contiguous" elements.
   2. Optimization (Max/Min): You need to find the maximum or minimum sum, product, or length of such a subsegment.
   3. Linear Time Requirement: You are looking for an $O(N)$ solution instead of O(N²).
   4. "Worth it to continue?" Logic: The problem allows you to decide at each step whether to extend the current "chain" or start a new one
      (e.g., "If I add this element, am I better off than if I started fresh?").

  Variations of this Pattern
   * Maximum Product Subarray: Similar logic, but you track both the max and min products (because two negatives make a positive).
   * Circular Subarray Sum: Use Kadane's to find the max subarray and also use it to find the minimum subarray to calculate the
     "wrap-around" sum.
   * Smallest Subarray Sum: Flip the logic to reset when curr_sum becomes positive. */