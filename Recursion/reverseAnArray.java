import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Solution {
    public void reverseArray(List<Integer> list, int start, int end) {
        if (start >= end) {
            return;
        }
        // Swapping elements
        Integer temp = list.get(start);
        list.set(start, list.get(end));
        list.set(end, temp);
        
        reverseArray(list, start + 1, end - 1);
    }
}

public class reverseAnArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();

        System.out.print("Enter size of array: ");
        int N = sc.nextInt();

        // Appproach - 1: Use a pre-filled ArrayList and move through the list using Iterator while replacing the new numbers with the existing ones
        
        // Initialize ArrayList with N placeholders using Collections.nCopies
        // We create a new ArrayList because nCopies returns an immutable list
        // List<Integer> array = new ArrayList<>(Collections.nCopies(N, 0));

        // ListIterator<Integer> it = array.listIterator();

        // while(it.hasNext()) {
        //     it.next(); // Move to the next placeholder
        //     System.out.print("Enter number: ");
        //     it.set(sc.nextInt()); // Replace the placeholder with actual input
        // }

        // Better Appproach - Use a while loop till the array size reaches the value of N
        List<Integer> array = new ArrayList<>();
        while (array.size() < N) {
            System.out.print("Enter number: ");
            array.add(sc.nextInt());
        }    

        // Use a traditional for-loop:
        // for (int i = 0; i < N; i++) {
        //     System.out.print("Enter number " + (i + 1) + ": ");
        //     int value = sc.nextInt();
        //     array.add(value);
        // }

        System.out.println("Original Array: " + array);

        sol.reverseArray(array, 0, array.size() - 1);

        System.out.println("Reversed Array: " + array);

        sc.close();
    }
}
