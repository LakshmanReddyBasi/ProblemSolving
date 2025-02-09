// Maximum path sum from any node
// Difficulty: MediumAccuracy: 42.92%Submissions: 89K+Points: 4Average Time: 45m
// Given a binary tree, the task is to find the maximum path sum. The path may start and end at any node in the tree.

// Examples:

// Input: root[] = [10, 2, 10, 20, 1, N, -25, N, N, N, N, 3, 4]
// Output: 42
// Explanation: 

// Max path sum is represented using green colour nodes in the above binary tree.
// Input: root[] = [-17, 11, 4, 20, -2, 10]
// Output: 31
// Explanation: 

// Max path sum is represented using green colour nodes in the above binary tree.

Soln:

class Solution {
    // Function to return maximum path sum from any node in a tree.
    int findMaxSum(Node node) {
        int[] res = {node.data};

        maxPathSumUtil(node, res);

        return res[0];
    }
    static int maxPathSumUtil(Node root, int[] res) {
        if (root == null) return 0;

        int l = Math.max(0, maxPathSumUtil(root.left, res));
        int r = Math.max(0, maxPathSumUtil(root.right, res));

        res[0] = Math.max(res[0], l + r + root.data);

        return root.data + Math.max(l, r);
    }


