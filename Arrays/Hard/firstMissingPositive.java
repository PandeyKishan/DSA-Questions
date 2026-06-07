import java.util.*;

class Solution {
    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * Works for: Positive, Negative, and Zeros.
     */
    public int firstMissingPositiveOptimal(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            // if arr[i] is within the range [1, n] and arr[i]
            // is not placed at (arr[i]-1)th index in arr
            while (arr[i] >= 1 && arr[i] <= n
                   && arr[i] != arr[arr[i] - 1]) {

                // then swap arr[i] and arr[arr[i]-1] to
                // place arr[i] to its corresponding index
                int temp = arr[i];
                arr[i] = arr[arr[i] - 1];
                arr[temp - 1] = temp; // if we do arr[arr[i] - 1], it will fail as the value of arr[i] has changed now, so it can't be used, so we do arr[temp - 1] since the inner arr[i] from the arr[arr[i] - 1] expression already has the original value in temp.
            }
        }

        // If any number is not at its corresponding index 
        // then it is the missing number
        for (int i = 1; i <= n; i++) {
            if (i != arr[i - 1]) {
                return i;
            }
        }

        // If all number from 1 to n are present then n+1 
        // is smallest missing number
        return n + 1;
    }

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * Works for: Positive, Negative, and Zeros.
     */
    public int firstMissingPositiveOptimalV2(int[] nums) {
        int n = nums.length;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            if(nums[i] == 1) {
                flag = true;
                break;
            }
        }
        if(!flag)
            return 1;
        
        for(int i = 0; i < n; i++) {
            if(nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }

        for(int i = 0; i < n; i++) {
            nums[(nums[i] - 1) % n] += n;
        }

        for(int i = 0; i < n; i++) {
            if(nums[i] <= n)
                return i + 1;
        }

        // If all number from 1 to n are present then n+1 
        // is smallest missing number
        return n + 1;
    }
}

public class firstMissingPositive {
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

        int number = sol.firstMissingPositiveOptimal(arr);
        System.out.println("\n[Optimal] Number missing from the array is: " + number);

        number = sol.firstMissingPositiveOptimalV2(arr);
        System.out.println("\n[OptimalV2] Number missing from the array is: " + number);
    }
}