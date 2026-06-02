package Easy;
import java.util.*;

import Solution;

class Solution {
    // Linear Search

    public int linearSearch(int[] arr, int num) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num) {
                return i;
            }
        }
        return -1;
    }            
}

public class linearSearch {
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

        System.out.println("Array: ");
        for (int number : arr) {
            System.out.print(+ number + " ");
        }
        System.out.println();

        System.out.print("Enter number to search: ");
        int num;
        num = sc.nextInt();
        
        int index = sol.linearSearch(arr, num);

        if (index != -1)
            System.out.println("Number " + num + " is present at index: " + index);
        else
            System.out.println("Number " + num + " is not present in the given array");
    }
}
