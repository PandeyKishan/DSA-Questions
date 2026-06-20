import java.util.*;

class Solution {
    /**
     * Approach 1: Hash Set (Optimal)
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public boolean containsDuplicateIIOptimal(int[] nums, int k) {
        if(k == 0)
            return false;

        HashSet<Integer> set = new HashSet<>();

        for(int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i])) {
                return true;
            } 

            if(i >= k) {
                set.remove(nums[i - k]);
            }
        }

        // for(int i = 0; i < nums.length; i++) {
        //     if(!set.contains(nums[i])) {
        //         if(i >= k)
        //             set.remove(nums[i - k]);
        //         set.add(nums[i]);    
        //     } else {
        //         return true;
        //     }    
        // }

        return false;
    }

    /**
     * Approach 1: Hash Map (Optimal)
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public boolean containsDuplicateIIOptimalV2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(!map.containsKey(nums[i])) {
                map.put(nums[i], i);
            } else {
                int j = map.get(nums[i]);
                if(Math.abs(i - j) <= k) {
                    return true;
                } else {
                    map.put(nums[i], i);
                }
            }
        }

        return false;
    }
}

public class containsDuplicateII {
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

        System.out.println("Enter k: ");
        int k = sc.nextInt();

        boolean resultOptimal = sol.containsDuplicateIIOptimal(arr, k);
        System.out.println("\n[Optimal - HashSet] Contains duplicate: " + resultOptimal);

        boolean resultOptimalV2 = sol.containsDuplicateIIOptimalV2(arr, k);
        System.out.println("[Optimal - HashMap] Contains duplicate: " + resultOptimalV2);
    }
}
