package Easy;
import java.util.*;

import Solution;

class Solution {
    // Linear Search

    public int countMaxConsectiveOnes(int[] arr) {
        int firstIndex, count = 0, ans = 0;
        for (firstIndex = 0; firstIndex < arr.length; firstIndex++) {
            if (arr[firstIndex] == 1) {
                count += 1;
                break;
            }    
        }     
        System.out.println(count);                       
        for (int i = firstIndex + 1; i < arr.length; i++) { 
            if(arr[i] == 1) {                                    
                count += 1; // 2
                System.out.println(count + " at index " + i);
            }    
            else {
                ans = Math.max(ans, count);
                count = 0;
            }
        }
        ans = Math.max(ans, count);
        return ans;
    }
}

public class maxConsecutiveOnes {
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

        System.out.println("Array (only 0 and 1's): ");
        for (int number : arr) {
            System.out.print(+ number + " ");
        }
        System.out.println();
        
        int count = sol.countMaxConsectiveOnes(arr);

        System.out.println("There are " + count + " consecutive 1's in the given array");
    }
}
