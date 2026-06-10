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
        int len = 0;

        for(int i = 0; i < n; i++) {
            xor ^= arr[i];

            // Case 1: Subarray from index 0 to i has XOR sum K
            if(xor == k)
                len = i + 1;

               // Case 2: Check if there is a prefix with XOR sum such that 
               // (prefix_xor ^ target_xor) == K => target_xor = prefix_xor ^ K
            else {
                if(map.containsKey(xor ^ k)) {
                    len = Math.max(len, i - map.get(xor ^ k));
                }

                // Only store the first occurrence of the prefix XOR to maximize length                
                if(!map.containsKey(xor)) {
                    map.put(xor, i);
                }
            }
        }

        return len;
        
    }
}

public class longestSubarrayWithXorK {
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

        int length = sol.countSubarrayPrefixSum(arr, k);
        System.out.println("\n[Prefix Sum] Longest subarray with XOR " + k + " has length: " + length);
    }
}