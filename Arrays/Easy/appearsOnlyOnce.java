import java.util.*;

class Solution {
    public int numberOnceUsingMap(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1)
                return entry.getKey();
        }
        return -1;
    }

    public int numberOnceUsingXOR(int[] arr) {
        int XOR = 0;
        for (int i = 0; i < arr.length; i++) {
            XOR ^= arr[i];
        }
        return XOR; 
    }
}

public class appearsOnlyOnce {
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

        int number = sol.numberOnceUsingMap(arr);

        System.out.println("Only " + number +  " appears once in the array");

        number = sol.numberOnceUsingXOR(arr);

        System.out.println("Only " + number +  " appears once in the array");
    }
}

/* Intuition
Two important properties of XOR are the following:
XOR of two same numbers is always 0 i.e. a ^ a = 0. ←Property 1.
XOR of a number with 0 will result in the number itself i.e. 0 ^ a = a. ←Property 2

Approach
We will just perform the XOR of all elements of the array using a loop and the final XOR will be the answer. */