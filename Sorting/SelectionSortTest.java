
import java.util.Arrays;

public class SelectionSortTest {
    public static void main(String[] args) {
        test(new int[]{5, 4, 3, 2, 1}, "Reverse Sorted");
        test(new int[]{1, 2, 3, 4, 5}, "Already Sorted");
        test(new int[]{3, 1, 4, 1, 5, 9, 2, 6, 5}, "With Duplicates");
        test(new int[]{42}, "Single Element");
        test(new int[]{}, "Empty Array");
        test(new int[]{-5, 2, -10, 0, 7}, "With Negatives");
    }

    public static void test(int[] arr, String testName) {
        int n = arr.length;
        int[] original = arr.clone();
        
        // Applying the logic from selectionSort.java
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int min = arr[i];
                if(arr[j] < min) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }

        int[] expected = original.clone();
        Arrays.sort(expected);

        if (Arrays.equals(arr, expected)) {
            System.out.println("PASS: " + testName);
        } else {
            System.out.println("FAIL: " + testName);
            System.out.println("  Expected: " + Arrays.toString(expected));
            System.out.println("  Actual:   " + Arrays.toString(arr));
        }
    }
}
