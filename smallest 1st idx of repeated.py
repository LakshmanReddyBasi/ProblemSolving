# Given an array arr[], find the first repeating element. The element should occur more than once and the index of its first occurrence should be the smallest.

# Note:- The position you return should be according to 1-based indexing. 

# Examples:

# Input: arr[] = [1, 5, 3, 4, 3, 5, 6]
# Output: 2
# Explanation: 5 appears twice and its first appearance is at index 2 which is less than 3 whose first the occurring index is 3.
# Input: arr[] = [1, 2, 3, 4]
# Output: -1
# Explanation: All elements appear only once so answer is -1.

SOln:
class Solution:
    def firstRepeated(self, arr):
        freq = {}

        # Step 1: Count frequency
        for num in arr:
            freq[num] = freq.get(num, 0) + 1

        # Step 2: Find the first repeating element
        for i in range(len(arr)):
            if freq[arr[i]] > 1:
                return i + 1  # 1-based index

        return -1


_____________________________________________________________________-
