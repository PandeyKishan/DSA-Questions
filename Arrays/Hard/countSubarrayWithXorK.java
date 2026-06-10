import java.util.*;

class Solution {
    /**
     * Prefix Sum + HashMap Approach
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int countSubarrayPrefixSum(int[] arr, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int xor = 0;
        int n = arr.length;
        int count = 0;

        map.put(0, 1);
        for(int i = 0; i < n; i++) {
            // Update prefix XOR
            xor ^= arr[i];

            // Compute required XOR
            int remove = xor ^ k;

            count += map.getOrDefault(remove, 0);

            // If target exists in map, add its frequency
            // if (freq.containsKey(target)) {
            //     count += freq.get(target);
            // }
            
            // Store current prefix XOR in map
            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }
        return count;
    }
}

public class countSubarrayWithXorK {
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
        
        // For longestSubarrayWithSum0, we usually assume k = 0
        System.out.println("\nEnter XOR to be checked: ");
        int k = sc.nextInt();

        int count = sol.countSubarrayPrefixSum(arr, k);
        System.out.println("\n[Prefix Sum] The number of subarrays with target " + k + ": " + count);
    }
}
