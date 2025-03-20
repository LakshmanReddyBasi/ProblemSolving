# Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

# The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

# You must write an algorithm that runs in O(n) time and without using the division operation.

 

# Example 1:

# Input: nums = [1,2,3,4]
# Output: [24,12,8,6]
# Example 2:

# Input: nums = [-1,1,0,-3,3]
# Output: [0,0,9,0,0]
 

# Constraints:

# 2 <= nums.length <= 105
# -30 <= nums[i] <= 30
# The input is generated such that answer[i] is guaranteed to fit in a 32-bit integer.
 

# Follow up: Can you solve the problem in O(1) extra space complexity? (The output array does not count as extra space for space complexity analysis.)


SOln:

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        prod=1
        flag=False
        count_zero=0
        n=len(nums)

        for i in nums:
            if(i!=0):
                prod*=i
            else:
                flag=True
                count_zero+=1
        if count_zero>1:
            return [0]*n
        arr=[]
        for i in nums:
            if i!=0:
                if(flag):from typing import List

class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        n = len(nums)
        result = [1] * n
        prefix = 1
        suffix = 1

        # Calculate prefix product
        for i in range(n):
            result[i] = prefix
            prefix *= nums[i]

        # Calculate suffix product and multiply with result
        for i in range(n-1, -1, -1):
            result[i] *= suffix
            suffix *= nums[i]

        return result

                    arr.append(0)
                else:
                    arr.append(prod//i)
            else:
                arr.append(prod)
                
        return arr
        


                                      (or)

  using prefix ans suffix
