import java.util.*;

class Solution {
    /**
     * Cyclic Sort Approach (Optimal Space)
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public List<Integer> findTheNumbers(int[] arr, int n) {
        List<Integer> result = new ArrayList<>();
        int[] nums = Arrays.copyOf(arr, n); // Use a copy to keep original array intact for comparison
        
        for(int i = 0; i < n; i++) {
            while (nums[i] >= 1 && nums[i] <= n && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[nums[i] - 1];
                nums[temp - 1] = temp;
            }
        }

        for (int i = 1; i <= n; i++) {
            if(i != nums[i - 1]) {
                result.add(nums[i - 1]); // Repeating
                result.add(i);           // Missing
            }    
        }

        return result;
    }

    /**
     * XOR Approach (Optimal - No array modification)
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int[] findTheNumbersXOR(int[] arr, int n) {
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= arr[i];
            xor ^= (i + 1);
        }

        // Get the rightmost set bit
        int setBit = xor & -xor;
        int x = 0, y = 0;

        // Partition elements and numbers into two groups
        for (int i = 0; i < n; i++) {
            // Group based on the set bit
            if ((arr[i] & setBit) != 0) 
                x ^= arr[i];
            else 
                y ^= arr[i];

            // to remove the existing elements / non-repeating elements to get the missing / repeating elements, we XOR with (i + 1) as well to get an odd number of element value such that they are the only ones left and the pairs get cancelled out after XOR'ing. 
            if (((i + 1) & setBit) != 0) 
                x ^= (i + 1);
            else 
                y ^= (i + 1);
        }

        // Check which one is repeating
        int count = 0;
        for (int num : arr) {
            if (num == x) 
                count++;
        }

        if (count == 2) 
            return new int[]{x, y}; // x is repeating, y is missing

        return new int[]{y, x}; // y is repeating, x is missing
    }
}

public class findRepeatingMissing {
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

        System.out.println("\nOriginal Array: " + Arrays.toString(arr));
        
        // 1. Cyclic Sort Approach
        List<Integer> resultCyclic = sol.findTheNumbers(arr, n);
        System.out.println("\n[Cyclic Sort - Brute Force] Repeating and Missing: " + resultCyclic);

        // 2. XOR Approach
        int[] xorResult = sol.findTheNumbersXOR(arr, n);
        System.out.println("[XOR Approach - Optimal Approach] Repeating and Missing: [" + xorResult[0] + ", " + xorResult[1] + "]");
    }
}
