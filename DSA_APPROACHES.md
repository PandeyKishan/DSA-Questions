# DSA Question Approaches

> **Detailed Reference:** [View associated questions on Notion](https://app.notion.com/p/02c5b97edab68328959781cf36901c4a?v=6005b97edab6825daa938889ce8a96da&pvs=32)

This file contains the detailed optimal approaches for every question solved in this repository.

### **Basics & Maths**
1. **Count digits in a number:**
   - **Approach:** Repeatedly divide the number by 10 in a loop and increment a counter until the quotient becomes 0 ($O(\log_{10}N)$ time).
   - **Optimization:** Alternatively, use the mathematical formula $\lfloor \log_{10}N + 1 \rfloor$ for a direct $O(1)$ calculation.

2. **Reverse Digits of A Number:**
   - **Approach:** Extract the last digit using `num % 10`, build the reversed number using `rev = rev * 10 + digit`, and update the original number using `num / 10`.
   - **Caution:** Always handle potential integer overflow by checking if the reversed value exceeds the bounds of a 32-bit signed integer before the final update.

3. **Check if a number is Palindrome or Not:**
   - **Approach:** Store the original number in a variable. Reverse the entire number using the digit extraction method and compare the result with the original.
   - **Efficiency:** If the reversed number is identical to the original, it is a palindrome. This approach works in $O(\log_{10}N)$ time.

4. **Find GCD of two numbers:**
   - **Approach:** Use the **Euclidean Algorithm**: `gcd(a, b) = gcd(b, a % b)` until the remainder becomes 0.
   - **Logic:** This utilizes the property that the GCD of two numbers remains the same if the larger number is replaced by its remainder when divided by the smaller number.

5. **Check if a number is Armstrong Number or not:**
   - **Approach:** Determine the total number of digits $k$ in $N$. Sum each digit raised to the power of $k$.
   - **Validation:** If the final sum equals the original number $N$, it is an Armstrong number (e.g., $153 = 1^3 + 5^3 + 3^3$).

### **Recursion**
6. **Recursion notes:**
   - **Concept:** Identify the **Base Case** (the stopping condition to prevent stack overflow) and the **Recursive Relation** (breaking the problem into smaller sub-problems of the same type).
   - **Execution:** Understand that recursive calls are managed by the system call stack in a Last-In-First-Out (LIFO) manner.

7. **Print using Recursion:**
   - **1 to N:** Use a function `f(i, n)` that prints `i` and then calls `f(i+1, n)`. Alternatively, use backtracking by calling `f(i-1, n)` first and printing `i` after the call returns.
   - **N to 1:** Print the current value `i` and then recursively call the function with `i-1` until the base case is reached.

8. **Factorial of a Number : Iterative and Recursive:**
   - **Recursive:** Return `n * fact(n-1)` with the base case `fact(0) = 1`. This takes $O(N)$ time and $O(N)$ auxiliary stack space.
   - **Iterative:** Use a simple `for` loop from 1 to $N$ to accumulate the product, achieving $O(N)$ time with $O(1)$ space.

9. **Reverse an array - Recursion:**
   - **Approach:** Use two pointers (`left`, `right`) and swap the elements at these positions. Recursively call the function for `left + 1` and `right - 1` until the pointers meet or cross (`left >= right`).

10. **Check if the given String is Palindrome or not:**
    - **Approach:** Compare the characters at indices `i` and `n-i-1`. If they match, recursively check the next inner pair by incrementing `i`.
    - **Base Case:** The recursion stops when `i >= n/2`, at which point the string is confirmed as a palindrome.

11. **Print Fibonacci Series up to Nth term:**
    - **Recursive:** Use the recurrence $F(n) = F(n-1) + F(n-2)$ with base cases $F(0)=0, F(1)=1$. Note that this has an exponential $O(2^N)$ complexity without memoization.
    - **Iterative:** Use a loop to sum the last two terms, updating variables to achieve $O(N)$ time and $O(1)$ space.

### **Hashing**
12. **Hashing and Maps:**
    - **Concept:** Use an array (for small, fixed ranges like digits or characters) or a `HashMap` (for larger or dynamic ranges) to store frequencies or indices.
    - **Performance:** `HashMap` provides an average $O(1)$ time complexity for insertions and lookups.

13. **Count frequency of each element in the array:**
    - **Approach:** Traverse the array once and update the counts in a `HashMap` using `map.put(val, map.getOrDefault(val, 0) + 1)`. This handles any range of integers.

14. **Find the highest/lowest frequency element:**
    - **Approach:** Iterate through the `HashMap` entries using `map.entrySet()`. Maintain variables to track the keys with the maximum and minimum count values observed during the single pass.

### **Sorting Algorithms**
15. **Selection Sort:**
    - **Approach:** Repeatedly find the minimum element from the unsorted part (indices `i` to `n-1`) and swap it with the element at the current starting index `i`.
    - **Complexity:** This always takes $O(N^2)$ time as it requires two nested loops regardless of the initial order.

16. **Bubble Sort:**
    - **Approach:** Repeatedly swap adjacent elements if they are in the wrong order. In each pass, the largest remaining element "bubbles" to its correct position at the end.
    - **Optimization:** Use a boolean flag to detect if any swaps occurred; if not, the array is already sorted, allowing $O(N)$ best-case time.

17. **Insertion Sort:**
    - **Approach:** Take one element at a time and insert it into its correct sorted position relative to the elements on its left by shifting larger elements one position to the right ($O(N^2)$ time).

18. **Merge Sort:**
    - **Approach:** **Divide and Conquer**: Recursively split the array into halves until single elements remain. Merge the sorted halves using a temporary array and a two-pointer merging strategy.
    - **Complexity:** Provides a stable $O(N \log N)$ time complexity but requires $O(N)$ extra space.

19. **Recursive Bubble Sort:**
    - **Approach:** Recursively push the largest element of the current range to the end by swapping adjacent elements, then call the function for the range $[0, n-1]$.

20. **Recursive Insertion Sort:**
    - **Approach:** Recursively sort the first $n-1$ elements. Once sorted, take the $n$-th element and insert it into its correct position among the sorted prefix by shifting elements.

21. **Quick Sort:**
    - **Approach:** **Partitioning**: Pick a **pivot** (e.g., first, last, or random element). Rearrange the array such that all elements smaller than the pivot are on its left and larger elements are on its right. Recursively sort the partitions.
    - **Complexity:** $O(N \log N)$ average time, but can degrade to $O(N^2)$ with a poor pivot choice.

### **Arrays (Easy)**
22. **Largest Element:**
    - **Approach:** Initialize a `max` variable with the first element of the array. Traverse the array once, updating `max` whenever a larger element is encountered ($O(N)$ time).

23. **Second Largest and Smallest Element:**
    - **Approach:** Maintain `largest` and `secondLargest` variables. Update both in a single traversal: if current > `largest`, update both; else if current > `secondLargest` and current != `largest`, update `secondLargest`. Use similar logic for the smallest elements.

24. **Check if array is sorted:**
    - **Approach:** Traverse the array from index 1 to $n-1$. If any element is smaller than the previous one (`arr[i] < arr[i-1]`), return `false`. Otherwise, return `true`.

25. **Remove Duplicates in-place from a Sorted Array:**
    - **Approach:** Use **Two Pointers**. Pointer `i` tracks the position of the last unique element, while `j` scans the rest of the array. When `arr[j] != arr[i]`, increment `i` and copy `arr[j]` to `arr[i]`.

26. **Left Rotate Array By One:**
    - **Approach:** Store the first element in a temporary variable. Shift all subsequent elements one position to the left, and then place the stored element at the last index.

27. **Rotate Array By K:**
    - **Approach:** **Reversal Algorithm**: Reverse the first $K$ elements, then reverse the remaining $N-K$ elements. Finally, reverse the entire array. This achieves $O(N)$ time and $O(1)$ space.

28. **Move Zeroes to the End:**
    - **Approach:** Use **Two Pointers**. Pointer `j` is placed at the first 0 found. Pointer `i` scans for non-zero elements; when one is found, swap `arr[i]` and `arr[j]` and increment `j`.

29. **Linear Search:**
    - **Approach:** Iterate through the array sequentially. Compare each element with the target. Return the index of the first match, or -1 if the end of the array is reached.

30. **Union of Two Sorted Arrays:**
    - **Approach:** Use **Two Pointers** to traverse both arrays. Add the smaller element to the result list only if it's not already the last element added, ensuring the union is sorted and unique.

31. **Find the Missing Number:**
    - **Approach:** Calculate the expected sum of the first $N$ numbers using the formula $N(N+1)/2$. Subtract the sum of all elements in the array; the result is the missing number.

32. **Count Maximum Consecutive One's in the array:**
    - **Approach:** Maintain a `count` variable. Traverse the array, incrementing `count` for each 1 and resetting it to 0 for each 0. Keep track of the maximum value `count` reaches.

33. **Find the number that appears once, and the other numbers twice:**
    - **Approach:** Perform a bitwise **XOR** (`^`) on all elements in the array. Since $x \oplus x = 0$ and $x \oplus 0 = x$, the result will be the unique number.

34. **Longest Subarray with given Sum K (Positives):**
    - **Approach:** Use a **Sliding Window** (Two Pointers). Expand the `right` pointer to increase the sum. If the sum exceeds $K$, move the `left` pointer to shrink the window until the sum is $\le K$.

35. **Longest Subarray with given Sum 0:**
    - **Approach:** Use **Prefix Sum + HashMap** to store the first index where each prefix sum occurs. If a sum repeats, the subarray between those two indices has a total sum of 0.

### **Arrays (Medium)**
36. **Two Sum:**
    - **Approach:** Use a **HashMap** to store each number and its index. For each element `x`, check if `target - x` exists in the map. If it does, you've found the pair in $O(N)$ time.

37. **Sort an array of 0s, 1s and 2s:**
    - **Approach:** **Dutch National Flag Algorithm**: Use three pointers: `low`, `mid`, and `high`. Maintain the invariant that elements before `low` are 0, after `high` are 2, and between `low` and `mid` are 1.

38. **Majority Element - 1:**
    - **Approach:** **Boyer-Moore Voting Algorithm**: Maintain a candidate and a count. If count is 0, pick current as candidate. Increment count if current matches candidate, else decrement. The candidate is the potential majority element.

39. **Kadane's Algorithm : Maximum Subarray Sum in an Array:**
    - **Approach:** Traverse the array while maintaining a `currentSum`. If `currentSum` becomes negative, reset it to 0. The maximum value `currentSum` reaches during the traversal is the result.

40. **Stock Buy and Sell:**
    - **Approach:** Maintain the `minPrice` observed so far. On each day, calculate the potential profit (`currentPrice - minPrice`) and update the `maxProfit` if this calculation is higher.

41. **Alternate Positive and Negative / Rearrange Array Elements by Sign:**
    - **Approach:** Initialize a result array. Use two pointers, `posIdx` at 0 and `negIdx` at 1. Fill the result array by placing positive elements at `posIdx` (increment by 2) and negative elements at `negIdx` (increment by 2).

42. **Next Permutation:**
    - **Approach:** Find the first "dip" from the right (`arr[i] < arr[i+1]`). Swap `arr[i]` with the smallest element larger than it to its right. Finally, reverse the suffix after index `i`.

43. **Leaders in an Array:**
    - **Approach:** Traverse the array from right to left while keeping track of the `maxSoFar`. Any element that is strictly greater than `maxSoFar` is a leader.

44. **Longest Consecutive Sequence in an Array:**
    - **Approach:** Store all elements in a **HashSet**. For each element `x`, if `x-1` is not in the set, it's the start of a potential sequence. Count how many consecutive numbers exist starting from `x`.

45. **Set Matrix Zeros:**
    - **Approach:** Use the first row and first column of the matrix as markers. Use two boolean variables to track if the first row and first column themselves need to be zeroed.

46. **Rotate Matrix by 90 degrees:**
    - **Approach:** First, **Transpose** the matrix (swap `arr[i][j]` with `arr[j][i]`). Then, **Reverse** each row. This results in a 90-degree clockwise rotation.

47. **Spiral Traversal of Matrix:**
    - **Approach:** Maintain four pointers: `top`, `bottom`, `left`, and `right`. Print elements in a clockwise spiral by traversing boundaries and then shifting them inward.

48. **Count Subarray sum Equals K:**
    - **Approach:** Use **Prefix Sum + HashMap** to store frequencies of prefix sums. For each current prefix sum `S`, the number of subarrays ending here with sum $K$ is the frequency of `S - K` in the map.

### **Arrays (Hard)**
49. **First Missing Positive:**
    - **Approach:** **Cyclic Sort**: Place each number $X$ at index $X-1$ if $1 \le X \le N$. After sorting, the first index `i` where `arr[i] != i+1` reveals the missing positive number.

50. **Two Unique Elements (others appear twice):**
    - **Approach:** XOR all elements to get $X \oplus Y$. Find the rightmost set bit in the result, then use this bit to partition all elements into two groups. XORing each group separately reveals the two unique elements.

51. **Three Sum:**
    - **Approach:** Sort the array and iterate with index `i`. For each `i`, use **Two Pointers** (`left`, `right`) on the remaining suffix to find pairs that sum to `-arr[i]`, ensuring you skip duplicates for all three pointers.

52. **Pascal’s Triangle:**
    - **Approach:** Generate each row by summing adjacent elements of the previous row. For a specific row or element, use the combination formula $C(n, r) = C(n, r-1) \times (n-r+1)/r$ for efficiency.

53. **Majority Element - II (appears > N/3 times):**
    - **Approach:** **Extended Boyer-Moore Voting Algorithm**: Maintain two candidates and two counters. In a second pass, verify if these candidates actually appear more than $N/3$ times in the array.

54. **Product Without Self:**
    - **Approach:** Calculate prefix products in a forward pass and multiply them with suffix products in a backward pass. This provides the result in $O(N)$ time and $O(1)$ extra space without using division.

55. **Four Sum:**
    - **Approach:** Use two nested loops for the first two elements and two pointers (`left`, `right`) for the remaining two. Sort the array and skip duplicates at every level to find all unique quadruplets ($O(N^3)$).

56. **Longest Subarray with XOR Sum K:**
    - **Approach:** Use a **HashMap** to store the first occurrence of each prefix XOR. For the current prefix XOR $X$, if $X \oplus K$ exists in the map at index $i$, the subarray from $i+1$ to the current index has an XOR sum of $K$.

57. **Count Subarrays with XOR Sum K:**
    - **Approach:** Use a **HashMap** to track the frequency of prefix XORs. The number of subarrays ending at the current index with XOR sum $K$ is the frequency of $(prefixXOR \oplus K)$ previously stored in the map.
58. Use three pointers (i, j, k) starting from the end to merge nums2 into nums1 in-place by placing the larger element at the back.
