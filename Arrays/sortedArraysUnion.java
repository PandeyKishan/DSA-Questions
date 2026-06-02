import java.util.*;

class Solution {
    // Function to find union of two sorted arrays using two pointers
    public List<Integer> sortedArraysUnion(int[] arr1, int[] arr2) {
        // List to store union elements
        List<Integer> Union = new ArrayList<>();

        // Initialize pointers
        int i = 0, j = 0;

        // Iterate while both arrays have elements
        while (i < arr1.length && j < arr2.length) {
            // If element in arr1 is smaller
            if (arr1[i] < arr2[j]) {
                // Add if empty or not duplicate
                if (Union.isEmpty() || Union.get(Union.size() - 1) != arr1[i])
                    Union.add(arr1[i]);
                i++;  // Move pointer in arr1
            }
            // If element in arr2 is smaller
            else if (arr2[j] < arr1[i]) {
                // Add if empty or not duplicate
                if (Union.isEmpty() || Union.get(Union.size() - 1) != arr2[j])
                    Union.add(arr2[j]);
                j++;  // Move pointer in arr2
            }
            else {
                // Elements are equal, add once if not duplicate
                if (Union.isEmpty() || Union.get(Union.size() - 1) != arr1[i])
                    Union.add(arr1[i]);
                i++; j++;  // Move both pointers
            }
        }

        // Append remaining elements from arr1
        while (i < arr1.length) {
            if (Union.isEmpty() || Union.get(Union.size() - 1) != arr1[i])
                Union.add(arr1[i]);
            i++;
        }

        // Append remaining elements from arr2
        while (j < arr2.length) {
            if (Union.isEmpty() || Union.get(Union.size() - 1) != arr2[j])
                Union.add(arr2[j]);
            j++;
        }

        // Return the union list
        return Union;
        }
        // int j = 0;
        // int i = 0;
        // while (j < nums.length && i < result.size()) {
        //     if (result.contains(nums[j])) 
        //         j++; 
        //     else if (result.get(i) != nums[j])    
        //         i++;                             //                    i
        //     else if (result.get(i) == nums[j]) { // {1,2,3,4,5,6,7,8,9,10}, {2,3,4,4,5,11,12}
        //         j++;                             //                                    j
        //         i++;                             // {1,2,3,4,5,6,7,8,9,10}
        //     }
        // }
        // while (j < nums.length && !result.contains(nums[j]))
        //     result.add(nums[j++]);
        // return result;
        // }           
}

public class sortedArraysUnion {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        System.out.println("Enter size of array - 1: ");
        int n;
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter number " + (i + 1) + ":");
            arr[i] = sc.nextInt();
        }

        System.out.println("Array - 1: ");
        for (int number : arr) {
            System.out.print(+ number + " ");
        }
        System.out.println();

        System.out.println("Enter size of array - 2: ");
        int size;
        size = sc.nextInt();
        int[] nums = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.println("Enter number " + (i + 1) + ":");
            nums[i] = sc.nextInt();
        }

        System.out.println("Array - 2: ");
        for (int number : arr) {
            System.out.print(+ number + " ");
        }
        System.out.println();
        
        List<Integer> result = sol.sortedArraysUnion(arr, nums);

        System.out.println("Output Array after Union: ");
        for (int i = 0; i < result.size(); i++) {
            System.out.print(+ result.get(i) + " ");
        }
    }
}

/* Since both arrays are sorted, we can efficiently find their union by iterating through them simultaneously. Using two pointers, one for each array, we compare elements and add the smaller one to the result (skipping duplicates). If elements are equal, add once and move both pointers. This way, we merge the arrays like in merge sort, avoiding extra space for maps or sets and achieving linear time complexity.
Initialize two pointers at the start of both arrays.
While neither pointer has reached the end:
If element pointed by first pointer is smaller, add it to result if not duplicate, move first pointer.
If element pointed by second pointer is smaller, add it to result if not duplicate, move second pointer.
If both elements are equal, add one to result if not duplicate, move both pointers.
After exiting loop, append remaining elements from either array, skipping duplicates.
Return the result array containing the union. */