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

            // Output the element and its count
            System.out.println(arr.get(i) + " " + count);
        }
    }

    // Using hash map
    public void countFreqUsingHashMap(List<Integer> arr, int n) {
        // Create a HashMap to store frequency of each element
        HashMap<Integer, Integer> map = new HashMap<>();

        // Traverse the array and count frequencies
        for (int i = 0; i < n; i++) {
            map.put(arr.get(i), map.getOrDefault(arr.get(i), 0) + 1);
        }

        // Traverse through the HashMap and print frequencies
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}

public class countFrequency {

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

