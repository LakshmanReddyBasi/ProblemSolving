# Given a list of non-negative integers nums, arrange them such that they form the largest number and return it.

# Since the result may be very large, so you need to return a string instead of an integer.

 

# Example 1:

# Input: nums = [10,2]
# Output: "210"
# Example 2:

# Input: nums = [3,30,34,5,9]
# Output: "9534330"
 

Soln:

class Solution:
    def largestNumber(self, nums: List[int]) -> str:
        nums_str = list(map(str, nums))
        
        # Sort using a trick: extend the number string to 10 chars by repeating
        nums_str.sort(key=lambda x: x*10, reverse=True)
        
        result = ''.join(nums_str)
        
        # Handle leading zero case like [0,0]
        return '0' if result[0] == '0' else result

____________________________________________________________

using Custom comparator:

from functools import cmp_to_key

class Solution:
    def largestNumber(self, nums):
        # Step 1: Convert all numbers to strings
        nums_str = list(map(str, nums))

        # Step 2: Define custom comparator
        def compare(a, b):
            if a + b > b + a:
                return -1  # a should come before b
            elif a + b < b + a:
                return 1   # b should come before a
            else:
                return 0   # order doesn't matter

        # Step 3: Sort using custom comparator
        nums_str.sort(key=cmp_to_key(compare))

        # Step 4: Join all numbers into a single string
        result = ''.join(nums_str)

        # Step 5: Handle edge case where result is like "0000"
        return '0' if result[0] == '0' else result
