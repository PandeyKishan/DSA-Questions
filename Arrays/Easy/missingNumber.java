package Easy;
import java.util.*;

import Solution;

class Solution {
    // Linear Search

    public int missingNumberUsingSort(int[] arr) {
        Arrays.sort(arr);
        // for(int i = 1; i < arr.length; i++) {
        //     if (arr[i] != (arr[i - 1] + 1)) {
        //         return (arr[i - 1] + 1);
        //     }
        // }
        for(int i = 0; i < arr.length; i++) {
            if ((i + 1) != arr[i]) {
                return (i + 1);
            }
        }
        return -1;
    }

    public int missingNumberUsingMap(int[] arr) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for(int i = 1; i <= arr.length; i++) {
            if(!map.containsKey(i)) 
                return i;
        }
        return -1;
    }

    public int missingNumberUsingSum(int[] arr) {
        long n = arr.length + 1;
        long actualSum = n * (n + 1) / 2;
        // for (int i = 1; i <= n; i++) { // [8, 2, 4, 5, 3, 7, 1]
        //     actualSum += i;
        // }
        System.out.println(actualSum);
        long sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        System.out.println(sum);
        return (int)(actualSum - sum); 
    }

    public int missingNumberUsingXOR(int[] arr) {
        int n = arr.length;
        int actualXOR = 0;
        for (int i = 1; i <= n + 1; i++) { // [8, 2, 4, 5, 3, 7, 1]
            actualXOR ^= i;
        }
        System.out.println(actualXOR);
        int XOR = 0;
        for (int i = 0; i < n; i++) {
            XOR ^= arr[i];
        }
        System.out.println(XOR);
        return actualXOR ^ XOR; 
    }
}

public class missingNumber {
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
        
        int number = sol.missingNumberUsingSort(arr);

        System.out.println("Missing number in the given array is: " + number);

        number = sol.missingNumberUsingMap(arr);

        System.out.println("Missing number in the given array is: " + number);

        number = sol.missingNumberUsingSum(arr);

        System.out.println("Missing number in the given array is: " + number);

        number = sol.missingNumberUsingXOR(arr);

        System.out.println("Missing number in the given array is: " + number);
    }
}