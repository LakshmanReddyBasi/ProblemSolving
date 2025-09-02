// Given an array arr[] consisting of n integers, the task is to find all the array elements which occurs more than floor(n/3) times.

// Note: The returned array of majority elements should be sorted.

// Examples:

// Input: arr[] = [2, 2, 3, 1, 3, 2, 1, 1]
// Output: [1, 2]
// Explanation: The frequency of 1 and 2 is 3, which is more than floor n/3 (8/3 = 2).
// Input:  arr[] = [-5, 3, -5]
// Output: [-5]
// Explanation: The frequency of -5 is 2, which is more than floor n/3 (3/3 = 1).
// Input:  arr[] = [3, 2, 2, 4, 1, 4]
// Output: []
// Explanation: There is no majority element.


SOln:
class Solution {
    public ArrayList<Integer> findMajority(int[] arr) {
        int n = arr.length;
        ArrayList<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        // Count frequencies
        for (int num : arr) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        // Collect elements whose frequency > n/3
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > (n / 3)) {
                res.add(entry.getKey());
            }
        }

        // If empty, return [-1]
        // if (res.isEmpty()) res.add(-1);

        // Sort result
        Collections.sort(res);
        return res;
    }
}
