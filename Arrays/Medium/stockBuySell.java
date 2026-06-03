import java.util.*;

class Solution {
    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public int maximumProfitOptimal(int[] nums) {
        // if (nums == null || nums.length < 2) return 0;
        // int profit, max_profit = 0;
        // int i = 0, j = 1, curr_min = nums[0];
        // while (j < nums.length) {
        //     profit = nums[j] - nums[i];
        //     max_profit = Math.max(profit, max_profit);
        //     if (nums[j] < curr_min) {
        //         curr_min = nums[j];
        //         i = j;
        //     }
        //     j++;
        // }
        // return max_profit;

        int minPrice = Integer.MAX_VALUE;

        // Initialize the maximum profit to 0
        int maxProfit = 0;

        // Traverse each price in the array
        for (int price : nums) {
            // If current price is less than minPrice, update minPrice
            if (price < minPrice) {
                minPrice = price;
            }
            // Else calculate profit and update maxProfit if it's greater
            else {
                maxProfit = Math.max(maxProfit, price - minPrice);
            }
        }

        // Return the maximum profit found
        return maxProfit;
    } // [7,1,5,3,6,4]
      //  i j
}

public class stockBuySell {
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

        int answer = sol.maximumProfitOptimal(arr);

        System.out.println("\n[Optimal] Max profit after buying and selling is: " + answer);
    }
}