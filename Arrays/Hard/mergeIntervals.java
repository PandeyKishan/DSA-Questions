import java.util.*;

class Solution {
    /**
     * Cyclic Sort Approach (Optimal Space)
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public List<List<Integer>> mergeIntervalsBrute(int[][] intervals) {
        List<List<Integer>> result = new ArrayList<>();
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        int i = 0;
        
        while (i < n) {
            // Start of merged interval
            int start = intervals[i][0];
            int end = intervals[i][1];

            int j = i + 1;

            // Check all overlapping intervals
            while (j < n && intervals[j][0] <= end) {
                // Extend the end of current interval
                end = Math.max(end, intervals[j][1]);
                j++;
            }

            // Add merged interval to result
        
            result.add(Arrays.asList(start, end));

            // Move to next non-overlapping interval
            i = j;
        }

        return result;
    }

    public List<List<Integer>> mergeIntervalsOptimal(int[][] intervals) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        for(int[] interval: intervals) {
            if(result.isEmpty() || result.get(result.size() - 1).get(1) < interval[0]) {
                result.add(Arrays.asList(interval[0], interval[1]));
            } else {
                int last = result.size() - 1;
                int max = Math.max(result.get(last).get(1), interval[1]);
                result.get(last).set(1, max);
            }
        }

        return result;
    }
}

public class mergeIntervals {
    public static void main(String[] args) {
        int[][] matrix = {{1,3},{2,6},{8,10},{15,18}};
        Solution sol = new Solution();

        System.out.println("\nOriginal Array: " + Arrays.toString(matrix));
        
        List<List<Integer>> result = sol.mergeIntervalsBrute(matrix);
        System.out.println("\n[Brute Force] After merging the intervals: " + result);

        result = sol.mergeIntervalsOptimal(matrix);
        System.out.println("[Optimal Approach] After merging the intervals: " + result);
    }
}
