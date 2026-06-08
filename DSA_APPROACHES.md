# DSA Question Approaches

This file contains the detailed optimal approaches for every question solved in this repository.

### **Basics & Maths**
1. **Count Digits:** Divide the number by 10 repeatedly in a loop and increment a counter until the number becomes 0.
2. **Reverse Digits:** Extract the last digit using `% 10`, append it to a result variable (`rev = rev * 10 + digit`), and remove it from the original number using `/ 10`.
3. **Palindrome Number:** Reverse the digits of the number and compare the reversed result with the original number.
4. **GCD of Two Numbers:** Use the **Euclidean Algorithm**: `gcd(a, b) = gcd(b, a % b)` until the remainder becomes 0.
5. **Armstrong Number:** Calculate the sum of each digit raised to the power of the total number of digits; check if this sum equals the original number.

### **Recursion**
6. **Recursion Notes:** Focus on identifying the **Base Case** (to prevent infinite loops) and the **Recursive Step** (to solve a smaller version of the same problem).
7. **Print using Recursion:** Pass a counter/index as a parameter and print it before (ascending) or after (descending) the recursive call.
8. **Factorial (Iterative/Recursive):** Iterative: Multiply numbers from 1 to $N$. Recursive: Return `n * fact(n - 1)` with base case `fact(0) = 1`.
9. **Reverse Array (Recursion):** Swap elements at left and right indices, then recursively call with `left + 1` and `right - 1` until they meet.
10. **Palindrome String (Recursion):** Check if first and last characters match; if so, recursively check the remaining inner substring.
11. **Fibonacci (Up to N):** Use the recurrence `f(n) = f(n - 1) + f(n - 2)` with base cases `f(0) = 0` and `f(1) = 1`.

### **Hashing**
12. **Hashing & Maps:** Use an array (for fixed ranges like alphabet/digits) or a `HashMap` to store key-value pairs for constant-time lookups.
13. **Count Frequency:** Iterate through the array and update counts in a `HashMap` using `map.put(x, map.getOrDefault(x, 0) + 1)`.
14. **Highest/Lowest Frequency:** Iterate through the entries of the frequency map and track the keys associated with the maximum and minimum values.

### **Sorting Algorithms**
15. **Selection Sort:** Find the minimum element in the unsorted part of the array and swap it with the first element of that part.
16. **Bubble Sort:** Repeatedly swap adjacent elements if they are in the wrong order; the largest element "bubbles" to its correct position in each pass.
17. **Insertion Sort:** Take an element and insert it into its correct sorted position relative to the elements already processed on its left.
18. **Merge Sort:** **Divide and Conquer**: Recursively split the array into halves, sort them, and merge the sorted halves using a temporary array.
19. **Recursive Bubble Sort:** Push the largest element to the end for the current range, then recursively call the function for the first $n-1$ elements.
20. **Recursive Insertion Sort:** Recursively sort the first $n-1$ elements, then insert the $n$-th element into its correct position.
21. **Quick Sort:** Pick a **pivot** element, partition the array such that elements smaller than the pivot are on the left, and recursively sort both sides.

### **Arrays (Easy)**
22. **Largest Element:** Initialize a `max` variable with the first element and update it if a larger element is found during traversal.
23. **Second Largest/Smallest:** Maintain `largest` and `secondLargest` variables; update both whenever a new `largest` is encountered.
24. **Check if Sorted:** Traverse the array once and check if every element `arr[i]` is less than or equal to `arr[i+1]`.
25. **Remove Duplicates (In-place):** Use **Two Pointers**; `i` tracks the position of unique elements, and `j` scans for the next new element.
26. **Left Rotate by One:** Store the first element in `temp`, shift all elements one position to the left, and place `temp` at the last index.
27. **Rotate by K:** **Reversal Algorithm**: Reverse the first $K$ elements, then the remaining $N-K$ elements, and finally reverse the whole array.
28. **Move Zeroes to End:** Use **Two Pointers**; pointer `j` stays at the first zero while `i` finds non-zero elements to swap with `j`.
29. **Linear Search:** Iterate through the array and return the index of the first occurrence of the target element.
30. **Union of Sorted Arrays:** Use **Two Pointers** to compare elements of both arrays, adding the smaller one to the result while skipping duplicates.
31. **Find Missing Number:** Calculate the expected sum of first $N$ numbers using $N(N+1)/2$ and subtract the sum of actual array elements.
32. **Max Consecutive Ones:** Maintain a `count` for current ones and a `maxCount` to store the highest count found before meeting a zero.
33. **Number Appearing Once:** Use **XOR** (`^`) operation on all elements; identical numbers cancel each other out, leaving only the unique number.
34. **Longest Subarray with Sum K (Positives):** Use a **Sliding Window**; expand the window to the right and shrink from the left if the sum exceeds $K$.
35. **Longest Subarray with Sum 0:** Use **Prefix Sum + HashMap** to store the first occurrence of each prefix sum; if a sum repeats, the subarray between them is 0.

