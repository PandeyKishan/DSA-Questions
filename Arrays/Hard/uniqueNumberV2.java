import java.util.Arrays;
import java.util.Scanner;

class Solution {
    /**
     * Time Complexity: O(N)
     * Space Complexity: O(1)
     */
    public int[] singleNum(int[] arr) {
        int[] result = new int[2];
        int n = arr.length;
        int xorAll = 0;

        for(int i = 0; i < n; i++) {
            xorAll ^= arr[i];
        }
        // [1, 2, 3, 2, 1, 4]
        // xorAll = 3 ^ 4
        xorAll &= -xorAll;
        
        for(int i = 0; i < n; i++) {
            if((arr[i] & xorAll) == 0) {
                result[0] ^= arr[i];
            } else {
                result[1] ^= arr[i];
            }
        }
        
        if(result[0] > result[1]) {
            result[0] = result[0] ^ result[1];
            result[1] = result[0] ^ result[1];
            result[0] = result[0] ^ result[1];
        }
        return result;
    }
}

public class uniqueNumberV2 {
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

        int[] result = sol.singleNum(arr);
        System.out.println("\n[Optimal] Missing elements in the array: " + Arrays.toString(result));
    }
}    

/* For the two unique numbers:

One will have that chosen bit unset → num & xorVal == 0
The other will have that chosen bit set → num & xorVal != 0

because that bit came from unique1 ^ unique2, meaning they differ there, which we get from
xorAll &= -xorAll as it gives the rightmost bit (1st bit after which all are 0, both numbers differ there.. */
