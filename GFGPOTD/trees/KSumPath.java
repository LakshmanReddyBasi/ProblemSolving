// K Sum Paths
// Difficulty: MediumAccuracy: 44.73%Submissions: 117K+Points: 4
// Given a binary tree and an integer k, determine the number of downward-only paths where the sum of the node values in the path equals k. A path can start and end at any node within the tree but must always move downward (from parent to child).

// Examples:

// Input: k = 7   

// Output: 3
// Explanation: The following paths sum to k 
 
// Input: k = 3

// Output: 2
// Explanation:
// Path 1 : 1 -> 2 (Sum = 3)
// Path 2 : 3 (Sum = 3)


Soln:
class Solution {
    public int sumK(Node root, int k) {
        HashMap<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);
        return countPaths(root, k, 0, sumMap);
    }

    private int countPaths(Node node, int k, int runningSum, HashMap<Integer, Integer> sumMap) {
        if (node == null) return 0;

        runningSum += node.data;

        int count = sumMap.getOrDefault(runningSum - k, 0);

        sumMap.put(runningSum, sumMap.getOrDefault(runningSum, 0) + 1);

        count += countPaths(node.left, k, runningSum, sumMap);
        count += countPaths(node.right, k, runningSum, sumMap);

        sumMap.put(runningSum, sumMap.get(runningSum) - 1);

        return count;
    }

}
