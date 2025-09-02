// Given an array of integers nums and an integer k, return the total number of subarrays whose sum equals to k.

// A subarray is a contiguous non-empty sequence of elements within an array.

 

// Example 1:

// Input: nums = [1,1,1], k = 2
// Output: 2
// Example 2:

// Input: nums = [1,2,3], k = 3
// Output: 2


Soln:

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> prefixSum=new HashMap<>();
        prefixSum.put(0,1);
        int sum=0;
        // int maxLen=0;
        int count=0;
        for (int i=0;i<nums.length;i++){
            sum+=nums[i];
            if (prefixSum.containsKey(sum-k)){
                // maxLen=Math.max(maxLen,i-prefixSum.get(sum-k)+1);
                count+= prefixSum.get(sum - k);
            }
            // if(!prefixSum.containsKey(sum)){
            //     prefixSum.put(sum,i);
            // }
            // if ()
            prefixSum.put(sum, prefixSum.getOrDefault(sum, 0) + 1);

        }
        return count;

    }
}
