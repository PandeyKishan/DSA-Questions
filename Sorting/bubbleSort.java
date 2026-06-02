import java.util.*;

// Bubble Sort - O(n^2) - Brute Force
// class bubbleSort {

//     public static void main(String[] args) {
//         Scanner sc = new Scanner(System.in);

//         System.out.println("Enter size of array: ");
//         int n;
//         n = sc.nextInt();
//         int[] arr = new int[n];
//         for (int i = 0; i < n; i++) {
//             System.out.println("Enter number " + (i + 1) + ":");
//             arr[i] = sc.nextInt();
//         }

//         // Traverse through all array elements
//         for (int i = n - 1; i >= 0; i--) { // traversing till n - 1 since the last element will always be in it's sorted position when n - 1 elements are sorted and at their correct position

//             // Find the minimum element in the remaining array
//             for (int j = 0; j <= i - 1; j++) {
//                 if (arr[j] > arr[j + 1]) {
//                     // Swap the two elements
//                     int temp = arr[j];
//                     arr[j] = arr[j + 1];
//                     arr[j + 1] = temp;
//                 }
//             }
//         }

//         System.err.println("Sorted Array: ");
//         for (int i : arr) {
//             System.err.print(i + " ");
//         }
//     }     
// }


// Bubble Sort - O(n^2 - Average/Worst) && O(n - Best) - Optimal
// We start from sorting the maximum element to the last position and progressing backwards, like a bubble which settles at the bottom by sorting the maximum to it's correct position
class bubbleSort {

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

        for (int i = n - 1; i >= 0; i--) {  //Use two nested loops to iterate over the array
            boolean didSwap = false;
            for (int j = 0; j <= i - 1; j++) { // The inner loop runs till i - 1 so that in the last iteration when i is 1, j is 0 and j + 1 is 1, 
            // and if required, a last swap can occur. If it was just before i - 1, the it wouldn't even have entered the loop for i = 1.
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j + 1];  //Swap arr[j+1] with arr[i]
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    didSwap = true;
                }
            }
            if (!didSwap) {
                break;
            }
        }

        System.err.println("Sorted Array: ");
        for (int i : arr) {
            System.err.print(i + " ");
        }
    }     
}
