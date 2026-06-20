import java.util.*;

class Solution {
    /**
     * Approach 1: Sliding Window (Optimal)
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int maximumConsecutiveOneIIIOptimal(int[] nums, int k) {
        int i = 0, j = 0;
        int currCount, maxCount = 0, count0 = 0;

        while(j < nums.length) {
            if(nums[j] == 0) {
                count0++;
                while(count0 > k) {
                    if(nums[i] == 0)
                        count0--;
                    i++;
                }
            }    
            currCount = (j - i + 1);
            maxCount = Math.max(maxCount, currCount);
            j++;
        }    
        
        return maxCount;
    }
}

public class maximumConsecutiveOneIII {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.println("Enter size of array (only 0's and 1's): ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter number " + (i + 1) + ":");
            arr[i] = sc.nextInt();
        }

        System.out.println("Enter no. of flips allowed (only 0's): ");
        int k = sc.nextInt();

        int resultOptimal = sol.maximumConsecutiveOneIIIOptimal(arr, k);
        System.out.println("\n[Optimal - Sliding Window] The maximum consecutive ones in the array (after flips): " + resultOptimal);
    }
}