### **Arrays (Medium)**
36. **Two Sum:** Use a **HashMap** to store numbers and their indices; for each element, check if `target - element` already exists in the map.
37. **Sort 0s, 1s, 2s:** **Dutch National Flag Algorithm** using three pointers (`low`, `mid`, `high`) to partition elements into three zones.
38. **Majority Element (>N/2):** **Boyer-Moore Voting Algorithm**; maintain a candidate and a counter that increments for matches and decrements for mismatches.
39. **Kadane’s Algorithm:** Keep a `runningSum`; if it becomes negative, reset it to 0. Track the maximum `runningSum` encountered.
40. **Stock Buy and Sell:** Track the `minimumPrice` seen so far and calculate potential profit (`currentPrice - minimumPrice`) for each day.
41. **Alternate Positive/Negative:** Use two pointers (`posIdx = 0`, `negIdx = 1`) to fill a new array with positive and negative numbers at respective parity indices.
42. **Next Permutation:** Find the first "break-point" from the right, swap it with the next larger element, and reverse the remaining suffix.
43. **Leaders in an Array:** Scan the array from right to left, keeping track of the `maximumSoFar`; any element greater than this is a leader.
44. **Longest Consecutive Sequence:** Use a **HashSet** for $O(1)$ lookups; only start counting a sequence if `num - 1` is not present in the set.
45. **Set Matrix Zeros:** Use the first row and first column as **in-place markers** to track which rows and columns should be zeroed out.
46. **Rotate Matrix by 90°:** First, **Transpose** the matrix (swap `arr[i][j]` with `arr[j][i]`), then **Reverse** each row of the transposed matrix.
47. **Spiral Traversal:** Maintain four boundaries (`top`, `bottom`, `left`, `right`) and traverse in a clockwise loop while updating boundaries.
48. **Count Subarray Sum = K:** Use **Prefix Sum + HashMap** to store frequencies of prefix sums; if `prefixSum - K` exists, add its frequency to the total count.

### **Arrays (Hard)**
49. **First Missing Positive:** **Cyclic Sort**: Place every number $X$ at index $X-1$ if it's within $[1, N]$. The first index $i$ where `arr[i] != i+1` reveals the answer.
50. **Unique Element II (>N/3):** **Extended Boyer-Moore Voting**; maintain two candidates and two counters to find elements appearing more than one-third of the time.
51. **Three Sum:** First, **Sort** the array. Iterate through the array using a pointer `i`. For each `i`, use **Two Pointers** (`left` and `right`) to find pairs such that `arr[i] + arr[left] + arr[right] == target`. Skip duplicate elements for all three pointers to ensure unique triplets.
52. **Pascal’s Triangle:** For a specific element, use the **combination formula** $C(n, r)$. For the Nth row, use the **linear formula** $val = val * (N - k) / k$. For the full triangle, generate each row by **summing adjacent elements** of the row above.
53. Majority Element - II (>N/3): **Extended Boyer-Moore Voting Algorithm**. Since there can be at most two elements appearing more than $N/3$ times, maintain two potential candidates and two counters. Perform a second pass to verify the exact counts of these two candidates before adding them to the result.
54. **Two Numbers Appearing Once:** XOR all elements to get `x ^ y`, find the rightmost set bit to partition elements into two groups, and XOR each group separately to find the two unique numbers.
55. **Product of Array Except Self:** Use two passes to calculate prefix products and suffix products respectively, storing their product in the result array to avoid division.

56. Calculate prefix products in one pass and multiply with suffix products in a reverse pass to avoid division.
57. **Product of Array Except Self:** Compute prefix products in a forward pass and suffix products in a backward pass to get the result in O(N) time and O(1) space.
