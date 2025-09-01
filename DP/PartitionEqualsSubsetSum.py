# Given an integer array nums, return true if you can partition the array into two subsets such that the sum of the elements in both subsets is equal or false otherwise.

 

# Example 1:

# Input: nums = [1,5,11,5]
# Output: true
# Explanation: The array can be partitioned as [1, 5, 5] and [11].
# Example 2:

# Input: nums = [1,2,3,5]
# Output: false
# Explanation: The array cannot be partitioned into equal sum subsets.

Soln:

class Solution:
    def canPartition(self, nums: List[int]) -> bool:

        totalSum = sum(nums)
        if totalSum % 2 != 0:
            return False
        targetSum = totalSum // 2
        dp = [False] * (targetSum + 1)
        dp[0] = True
        for num in nums:
            for currSum in range(targetSum, num - 1, -1):
                dp[currSum] = dp[currSum] or dp[currSum - num]
        return dp[targetSum]
