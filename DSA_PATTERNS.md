# DSA Problem-Solving Patterns

> **Detailed Reference:** [View associated questions on Notion](https://app.notion.com/p/02c5b97edab68328959781cf36901c4a?v=6005b97edab6825daa938889ce8a96da&pvs=32)

This document serves as a cheat sheet for the common patterns and algorithm names used in this repository.

## 1. The Two-Pointer Pattern
*Used for processing sorted arrays or in-place modifications.*
- **Slow & Fast Pointers:** Remove Duplicates (Q25), Detect Cycle.
- **Opposite Ends:** Reverse Array (Q9), Palindrome String (Q10), Two Sum in sorted array.
- **Read & Write Pointers:** Move Zeroes to End (Q28).
- **Merge-step Pointers:** Union of Sorted Arrays (Q30).

## 2. Prefix Sum + Hash Map Pattern
*Used for subarray problems with specific sums (handles negative numbers/zeros).*
- **Index Tracking:** Longest Subarray with Sum 0 (Q35).
- **Frequency Tracking:** Count Subarray Sum Equals K (Q48).
- **Complement Lookup:** Two Sum (Q36).

## 3. Sliding Window Pattern
*Used for contiguous subsegments (mostly for positive numbers).*
- **Variable Window:** Longest Subarray with Sum K (Q34).
- **Fixed Window:** Max sum of subarray of size K.

## 4. Voting & Greedy Algorithms
*Optimized O(N) solutions for specific conditions.*
- **Boyer-Moore Voting:** Majority Element (>N/2) (Q38).
- **Extended Boyer-Moore:** Majority Element (>N/3) (Q50).
- **Kadane’s Algorithm:** Maximum Subarray Sum (Q39).
- **Greedy Tracking:** Stock Buy and Sell (Q40).

## 5. Mathematical & Bit Manipulation
- **XOR Logic ($a \oplus a = 0$):** Number appearing once (Q33).
- **Partitioned XOR:** Two Numbers Appearing Once (Q54).
- **Gauss' Formula ($n(n+1)/2$):** Missing Number (Q31).
- **Euclidean Algorithm:** GCD of two numbers (Q4).
- **Lexicographical Order:** Next Permutation (Q42).

## 6. Cyclic Sort Pattern
*Used when elements are in the range [1, N].*
- **"Home Index" Placement:** First Missing Positive (Q49), Find Duplicate Number.

## 7. Sorting & Partitioning
- **Dutch National Flag (3-way Partition):** Sort 0s, 1s, 2s (Q37).
- **Divide & Conquer:** Merge Sort (Q18), Quick Sort (Q21).

## 8. Matrix Manipulation
- **In-place Markers:** Set Matrix Zeros (Q45).
- **Transpose and Reflect:** Rotate Matrix by 90° (Q46).
- **Boundary Simulation:** Spiral Traversal (Q47).

## 9. Miscellaneous
- **Right-to-Left Scan (Suffix Max):** Leaders in an Array (Q43).
- **HashSet Sequence Building:** Longest Consecutive Sequence (Q44).
- **Reversal Algorithm:** Rotate Array by K (Q27).
- **Prefix & Suffix Products:** Product of Array Except Self (Q55).
