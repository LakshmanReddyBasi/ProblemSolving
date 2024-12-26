// Given an array arr[] of positive integers and another integer target. Determine if there exists two distinct
// indices such that the sum of there elements is equals to target. 

class Solution {
    boolean twoSum(int arr[], int target) {
        // code here
        Set<Integer> seen = new HashSet<>();
        for (int num : arr) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}
