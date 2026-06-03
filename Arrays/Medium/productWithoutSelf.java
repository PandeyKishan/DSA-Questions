import java.util.*;

class Solution {
    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public int[] productWithoutSelfOptimal(int[] nums, int n) {
        int[] productArray = new int[n];

        productArray[0] = 1;
        for (int i = 1; i < n; i++) {
            productArray[i] = productArray[i - 1] * nums[i - 1];
        }

        int suffixProduct = 1;

        for (int i = n - 1; i >= 0; i--) {
            productArray[i] = productArray[i] * suffixProduct;
            suffixProduct = suffixProduct * nums[i];
        }

        return productArray;
    }

    public int[] productWithoutSelfDivisionOptimal(int[] nums, int n) {
        int[] productArray = new int[n];
        Arrays.fill(productArray, 0);

        int product = 1;
        int count0 = 0, index0 = 0;
        
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                count0++;
                index0 = i;
            } else {
                product *= nums[i];
            }
        }

        if (count0 == 1) {
            productArray[index0] = product;
        } else {
            for(int i = 0; i < n; i++) {
                productArray[i] = product / nums[i];
            }
        }

        return productArray;
    }
}

public class productWithoutSelf {
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

        int[] productArray = sol.productWithoutSelfOptimal(arr, n);

        System.out.println("\n[Optimal] Product Array: " + Arrays.toString(productArray));

        productArray = sol.productWithoutSelfDivisionOptimal(arr, n);

        System.out.println("\n[Division] Product Array: " + Arrays.toString(productArray));
    }
}