# DSA Question Approaches

> **Detailed Reference:** [View associated questions on Notion](https://app.notion.com/p/02c5b97edab68328959781cf36901c4a?v=6005b97edab6825daa938889ce8a96da&pvs=32)

This file contains the detailed optimal approaches for every question solved in this repository.

### **Basics & Maths**
1. **Count digits in a number:** Repeatedly divide the number by 10 in a loop and increment a counter until the quotient becomes 0 ($O(\log_{10}N)$ time).
2. **Reverse Digits of A Number:** Extract the last digit using `num % 10`, build the reversed number using `rev = rev * 10 + digit`, and update the original number using `num / 10`.
3. **Check if a number is Palindrome or Not:** Reverse the entire number and compare the result with the original; if they are identical, it is a palindrome.
4. **Find GCD of two numbers:** Use the **Euclidean Algorithm**: `gcd(a, b) = gcd(b, a % b)` until the remainder becomes 0; this utilizes the property that GCD remains same after subtraction/modulo.
5. **Check if a number is Armstrong Number or not:** Sum each digit raised to the power of the total number of digits; check if the final sum equals the original number.

### **Recursion**
6. **Recursion notes:** Identify the **Base Case** (the stopping condition) and the **Recursive Relation** (breaking the problem into smaller sub-problems of the same type).
7. **Print using Recursion:** Use a function that calls itself with `n+1` (to print 1 to N) or `n-1` (to print N to 1), handling the print statement before or after the call to control order.
8. **Factorial of a Number : Iterative and Recursive:** Iterative: Use a loop from 1 to $N$. Recursive: Return `n * fact(n-1)` with base case `fact(0) = 1` ($O(N)$ time).
9. **Reverse an array - Recursion:** Use two pointers (`left`, `right`) and swap elements at these positions, then recursively call the function for `left + 1` and `right - 1`.
10. **Check if the given String is Palindrome or not:** Compare the characters at indices `i` and `n-i-1`; if they match, recursively check the remaining inner string until the middle is reached.
11. **Print Fibonacci Series up to Nth term:** Use the recurrence $F(n) = F(n-1) + F(n-2)$ with base cases $F(0)=0, F(1)=1$; for optimization, use iteration to avoid $O(2^N)$ complexity.

### **Hashing**
12. **Hashing and Maps:** Use an array (for small fixed ranges like digits/lowercase) or a `HashMap` (for larger/dynamic ranges) to store frequencies or indices for $O(1)$ average-time lookups.
13. **Count frequency of each element in the array:** Traverse the array once and update the counts in a `HashMap` using `map.put(val, map.getOrDefault(val, 0) + 1)`.
14. **Find the highest/lowest frequency element:** Iterate through the `HashMap` entries once, maintaining variables to track the keys with the maximum and minimum count values.

### **Sorting Algorithms**
15. **Selection Sort:** Repeatedly find the minimum element from the unsorted part and swap it with the element at the current starting index ($O(N^2)$ time).
16. **Bubble Sort:** Repeatedly swap adjacent elements if they are in the wrong order; the largest element "bubbles" to its correct position at the end in each pass ($O(N^2)$ time).
17. **Insertion Sort:** Take an element and insert it into its correct sorted position relative to the elements on its left by shifting larger elements one position to the right ($O(N^2)$ time).
18. **Merge Sort:** **Divide and Conquer**: Recursively split the array into halves, sort them, and merge the sorted halves using a temporary array ($O(N \log N)$ time).
19. **Recursive Bubble Sort:** Recursively push the largest element of the current range to the end, then call the function for the range $[0, n-1]$.
20. **Recursive Insertion Sort:** Recursively sort the first $n-1$ elements, then insert the $n$-th element into its correct sorted position among them.
21. **Quick Sort:** **Partitioning**: Pick a **pivot** and rearrange the array such that all elements smaller than pivot are on its left; then recursively sort the two partitions.

### **Arrays (Easy)**
22. **Largest Element:** Maintain a `max` variable initialized to the first element; traverse the array once and update `max` if a larger element is found ($O(N)$ time).
23. **Second Largest and Smallest Element:** Maintain `largest` and `secondLargest` variables; update both during a single traversal without sorting ($O(N)$ time).
24. **Check if array is sorted:** Traverse from index 1 to $n-1$ and return `false` if `arr[i] < arr[i-1]`; otherwise, return `true` ($O(N)$ time).
25. **Remove Duplicates in-place from a Sorted Array:** Use **Two Pointers**; pointer `i` tracks the position of unique elements, while `j` scans for the next unique element ($O(N)$ time).
26. **Left Rotate Array By One:** Store the first element in a temporary variable, shift all other elements one position to the left, and place the temp at the last index.
27. **Rotate Array By K:** **Reversal Algorithm**: Reverse the first $K$ elements, then the remaining $N-K$ elements, and finally reverse the entire array ($O(N)$ time, $O(1)$ space).
28. **Move Zeroes to the End:** Use **Two Pointers**; `j` points to the first zero found, and `i` scans for non-zero elements to swap with the element at `j` ($O(N)$ time).
29. **Linear Search:** Iterate through the array and return the index if the current element matches the target; return -1 if not found ($O(N)$ time).
30. **Union of Two Sorted Arrays:** Use **Two Pointers** to traverse both arrays simultaneously, adding the smaller element to the result while ensuring no duplicates are added.
31. **Find the Missing Number:** Calculate the expected sum of first $N$ numbers using $N(N+1)/2$ and subtract the actual sum of array elements ($O(N)$ time).
32. **Count Maximum Consecutive One's in the array:** Traverse the array and increment a `count` for each 1; reset `count` to 0 on meeting a 0, while tracking the maximum `count` seen.
33. **Find the number that appears once, and the other numbers twice:** Perform **XOR** (`^`) on all array elements; since $a \oplus a = 0$ and $a \oplus 0 = a$, only the unique number will remain.
34. **Longest Subarray with given Sum K (Positives):** Use a **Sliding Window/Two Pointers**; expand the window to the right and shrink from the left if the current sum exceeds $K$.
35. **Longest Subarray with given Sum 0:** Use **Prefix Sum + HashMap** to store the first occurrence index of each prefix sum; if a sum repeats, the subarray between the two indices sums to 0.

### **Arrays (Medium)**
36. **Two Sum:** Use a **HashMap** to store each number and its index; for every element `x`, check if `target - x` exists in the map for $O(1)$ lookup.
37. **Sort an array of 0s, 1s and 2s:** **Dutch National Flag Algorithm**: Use three pointers (`low`, `mid`, `high`) to partition the array into three regions: 0s, 1s, and 2s ($O(N)$ time).
38. **Majority Element - 1:** **Boyer-Moore Voting Algorithm**: Maintain a candidate and a counter; increment for matches and decrement for mismatches to find the element appearing $> N/2$ times.
39. **Kadane's Algorithm : Maximum Subarray Sum in an Array:** Track the `currentSum`; if it drops below 0, reset it to 0. The maximum value reached by `currentSum` is the answer ($O(N)$ time).
40. **Stock Buy and Sell:** Maintain the `minPrice` seen so far and calculate potential profit on each day as `currentPrice - minPrice`, tracking the maximum profit found.
41. **Alternate Positive and Negative / Rearrange Array Elements by Sign:** Use two pointers (`posIdx = 0`, `negIdx = 1`) and fill a new array by placing elements at their respective parity-based next available index.
42. **Next Permutation:** Find the first dip from the right, swap it with the next larger element to its right, and reverse the remaining suffix to get the smallest larger permutation ($O(N)$ time).
43. **Leaders in an Array:** Traverse the array from right to left while maintaining the `maxSoFar`; any element greater than this is a leader.
44. **Longest Consecutive Sequence in an Array:** Use a **HashSet** for $O(1)$ lookups; only start counting a sequence if `num - 1` is not in the set to ensure each sequence is counted once.
45. **Set Matrix Zeros:** Use the **first row and first column as markers** to track which rows/cols should be zeroed; use extra variables to track the first row/col themselves ($O(1)$ space).
46. **Rotate Matrix by 90 degrees:** **Transpose** the matrix (swap `arr[i][j]` with `arr[j][i]`), then **Reverse** each row to achieve a 90-degree clockwise rotation ($O(N^2)$ time).
47. **Spiral Traversal of Matrix:** Maintain four boundaries (`top`, `bottom`, `left`, `right`) and print elements in a clockwise loop while shrinking the boundaries after each direction.
48. **Count Subarray sum Equals K:** Use **Prefix Sum + HashMap** to store the frequency of all prefix sums; if `prefixSum - K` exists in the map, add its frequency to the total count.

### **Arrays (Hard)**
49. **First Missing Positive:** **Cyclic Sort**: Place each number $X$ at index $X-1$ (if $1 \le X \le N$); the first index $i$ where `arr[i] != i+1` reveals the missing positive number.
50. **Unique Element - II:** Count the number of set bits at each of the 32 bit positions across all elements; for each position, `sum % 3` will reveal the bit of the element that appears once.
51. **Three Sum:** Sort the array and iterate through it; for each element `i`, use **Two Pointers** (`left`, `right`) on the remaining suffix to find pairs that sum to `-arr[i]`, skipping duplicates.
52. **Pascal’s Triangle:** Generate each row by summing adjacent elements of the previous row; alternatively, use the formula $C(n, r) = C(n, r-1) \times (n-r+1)/r$ for direct element calculation.
53. **Majority Element - II:** **Extended Boyer-Moore Voting Algorithm**: Maintain two candidates and two counters to find elements appearing more than $N/3$ times, then verify with a second pass.
54. **Product Without Self:** Calculate prefix products in a forward pass and multiply them with suffix products in a backward pass to get the result in $O(N)$ time and $O(1)$ space without division.
55. XOR all elements to find the unique number as a ^ a = 0
