import java.util.*;

class Solution {
    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public int[] findNextPermuation(int[] nums, int n) {
        int index = -1;
        // Find the first decreasing element from end
        for (int i = n - 2; i >= 0; i--) {
            // If smaller found, store it
            if(nums[i + 1] > nums[i]) {
                index = i;
                break;
            }
        }

        // If no index found, reverse the entire array
        if (index == -1) {
            reverse(nums, 0, n - 1);
            return nums;
        }

        // Find just larger element after first small element found
        for(int j = n - 1; j > index; j--) {
            // Swap them
            if(nums[j] > nums[index]) {
                swap(nums, index, j);
                break;
            }
        }

        // Reverse part after index
        reverse(nums, index + 1, n - 1);
        return nums;
    }

    public void swap(int[]nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }
}

public class findNextPermuation {
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

        int[] answer = sol.findNextPermuation(arr, n);

        System.out.println("\n[Optimal] Next possible permutation of the given array will be: " + Arrays.toString(answer));

        // answer = sol.alternateSignArrayBrute(arr, n);

        // System.out.println("\n[Brute Force] Array with alternate positive and negative is: " + Arrays.toString(answer));
    }
}
