// Pair Sum in BST
// Difficulty: MediumAccuracy: 44.02%Submissions: 75K+Points: 4Average Time: 40m
// Given a Binary Search Tree(BST) and a target. Check whether there's a pair of Nodes in the BST with value summing up to the target. 

// Examples:

// Input: root = [7, 3, 8, 2, 4, N, 9], target = 12
//        bst
// Output: True
// Explanation: In the binary tree above, there are two nodes (8 and 4) that add up to 12.
// Input: root = [9, 5, 10, 2, 6, N, 12], target = 23
//           bst-3
// Output: False
// Explanation: In the binary tree above, there are no such two nodes exists that add up to 23.

Soln:



/*
class Node {
    int data;
    Node left, right;

    public Node(int d) {
        data = d;
        left = right = null;
    }
}
*/
class Solution {
    HashSet<Integer> set = new HashSet<>();

    boolean findTarget(Node root, int target) {
        // Write your code here
        inorder(root);
        for (int ele : set){
            if(set.contains(target-ele) && target-ele!=ele){
                return true;
            }
        }
        return false;
    }
    void inorder(Node root){
        if(root==null){
            return;
        }
        
        inorder(root.left);
        set.add(root.data);
        inorder(root.right);
        
    }
    
}
