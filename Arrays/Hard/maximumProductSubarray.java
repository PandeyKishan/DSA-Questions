import java.util.*;

class Solution {
    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * Works for: Positive, Negative, and Zeros.
     */
    public int maximumProductOptimalV1(int[] arr) {
        int n = arr.length;
        if(n == 1)
            return arr[0];
        int maxProduct = 0;
        int preProduct = 1;
        int suffProduct = 1;
        for (int i = 0; i < n; i++) {
            if(preProduct == 0) {
                preProduct = 1;
            }
            if(suffProduct == 0) {
                suffProduct = 1;
            }

            preProduct *= arr[i];
            suffProduct *= arr[n - i - 1];

            maxProduct = Math.max(maxProduct, Math.max(preProduct, suffProduct));
        }

        return maxProduct;
    }

    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     * Works for: Positive, Negative, and Zeros.
     */
    public int maximumProductOptimalV2(int[] nums) {
        int n = nums.length;
        int product = 0;
        int maxProduct = 1, minProduct = 1;

        for(int i = 0; i < n; i++) {
            int curr = nums[i];
            if(nums[i] < 0) {
                int temp = maxProduct;
                maxProduct = minProduct;
                minProduct = temp;
            }

            maxProduct = Math.max(curr, maxProduct * nums[i]); // 24
            minProduct = Math.min(curr, minProduct* nums[i]); // -48

            product = Math.max(product, (Math.max(maxProduct, minProduct))); // 24 

        }

        return product;
    }
}

public class maximumProductSubarray {
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

        int product = sol.maximumProductOptimalV1(arr);
        System.out.println("\n[OptimalV1] Maximum product of the subarray is: " + product);

        product = sol.maximumProductOptimalV2(arr);
        System.out.println("\n[OptimalV2] Maximum product of the subarray is: " + product);
    }
}