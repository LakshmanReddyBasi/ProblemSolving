// Diameter of a Binary Tree
// Difficulty: MediumAccuracy: 47.37%Submissions: 325K+Points: 4Average Time: 20m
// Given a binary tree, the diameter (also known as the width) is defined as the number of edges on the longest path between two leaf nodes in the tree. This path may or may not pass through the root. Your task is to find the diameter of the tree.

// Examples:

// Input: root[] = [1, 2, 3]

// Output: 2
// Explanation: The longest path has 2 edges (node 2 -> node 1 -> node 3).

// Input: root[] = [5, 8, 6, 3, 7, 9]

// Output: 4
// Explanation: The longest path has 4 edges (node 3 -> node 8 -> node 5 -> node 6 -> node 9).



Soln:
class Solution {
    int diameter = 0;

    int diameter(Node root) {
        height(root);
        return diameter - 1;  // Subtract 1 to get the number of edges
    }

    int height(Node root) {
        if (root == null) return 0;

        int lheight = height(root.left);
        int rheight = height(root.right);

        diameter = Math.max(diameter, lheight + rheight + 1);

        return 1 + Math.max(lheight, rheight);
    }
}
