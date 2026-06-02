package Easy;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

import Solution;

class Solution {

    // Time Complexity: O(N), Space Complexity: O(N)
    public int removeDuplicatesUsingHashMap(int[] arr, int n) {
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }

        int i = 0;
        for (Map.Entry<Integer, Integer> it : map.entrySet()) {
            arr[i] = it.getKey();
            i++;
        }

        return i;
    }

    // Time Complexity: O(N), Space Complexity: O(N)
    public int removeDuplicatesUsingSet(int[] nums) {
        // HashSet to store unique elements we have seen
        HashSet<Integer> seen = new HashSet<>();

        // Position to overwrite next unique element
        int index = 0;

        // Loop over each number in nums
        for (int num : nums) {
            // If num is not in the set, it is unique
            if (!seen.contains(num)) {
                // Add num to the set
                seen.add(num);

                // Write num at current index position
                nums[index] = num;

                // Move index forward
                index++;
            }
        }
        // Return number of unique elements
        return index;
    }

    // Time Complexity: O(N), Space Complexity: O(1)
    public int removeDuplicatesOptimal(int[] nums, int n) {
        // If array is empty, return 0
        if (nums.length == 0) return 0;

        // Pointer for last unique element
        int i = 0;

        // Start from second element
        for (int j = 1; j < n; j++) {
            // If new unique element is found
            if (nums[j] != nums[i]) {
                // Move unique position forward
                i++;
                // Place new unique element
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }            
}

public class removeDuplicates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        System.out.println("Enter size of array: ");
        int n;
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter number " + (i + 1) + ":");
            arr[i] = sc.nextInt();
        }
        int[] nums = arr.clone();
        int[] array = arr.clone();
        System.err.print("Array: ");
        for (int number : arr) {
            System.err.print(+ number + " ");
        }

        int count = sol.removeDuplicatesUsingHashMap(arr, n);

        System.err.println("Array: ");
        for (int number : arr) {
            System.err.print(+ number + " ");
        }

        System.out.println("Count of unique elements: " + count);

        count = sol.removeDuplicatesOptimal(nums, n);

        System.err.println("Array: ");
        for (int number : nums) {
            System.err.print(+ number + " ");
        }

        System.out.println("Count of unique elements: " + count);

        count = sol.removeDuplicatesUsingSet(array);

        System.err.println("Array: ");
        for (int number : nums) {
            System.err.print(+ number + " ");
        }

        System.out.println("Count of unique elements: " + count);
    }    
}


/* We can implement a two pointer strategy to optimize the space. Since the array is sorted, we know that all the duplicate values will be adjacent to each other.
Begin at the first position, which will always be part of the final unique list.
Move through the list one item at a time, comparing the current item with the most recently kept unique item.
If the current item is the same as the last kept one, skip it because it’s a duplicate.
If it’s different, place it right after the last kept unique item to keep all unique values grouped at the front.
Continue until every element in the list has been checked. The first part of the list now contains all the unique values in their original order, and the rest can be ignored. */