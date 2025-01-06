// # Count all triplets with given sum in sorted array
// # Difficulty: MediumAccuracy: 48.57%Submissions: 44K+Points: 4
// # Given a sorted array arr[] and a target value, the task is to count triplets (i, j, k) of valid indices, such that arr[i] + arr[j] + arr[k] = target and i < j < k.

// # Examples:

// # Input: arr[] = [-3, -1, -1, 0, 1, 2], target = -2
// # Output: 4
// # Explanation: Two triplets that add up to -2 are:
// # arr[0] + arr[3] + arr[4] = (-3) + 0 + (1) = -2
// # arr[0] + arr[1] + arr[5] = (-3) + (-1) + (2) = -2
// # arr[0] + arr[2] + arr[5] = (-3) + (-1) + (2) = -2
// # arr[1] + arr[2] + arr[3] = (-1) + (-1) + (0) = -2
// # Input: arr[] = [-2, 0, 1, 1, 5], target = 1
// # Output: 0
// # Explanation: There is no triplet whose sum is equal to 1. 


soln:


class Solution {
    public int countTriplets(int[] arr, int target) {
        int ans = 0;
        int n = arr.length;
      
        // Fix the first element and use two pointers for remaining elements
        for(int i = 0; i < n-2; i++) {
            // Two pointers: one from element after i and one from end
            int j = i + 1;
            int k = n - 1;
            
            // While the two pointers don't cross
            while(j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                
                if(sum == target) {
                    // Count all combinations with current 'k'
                    int x = k;
                    while(x > j && arr[i] + arr[j] + arr[x] == target) {
                        ans++;
                        x--;
                    }
                    j++;
                }
                else if(sum > target) {
                    k--;
                }
                else {
                    j++;
                }
            }
        }
        return ans;
    }
}
