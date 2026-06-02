import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

class Solution {
    // Function to count frequency of each element in the array

    // Using boolean array
    public void countFreqUsingBooleanArray(List<Integer> arr, int n) {
        // Create a visited array to mark elements that are already processed
        List<Boolean> visited = new ArrayList<>(Collections.nCopies(n, false));
        int maxFreq = 0, minFreq = n;       // Frequency bounds initialization
        int maxEle = 0, minEle = 0;         // Elements with max and min frequency

        // boolean[] visited = new boolean[n]; -> In Competitive Programming and DSA, if you know the size n, it is much simpler and faster to use a primitive boolean array.

        // Traverse through all elements of the array
        for (int i = 0; i < n; i++) {
            // Skip this element if it's already processed
            if (visited.get(i))
                continue;

            // Count the frequency of arr[i]
            int count = 1;
            for (int j = i + 1; j < n; j++) {
                if (arr.get(i).equals(arr.get(j))) {
                    visited.set(j, true); // Mark arr[j] as processed
                    count++;
                }
            }

            // Update max frequency and corresponding element
            if (count > maxFreq) {
                maxEle = arr.get(i);
                maxFreq = count;
            }

            // Update min frequency and corresponding element
            if (count < minFreq) {
                minEle = arr.get(i);
                minFreq = count;
            }
        }
        // Print final results
        System.out.println("\nThe highest frequency element is: " + maxEle);
        System.out.println("The lowest frequency element is: " + minEle);
    }

    // Using hash map
    public void countFreqUsingHashMap(List<Integer> arr, int n) {
        // Create a HashMap to store frequency of each element
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse the array and count frequencies
        for (int i = 0; i < n; i++) {
            map.put(arr.get(i), map.getOrDefault(arr.get(i), 0) + 1);
        }

        int maxFreq = 0, minFreq = n;
        int maxEle = 0, minEle = 0;

        // Traverse map to find min and max frequency elements
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int element = entry.getKey();
            int count = entry.getValue();

            if (count > maxFreq) {
                maxFreq = count;
                maxEle = element;
            }

            if (count < minFreq) {
                minFreq = count;
                minEle = element;
            }
        }

        // Print results
        System.out.println("\nThe highest frequency element is: " + maxEle);
        System.out.println("The lowest frequency element is: " + minEle);
    }
}

public class highestLowestFrequency {

    public static void main(String[] args) {
        // Input array
        Scanner sc = new Scanner(System.in);

        int n;
        System.out.print("Enter size of array: ");
        n = sc.nextInt();
        List<Integer> array = new ArrayList<>();
        while (array.size() < n) {
            System.out.print("Enter number " + (array.size() + 1) + ": " );
            array.add(sc.nextInt());
        }

        // Create Solution instance
        Solution sol = new Solution();

        // Call the function to count frequencies
        System.out.print("Using visited boolean array: ");
        sol.countFreqUsingBooleanArray(array, n);

        System.out.print("\nUsing hash map: ");
        sol.countFreqUsingHashMap(array, n);
    }
}


