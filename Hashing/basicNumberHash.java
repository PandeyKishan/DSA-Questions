import java.util.*;

// Number Hashing
class basicNumberHash {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter size of array: ");
        int n;
        n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter number " + (i + 1) + ":");
            arr[i] = sc.nextInt();
        }

        //precompute:
        int[] hash = new int[13];
        for (int i = 0; i < n; i++) {
            hash[arr[i]] += 1;
        }

        System.out.println("Enter size to check: ");
        int q;
        q = sc.nextInt();
        while (q-- != 0) {
            int number;
            System.out.println("Enter number to check: ");
            number = sc.nextInt();
            // fetching:
            System.out.println("The number " + number + " has appeared " + hash[number] + " times in the array");
        }
    }
}

// NOTE: Until now, we have used the method of number hashing but using this method we cannot hash large numbers like 10^9 or 
// higher. We can solve this problem using the STL map and unordered_map in C++ or the HashMap in Java collection.