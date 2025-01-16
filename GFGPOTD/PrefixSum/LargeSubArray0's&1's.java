Largest subarray of 0's and 1':

// Given an array arr of 0s and 1s. Find and return the length of the longest subarray with equal number of 0s and 1s.

// Examples:

// Input: arr[] = [1, 0, 1, 1, 1, 0, 0]
// Output: 6
// Explanation: arr[1...6] is the longest subarray with three 0s and three 1s.
// Input: arr[] = [0, 0, 1, 1, 0]
// Output: 4
// Explnation: arr[0...3] or arr[1...4] is the longest subarray with two 0s and two 1s.
// Input: arr[] = [0]
// Output: 0
// Explnation: There is no subarray with an equal number of 0s and 1s.


Soln:

class Solution {
    public int maxLen(int[] arr) {
        // Your code here
        HashMap<Integer, Integer> mp = new HashMap<>();

        int preSum = 0;
        int res = 0;

        for (int i = 0; i < arr.length; i++) {

            preSum += (arr[i] == 0) ? -1 : 1;

            if (preSum == 0)
                res = i + 1;

            if (mp.containsKey(preSum))
                res = Math.max(res, i - mp.get(preSum));

            else
                mp.put(preSum, i);
        }

        return res;
    }
}
