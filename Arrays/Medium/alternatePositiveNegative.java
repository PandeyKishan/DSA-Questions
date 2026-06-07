import java.util.*;

class Solution {
    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */

    public int[] alternateSignArrayOptimal(int[] nums, int n) {
        int[] answer = new int[n];
        int j = 0, k = 1;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                answer[j] = nums[i];
                j+= 2;
            }    
            else {
                answer[k] = nums[i];
                k+= 2;
            }
        }     // [-3, 2, 1, -1, -2, 4]
              //    2  -3
        return answer;
    }

    public int[] alternateSignArrayBrute(int[] nums, int n) {
        int[] answer = new int[n];
        int[] pos = new int[n / 2];
        int[] neg = new int[n / 2];

        int j = 0, k = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0)
                pos[j++] = nums[i];
            else
                neg[k++] = nums[i];
        }

        System.out.println("\nArray: " + Arrays.toString(pos));
        System.out.println("\nArray: " + Arrays.toString(neg));

        j = 0;
        k = 0;

        // for(int i = 0; i < n; i++) {
        //     if (i % 2 == 0) {
        //         answer[i] = pos[j++];
        //     } else {
        //         answer[i] = neg[k++];
        //     }
        // }
        // Step 2: Place positives at even indices and negatives at odd indices
        for (int i = 0; i < n / 2; i++) {
            answer[2 * i] = pos[i];       // Even index → positive
            answer[2 * i + 1] = neg[i];   // Odd index → negative
        }
        return answer;
        
    }
}

public class alternatePositiveNegative {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solution sol = new Solution();
        
        System.out.println("Enter size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Enter number " + (i + 1) + ":");
            arr[i] = sc.nextInt();
        }

        System.out.println("\nArray: " + Arrays.toString(arr));

        int[] answer = sol.alternateSignArrayOptimal(arr, n);

        System.out.println("\n[Optimal] Array with alternate positive and negative is: " + Arrays.toString(answer));

        answer = sol.alternateSignArrayBrute(arr, n);

        System.out.println("\n[Brute Force] Array with alternate positive and negative is: " + Arrays.toString(answer));
    }
}
