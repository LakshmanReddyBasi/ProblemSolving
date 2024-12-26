// Count pairs with given sum
// Difficulty: EasyAccuracy: 43.87%Submissions: 3K+Points: 2
// Given an array arr[] and an integer target. You have to find numbers of pairs in array arr[] which sums up to given target.

// Examples:

// Input: arr[] = [1, 5, 7, -1, 5], target = 6 
// Output: 3
// Explanation: Pairs with sum 6 are (1, 5), (7, -1) and (1, 5). 
// Input: arr[] = [1, 1, 1, 1], target = 2 
// Output: 6
// Explanation: Pairs with sum 2 are (1, 1), (1, 1), (1, 1), (1, 1), (1, 1).
// Input: arr[] = [10, 12, 10, 15, -1], target = 125
// Output: 0

class Solution {
    public static int getPairsCount(int[] arr, int target) {
        // Using HashMap to store frequency of numbers
        HashMap<Integer, Integer> freq = new HashMap<>();
        int count = 0;
        
        // Count pairs in a single pass through the array
        for(int num : arr) {
            int complement = target - num;
            if(freq.containsKey(complement)) {
                count += freq.get(complement);
            }
            
            // Add current number to HashMap
            freq.put(num, freq.getOrDefault(num, 0) + 1);
        }
        
        return count;
    }
}
