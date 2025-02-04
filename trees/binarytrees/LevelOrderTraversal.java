// Given the root of a binary tree, return the level order traversal of its nodes' values. (i.e., from left to right, level by level).

 

// Example 1:


// Input: root = [3,9,20,null,null,15,7]
// Output: [[3],[9,20],[15,7]]
// Example 2:

// Input: root = [1]
// Output: [[1]]
// Example 3:

// Input: root = []
// Output: []


Soln:

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<List<Integer>> result = new ArrayList<>();
        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> current = new ArrayList<>();
            for(int i = queue.size(); i > 0; i--){
                TreeNode currentNode = queue.poll();
                if(currentNode != null){
                    current.add(currentNode.val);
                    queue.add(currentNode.left);
                    queue.add(currentNode.right);
                }
                
            }

            if(current.size() > 0){
                result.add(current);
            }
        }

        return result;
    }
}
