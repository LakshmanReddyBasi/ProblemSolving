// 144. Binary Tree Preorder Traversal
// Solved
// Easy
// Topics
// Companies
// Given the root of a binary tree, return the preorder traversal of its nodes' values.

 

// Example 1:

// Input: root = [1,null,2,3]

// Output: [1,2,3]

// Explanation:
// Example 2:

// Input: root = [1,2,3,4,5,null,8,null,null,6,7,9]

// Output: [1,2,4,5,6,7,3,8,9]

// Explanation:
// Example 3:

// Input: root = []

// Output: []

// Example 4:

// Input: root = [1]

// Output: [1]


SOln:
//recursive
class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> lst=new ArrayList<>();
        preOrder(root,lst);
        return lst;
    }
    public void preOrder(TreeNode root,List<Integer > lst){
        if(root==null) return ;
        lst.add(root.val);
        preOrder(root.left,lst);
        preOrder(root.right,lst);
    }
}



                                           (OR)
           ----------------------------------------------------------------------------------------------------


Itterative:

                                            class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        
        List<Integer> pre  = new ArrayList<>();
        if(root==null) return pre;
        Stack <TreeNode> st = new Stack<>();
        st.push(root);
        while(!st.empty()){
            TreeNode node = st.pop();
            pre.add(node.val);
            if(node.right!=null){
                st.push(node.right);
            }
            if(node.left!=null){
                st.push(node.left);
            }
        }
        return pre;
        
    }
}
