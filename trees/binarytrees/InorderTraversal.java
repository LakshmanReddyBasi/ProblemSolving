// 94. Binary Tree Inorder Traversal
// Solved
// Easy
// Topics
// Companies
// Given the root of a binary tree, return the inorder traversal of its nodes' values.

 

// Example 1:

// Input: root = [1,null,2,3]

// Output: [1,3,2]

// Explanation:



// Example 2:

// Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

// Output: [4,2,6,5,7,1,3,9,8]

// Explanation:



// Example 3:

// Input: root = []

// Output: []

// Example 4:

// Input: root = [1]

// Output: [1]


Soln:
// recursive 

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> lst=new ArrayList<>();
        inOrder(root,lst);
        return lst;
    }
    public void inOrder(TreeNode root,List<Integer > lst){
        if(root==null) return ;
        inOrder(root.left,lst);
        lst.add(root.val);
        inOrder(root.right,lst);
    }
}




--------------------------------------------------------------------
Iterative:
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {        
        List<Integer> inOrder  = new ArrayList<>();
        if(root==null) return inOrder;
        Stack <TreeNode> st = new Stack<>();
        TreeNode current =root;
        while(current!=null || !st.isEmpty()){
            while(current!=null){
                st.push(current);
                current = current.left;
            }
            current = st.pop();
            inOrder.add(current.val);
            current = current.right;
        }

        return inOrder;
        
    }
}
