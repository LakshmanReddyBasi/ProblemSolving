# 3066. Minimum Operations to Exceed Threshold Value II
# Medium
# Topics
# Companies
# Hint
# You are given a 0-indexed integer array nums, and an integer k.

# In one operation, you will:

# Take the two smallest integers x and y in nums.
# Remove x and y from nums.
# Add min(x, y) * 2 + max(x, y) anywhere in the array.
# Note that you can only apply the described operation if nums contains at least two elements.

# Return the minimum number of operations needed so that all elements of the array are greater than or equal to k.

 

# Example 1:

# Input: nums = [2,11,10,1,3], k = 10
# Output: 2
# Explanation: In the first operation, we remove elements 1 and 2, then add 1 * 2 + 2 to nums. nums becomes equal to [4, 11, 10, 3].
# In the second operation, we remove elements 3 and 4, then add 3 * 2 + 4 to nums. nums becomes equal to [10, 11, 10].
# At this stage, all the elements of nums are greater than or equal to 10 so we can stop.
# It can be shown that 2 is the minimum number of operations needed so that all elements of the array are greater than or equal to 10.
# Example 2:

# Input: nums = [1,1,2,4,9], k = 20
# Output: 4
# Explanation: After one operation, nums becomes equal to [2, 4, 9, 3].
# After two operations, nums becomes equal to [7, 4, 9].
# After three operations, nums becomes equal to [15, 9].
# After four operations, nums becomes equal to [33].
# At this stage, all the elements of nums are greater than 20 so we can stop.
# It can be shown that 4 is the minimum number of operations needed so that all elements of the array are greater than or equal to 20.

SOln:

approach1 TLE:
c = 0 

def mins(arr):
    """Find the two smallest elements in arr."""
    min1 = float('inf')
    min2 = float('inf')

    for i in arr:
        if i < min1:
            min1, min2 = i, min1
        elif i < min2:
            min2 = i

    return min1, min2

def count(arr, k):
    global c
    if len(arr) < 2 or min(arr) >= k:
        return c

    min1, min2 = mins(arr)
    arr.remove(min1)
    arr.remove(min2)

    new_value = min1 * 2 + min2
    arr.append(new_value)
    c += 1
    return count(arr, k)

class Solution:
    def minOperations(self, nums, k):
        global c
        c = 0
        return count(nums, k)


__________________________________________________________________________________________________________________________________



SOl:
Approach using heap:
import heapq

class Solution:
    def minOperations(self, nums, k):
        heapq.heapify(nums)
        count = 0  

        while len(nums) > 1 and nums[0] < k:
            min1 = heapq.heappop(nums)
            min2 = heapq.heappop(nums)
            new_value = min1 * 2 + min2
            
            heapq.heappush(nums, new_value)
            count += 1
        
        return count




____________________________________________________________________________________________________________

SOln:

Approach using SortedList:
from sortedcontainers import *
class Solution(object):
    def minOperations(self, nums, k):
        nums = SortedList(nums)
        print(nums)
        a = 0
        while nums[0] < k:
            b = nums.pop(0)
            c = nums.pop(0)
            d = min(b, c) * 2 + max(b, c)
            nums.add(d)
            a += 1
        return a



Approach	     Min Extraction (O)	        Insertion (O)	               Total Complexity
SortedList	   O(1) (pop(0))	            O(log n) (add())	          O(log n) per operation
Heap (heapq)	 O(log n) (heappop())	      O(log n) (heappush())	       O(log n) per operation
