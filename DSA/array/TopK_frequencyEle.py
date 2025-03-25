# Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

# Example 1:

# Input: nums = [1,1,1,2,2,3], k = 2
# Output: [1,2]
# Example 2:

# Input: nums = [1], k = 1
# Output: [1]
 

# Constraints:

# 1 <= nums.length <= 105
# -104 <= nums[i] <= 104
# k is in the range [1, the number of unique elements in the array].
# It is guaranteed that the answer is unique.


Soln:
class Solution:
    def topKFrequent(self, nums, k):
        freq = {}  
        l = []  

        for i in nums:
            if i in freq:
                freq[i] += 1
            else:
                freq[i] = 1
        
        sorted_freq = sorted(freq, key=lambda x: freq[x], reverse=True)

        for i in range(k):
            l.append(sorted_freq[i])
        return l 


                                            (OR)

  Using Heap:

class Solution:
    def topKFrequent(self, nums: List[int], k: int) -> List[int]:
        count_data = Counter(nums)

        top_k = heapq.nlargest(k, count_data.items(), key=lambda x: x[1])

        result = [item[0] for item in top_k]

        return result
