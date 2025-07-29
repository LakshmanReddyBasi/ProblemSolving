Problem: Find two numbers in the array that add up to a specific target.
Solution:

class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        n=len(nums)
        l=[]
        for i in range(n):
            for j in range(i+1,n):
                if nums[i]+nums[j]==target:
                    l.append(i)
                    l.append(j)
        return l

_______________________________________________________________________________

python
def twoSum(nums: List[int], target: int) -> List[int]:
    value_to_index = {}
    for i, num in enumerate(nums):
        complement = target - num
        if complement in value_to_index:
            return [value_to_index[complement], i]
        value_to_index[num] = i
    return []


______________________________________________________________________________
Java:

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> valueToIndex = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (valueToIndex.containsKey(complement)) {
                return new int[] { valueToIndex.get(complement), i };
            }
            valueToIndex.put(nums[i], i);
        }
        return new int[0]; // return empty array if no solution found
    }
}
