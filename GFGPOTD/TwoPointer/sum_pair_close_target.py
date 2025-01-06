# Sum Pair closest to target
# Difficulty: EasyAccuracy: 44.75%Submissions: 52K+Points: 2
# Given an array arr[] and a number target, find a pair of elements (a, b) in arr[], where a<=b whose sum is closest to target.
# Note: Return the pair in sorted order and if there are multiple such pairs return the pair with maximum absolute difference. If no such pair exists return an empty array.

# Examples:

# Input: arr[] = [10, 30, 20, 5], target = 25
# Output: [5, 20]
# Explanation: As 5 + 20 = 25 is closest to 25.
# Input: arr[] = [5, 2, 7, 1, 4], target = 10
# Output: [2, 7]
# Explanation: As (4, 7) and (2, 7) both are closest to 10, but absolute difference of (2, 7) is 5 and (4, 7) is 3. Hence, [2, 7] has maximum absolute difference and closest to target. 
# Input: arr[] = [10], target = 10
# Output: []
# Explanation: As the input array has only 1 element, return an empty array.


Soln:

class Solution:
    def sumClosest(self, arr, target):
        arr.sort()
        left = 0
        right = len(arr) - 1
        closest_sum = float('inf')
        result_pair = []

        while left < right:
            current_sum = arr[left] + arr[right]
            abs_diff = abs(arr[right] - arr[left])
            
            if abs(current_sum - target) < abs(closest_sum - target):
                closest_sum = current_sum
                result_pair = [arr[left], arr[right]]
            elif abs(current_sum - target) == abs(closest_sum - target):
                if abs_diff > abs(result_pair[1] - result_pair[0]):
                    result_pair = [arr[left], arr[right]]

            if current_sum < target:
                left += 1
            elif current_sum > target:
                right -= 1
            else:
                break

        return result_pair
