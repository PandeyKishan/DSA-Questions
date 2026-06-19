    import java.util.*;

    class Solution {
    /**
     * Merge Sort Approach
     * Time Complexity: O(2N*logN)
     * Space Complexity: O(N)
     */
    // Function to merge two halves and count inversions
    public void merge(int[] arr, int low, int mid, int high) {
    ArrayList<Integer> temp = new ArrayList<>(); // temporary array
        int left = low;      // starting index of left half of arr
        int right = mid + 1;   // starting index of right half of arr

        //storing elements in the temporary array in a sorted manner//

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp.add(arr[left]);
                left++;
            } else {
                temp.add(arr[right]);
                right++;
            }
        }

        // if elements on the left half are still left //

        while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }

        //  if elements on the right half are still left //
        while (right <= high) {
            temp.add(arr[right]);
            right++;
        }

        // transfering all elements from temporary to arr //
        for (int i = low; i <= high; i++) {
            arr[i] = temp.get(i - low);
        }
    }

    public static int countPairs(int[] arr, int low, int mid, int high) {
        int right = mid + 1;
        int cnt = 0;
        for (int i = low; i <= mid; i++) {
            while (right <= high && arr[i] > 2 * arr[right]) 
                right++;
            cnt += (right - (mid + 1));
        }
        return cnt;
    }

    public int mergeSort(int[] arr, int low, int high) {
        int cnt = 0;
        if (low >= high) return cnt;
        int mid = (low + high) / 2 ;
        cnt += mergeSort(arr, low, mid);  // left half
        cnt += mergeSort(arr, mid + 1, high); // right half
        cnt += countPairs(arr, low, mid, high); //Modification
        merge(arr, low, mid, high);  // merging sorted halves
        return cnt;
    }

        // Function to get number of inversions
    public int numberOfReversePairs(int[] arr) {
            return mergeSort(arr, 0, arr.length - 1);
        }
    }    

    public class reversePairs {
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

            System.out.println("\nOriginal Array: " + Arrays.toString(arr));
            
            int count = sol.numberOfReversePairs(arr);
            System.out.println("\n[Optimal Approach] Number of reverse pairs in the array is: " + count);
        }
    }