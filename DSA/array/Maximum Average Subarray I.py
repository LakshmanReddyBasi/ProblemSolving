# You are given an integer array nums consisting of n elements, and an integer k.

# Find a contiguous subarray whose length is equal to k that has the maximum average value and return this value. Any answer with a calculation error less than 10-5 will be accepted.


Soln:

class Solution:
    def findMaxAverage(self, nums: List[int], k: int) -> float:
        n = len(nums)
        total = sum(nums[:k])  # initial sum of first k elements
        maxii = total

        for i in range(k, n):
            total += nums[i] - nums[i - k]  # slide the window
            maxii = max(maxii, total)

        return maxii / k


