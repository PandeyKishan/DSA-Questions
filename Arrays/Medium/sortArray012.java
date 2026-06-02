package Medium;
import java.util.*;

class Solution {
    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public int[] sortZeroOneTwo(int[] nums) {
        // Count of 0s, 1s, and 2s
        int cnt0 = 0, cnt1 = 0, cnt2 = 0;

        // First pass: Count the number of 0s, 1s, and 2s
        for (int num : nums) {
            if (num == 0) cnt0++;
            else if (num == 1) cnt1++;
            else cnt2++;
        }

        // Second pass: Fill the array with 0s, then 1s, then 2s

        // Fill the first 'cnt0' elements with 0
        for (int i = 0; i < cnt0; i++) {
            nums[i] = 0;
        }

        // Fill the next 'cnt1' elements with 1
        for (int i = cnt0; i < cnt0 + cnt1; i++) {
            nums[i] = 1;
        }

        // Fill the remaining elements with 2
        for (int i = cnt0 + cnt1; i < nums.length; i++) {
            nums[i] = 2;
        }

        return nums;
    }
 
    public int[] sortZeroOneTwoOptimal(int[] nums) {
        int low = 0, high = nums.length - 1;
        int mid = 0;

        while (mid <= high) {
            if (nums[mid] == 0) {
                swapElements(nums[low], nums[mid]);
                low++;
                mid++;
            } else if (nums[mid] == 1)
                mid++;
            else {
                swapElements(nums[mid], nums[high]);
                high--;
            }     
        }

        return nums;
    }

    public void swapElements(int element1, int element2) {
        int temp = element1;
        element1 = element2;
        element2 = temp;
    }
}

public class sortArray012 {
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

        int[] answer = sol.sortZeroOneTwo(arr);

        System.out.println("After sorting:");

        System.out.println("\nArray: " + Arrays.toString(answer));

        int[] result = sol.sortZeroOneTwoOptimal(arr);

        System.out.println("After sorting:");

        System.out.println("\n[Optimal] Array: " + Arrays.toString(result));
    }
}
