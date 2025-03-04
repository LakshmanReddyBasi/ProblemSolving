// Longest Increasing Subsequence
// Difficulty: MediumAccuracy: 32.8%Submissions: 327K+Points: 4
// Given an array arr[] of non-negative integers, the task is to find the length of the Longest Strictly Increasing Subsequence (LIS).

// A subsequence is strictly increasing if each element in the subsequence is strictly less than the next element.

// Examples:

// Input: arr[] = [5, 8, 3, 7, 9, 1]
// Output: 3
// Explanation: The longest strictly increasing subsequence could be [5, 7, 9], which has a length of 3.
// Input: arr[] = [0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15]
// Output: 6
// Explanation: One of the possible longest strictly increasing subsequences is [0, 2, 6, 9, 13, 15], which has a length of 6.
// Input: arr[] = [3, 10, 2, 1, 20]
// Output: 3
// Explanation: The longest strictly increasing subsequence could be [3, 10, 20], which has a length of 3.

Soln:
Using Binary_search


import java.util.*;

public class GFG {
    static int lengthOfLIS(int[] arr) {
        // Binary search approach
        int n = arr.length;
        List<Integer> ans = new ArrayList<>();

        // Initialize the answer list with the
        // first element of arr
        ans.add(arr[0]);

        for (int i = 1; i < n; i++) {
            if (arr[i] > ans.get(ans.size() - 1)) {
                  //we append the current number
                // to the answer list.
                ans.add(arr[i]);
            } else {

                // The binarySearch method returns
                // the index of the first element that is not less than
                // the current number.
                int low = Collections.binarySearch(ans, arr[i]);
                if (low < 0) {
                    low = -(low + 1);
                }
                ans.set(low, arr[i]);
            }
        }

        return ans.size();
    }

}

---------------------------------------------------------------------------------------------------------------------------------------------

 Using DP (Bottom Up Tabulation) – O(n^2) Time and O(n) Space

    static int lis(int arr[]) {
        int n = arr.length;
        
        int lis[] = new int[n];
      
        // Initialize LIS values for all indexes
        for (int i = 0; i < n; i++)
            lis[i] = 1;

        // Compute optimized LIS values in
        // bottom up manner
        for (int i = 1; i < n; i++)
            for (int prev = 0; prev < i; prev++)
                if (arr[i] > arr[prev] && lis[i] < lis[prev] + 1)
                    lis[i] = lis[prev] + 1;

        // Pick maximum of all LIS values
        int max = 1;
        for (int i = 0; i < n; i++)
            max = Math.max(max, lis[i]);

        return max;
    }
