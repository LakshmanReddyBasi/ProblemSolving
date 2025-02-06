// Given two arrays representing the inorder and preorder traversals of a binary tree, construct the tree and return the root node of the constructed tree.

// Note: The output is written in postorder traversal.

// Examples:

// Input: inorder[] = [1, 6, 8, 7], preorder[] = [1, 6, 7, 8]
// Output: [8, 7, 6, 1]
// Explanation: The tree will look like

// Input: inorder[] = [3, 1, 4, 0, 2, 5], preorder[] = [0, 1, 3, 4, 2, 5]
// Output: [3, 4, 1, 5, 2, 0]
// Explanation: The tree will look like

// Input: inorder[] = [2, 5, 4, 1, 3], preorder[] = [1, 4, 5, 2, 3]
// Output: [2, 5, 4, 3, 1]
// Explanation: The tree will look like


Soln:

class Solution {

    static int search(int[] inorder, int value, int left, int right) {
        for (int i = left; i <= right; i++) {
            if (inorder[i] == value)
                return i;
        }
        return -1;
    }

    public static Node buildTreeRecur(int[] inorder, int[] preorder, int[] preIndex, int left, int right) {

        if (left > right)
            return null;

        int rootVal = preorder[preIndex[0]];
        preIndex[0]++;

        Node root = new Node(rootVal);

        int index = search(inorder, rootVal, left, right);

        root.left = buildTreeRecur(inorder, preorder, preIndex, left, index - 1);
        root.right = buildTreeRecur(inorder, preorder, preIndex, index + 1, right);

        return root;
    }


    static Node buildTree(int[] inorder, int[] preorder) {
        int[] preIndex = {0};
        return buildTreeRecur(inorder, preorder, preIndex, 0, preorder.length - 1);
    }
}

