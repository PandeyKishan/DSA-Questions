import java.util.*;

class Solution {
    /**
     * Approach 1: Bucket Hashing (Optimal)
     * Time Complexity: O(N)
     * Space Complexity: O(min(N, indexDiff))
     */
    public boolean containsDuplicateIIIOptimal(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length < 2 || indexDiff <= 0 || valueDiff < 0) {
            return false;
        }

        // Map to store bucketId -> actual value in the sliding window
        Map<Long, Long> map = new HashMap<>();
        long width = (long) valueDiff + 1;

        for (int i = 0; i < nums.length; i++) {
            long val = (long) nums[i];
            long bucketId = getBucketId(val, width);

            // If the same bucket already has an element, their difference is <= valueDiff
            if (map.containsKey(bucketId)) {
                return true;
            }

            // Check adjacent bucket on the left
            if (map.containsKey(bucketId - 1) && Math.abs(val - map.get(bucketId - 1)) <= valueDiff) {
                return true;
            }

            // Check adjacent bucket on the right
            if (map.containsKey(bucketId + 1) && Math.abs(val - map.get(bucketId + 1)) <= valueDiff) {
                return true;
            }

            // Add the current element to the map
            map.put(bucketId, val);

            // Maintain sliding window of size indexDiff
            if (i >= indexDiff) {
                long lastVal = (long) nums[i - indexDiff];
                long lastBucketId = getBucketId(lastVal, width);
                map.remove(lastBucketId);
            }
        }

        return false;
    }

    private long getBucketId(long val, long width) {
        return val < 0 ? (val + 1) / width - 1 : val / width;
    }

    /**
     * Approach 2: TreeSet / Balanced BST (Better)
     * Time Complexity: O(N log(min(N, indexDiff)))
     * Space Complexity: O(min(N, indexDiff))
     */
    public boolean containsDuplicateIIIBetter(int[] nums, int indexDiff, int valueDiff) {
        if (nums == null || nums.length < 2 || indexDiff <= 0 || valueDiff < 0) {
            return false;
        }

        TreeSet<Long> set = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long val = (long) nums[i];

            // Find the smallest element >= val - valueDiff
            Long ceiling = set.ceiling(val - valueDiff);

            // If such element exists and is <= val + valueDiff
            if (ceiling != null && ceiling <= val + valueDiff) {
                return true;
            }

            set.add(val);

            // Maintain sliding window of size indexDiff
            if (i >= indexDiff) {
                set.remove((long) nums[i - indexDiff]);
            }
        }

        return false;
    }
}

public class containsDuplicateIII {
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

        System.out.println("Enter indexDiff: ");
        int indexDiff = sc.nextInt();

        System.out.println("Enter valueDiff: ");
        int valueDiff = sc.nextInt();

        System.out.println("\nArray: " + Arrays.toString(arr));
        System.out.println("indexDiff: " + indexDiff + ", valueDiff: " + valueDiff);

        boolean resultOptimal = sol.containsDuplicateIIIOptimal(arr, indexDiff, valueDiff);
        System.out.println("\n[Optimal - Bucket Hashing] Contains duplicate: " + resultOptimal);

        boolean resultBetter = sol.containsDuplicateIIIBetter(arr, indexDiff, valueDiff);
        System.out.println("[Better - TreeSet] Contains duplicate: " + resultBetter);
    }
}
