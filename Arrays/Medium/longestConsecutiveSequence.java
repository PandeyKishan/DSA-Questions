import java.util.*;

class Solution {
    /**
     * Time Complexity: O(NLogn)
     * Space Complexity: O(1)
     */

    public int longestSequenceBrute(int[] nums, int n) {
        if (nums.length == 0)
            return 0;
        int curr_length = 1, max_length = 0;
        // ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        System.out.println("\nArray: " + Arrays.toString(nums));
        for (int i = 1; i < n; i++) {
            if(nums[i] == nums[i - 1]) {
                continue;
            } else if (nums[i] == nums[i - 1] + 1) {
                curr_length++;
            } else {
                max_length = Math.max(curr_length, max_length);
                curr_length = 1;
            }    
        }
        max_length = Math.max(curr_length, max_length);
        return max_length;
    }
    // [100, 4, 200, 1, 3, 2]
    // result = [1, 2, 3, 4, 100, 200]
    // [1 -> 1, 2 -> 1, 3 -> 1, 4 -> 1, 100 -> 1, 200 -> 1]

    /**
     * Time Complexity: O(NLogn)
     * Space Complexity: O(N)
     */
    public int longestSequenceBetter(int[] nums, int n) {
        if (nums.length == 0)
            return 0;

        int currLength = 1;
        int maxLength = 1;

        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Integer prev = null;

        for (Integer key : map.keySet()) {
            if (prev != null) {
                if (key == prev + 1) {
                    currLength++;
                } else {
                    maxLength = Math.max(maxLength, currLength);
                    currLength = 1;
                }
            }
            prev = key;
        }

        maxLength = Math.max(maxLength, currLength);

        return maxLength;
    }
    
    /**
     * Time Complexity: O(N)
     * Space Complexity: O(N)
     */
    public int longestSequenceOptimal(int[] nums, int n) {
        if (nums.length == 0)
            return 0;

        int currLength;
        int maxLength = 1;

        HashSet<Integer> set = new HashSet<>();

        for (int i = 0; i < n; i++) {
            set.add(nums[i]);
        }

        for(int num: set) {
            if(!set.contains(num - 1)) {
                int currentNum = num;
                currLength = 1;    
                while (set.contains(currentNum + 1)) {
                    currentNum++;
                    currLength++;
                }
                maxLength = Math.max(currLength, maxLength); 
            }   
        }
        return maxLength;
    }
}

public class longestConsecutiveSequence {
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

        int answer = sol.longestSequenceBrute(arr, n);

        System.out.println("\n[Brute Force] The longest consecutive sequence of the array has a length of: " + answer);

        answer = sol.longestSequenceBetter(arr, n);

        System.out.println("\n[Better] The longest consecutive sequence of the array has a length of: " + answer);

        answer = sol.longestSequenceOptimal(arr, n);

        System.out.println("\n[Optimal] The longest consecutive sequence of the array has a length of: " + answer);
    }
}
