import java.util.*;

class Solution {
    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public int majorityElement(int[] nums) {
        
        // Size of the given array
        int n = nums.length;
        
        // Hash map to store element counts
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Count occurrences of each element
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        /* Iterate through the map to
           find the majority element */
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > n / 2) {
                return entry.getKey();
            }
        }
        
        // Return -1 if no majority element is found
        return -1;
    }
    public int majorityElementOptimal(int[] nums) {
        int count = 0, element = -1;

        // Step 1: Find the potential majority element
        // 2 2 1 2 2 1 3 3 3 2
        for(int i = 0; i < nums.length; i++) {
            if (count == 0) {                 
                element = nums[i];
                count++;
            } else if (nums[i] == element) 
                count++;
            else {
                count--;
            }
        }

        // Step 2: Verify the candidate - if the count of the majority element is greater than n / 2 then return count, if not then return -1
        int count1 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == element) {
                count1++;
            }
        }
        
        // Return the element if it's a majority
        if (count1 > (nums.length / 2)) {
            return element;
        }
        
        // No majority found
        return -1;
    }
}

public class majorityElement {
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

        int answer = sol.majorityElement(arr);

        System.out.println("\nThe majority element of the array is: " + answer);

        answer = sol.majorityElementOptimal(arr);

        System.out.println("\n[Optimal] The majority element of the array is: " + answer);
    }
}
