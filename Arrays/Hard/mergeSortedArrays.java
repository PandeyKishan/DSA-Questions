import java.util.*;

class Solution {
    /**
     * Brute Force
     * Time Complexity: O(M*N)
     * Space Complexity: O(1)
     */
    public void mergeBrute(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0)
            return;
        if(m == 0) {
            for(int i = 0; i < m + n; i++) {
                nums1[i] = nums2[i];
            }
            return;
        }    
        int i = 0;
        while(i < m) {
           if (nums1[i] > nums2[0]) {
                swap(nums1, nums2, i);
                // Put nums2[0] into its correct position
                int first = nums2[0];
                int k = 1;

                while (k < n && nums2[k] < first) {
                    nums2[k - 1] = nums2[k];
                    k++;
                }

                nums2[k - 1] = first;
            } 
            i++;   
        }

        int j = 0;

        for(i = m; i < m + n; i++) {
            nums1[i] = nums2[j++];
        }
    }

    public void swap(int[] nums1, int[] nums2, int i) {
        int temp = nums1[i];
        nums1[i] = nums2[0];
        nums2[0] = temp;
    }

    /**
     * Optimal Approach
     * Time Complexity: O(M+N)
     * Space Complexity: O(1)
     */
    public void mergeOptimal(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        // 0, 2, 7, 8, 0, 0, 0
        // i
        // -7, -3, -1
        //          j
        //               0 2 7 8
        while(i >= 0 && j >= 0) {
            if(nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while(k >= 0 && j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}

public class mergeSortedArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        
        System.out.println("Enter size of array - 1: ");
        int m = sc.nextInt();

        System.out.println("Enter size of array - 2: ");
        int n = sc.nextInt();

        int[] arr1 = new int[m + n];
        for (int i = 0; i < m; i++) {
            System.out.println("Enter number " + (i + 1) + " for array - 1: ");
            arr1[i] = sc.nextInt();
        }
        for (int i = m; i < m + n; i++) {
            arr1[i] = 0;
        }

        System.out.println();

        int[] arr2 = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter number " + (i + 1) + " for array - 2: ");
            arr2[i] = sc.nextInt();
        }

        System.out.println("\nArray - 1: " + Arrays.toString(arr1));
        System.out.println("\nArray - 2: " + Arrays.toString(arr2));

        // Brute Force
        sol.mergeBrute(arr1, m, arr2, n);
        System.out.println("\n[Brute Force] Resultant array after merging the two sorted arrays: " + Arrays.toString(arr1));

        int[] arr1Clone = arr1.clone();
        int[] arr2Clone = arr2.clone();

        // Optimal Approach
        sol.mergeOptimal(arr1Clone, m, arr2Clone, n);
        System.out.println("\n[Optimal Approach] Resultant array after merging the two sorted arrays: " + Arrays.toString(arr1Clone));
    }
}