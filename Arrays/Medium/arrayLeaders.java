import java.util.*;

class Solution {
    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public List<Integer> leadersInAnArray(int[] nums, int n) {
        List<Integer> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        int curr_max = Integer.MIN_VALUE;
        for(int i = n - 1; i >= 0; i--) {
            if (nums[i] >= curr_max) {
                curr_max = nums[i];
                result.addFirst(curr_max);
            }
        }
        return result;
    }
    // [4, 7, 1, 0] 
    // result = [7,1,0]
}

public class arrayLeaders {
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

        List<Integer> answer = sol.leadersInAnArray(arr, n);

        System.out.println("\n[Optimal] Leaders in an array are: " + answer);

        // answer = sol.alternateSignArrayBrute(arr, n);

        // System.out.println("\n[Brute Force] Array with alternate positive and negative is: " + Arrays.toString(answer));
    }
}
