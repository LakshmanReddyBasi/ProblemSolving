// Given a root of a binary tree with n nodes, the task is to find its level order traversal. Level order traversal of a tree is breadth-first traversal for the tree.

// Examples:

// Input: root[] = [1, 2, 3]

// Output: [[1], [2, 3]]
// Input: root[] = [10, 20, 30, 40, 50]

// Output: [[10], [20, 30], [40, 50]]
// Input: root[] = [1, 3, 2, N, N, N, 4, 6, 5]

// Output: [[1], [3, 2], [4], [6, 5]]


Soln:

class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(Node root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        
        if (root == null)
            return res;
        
        Queue<Node> q = new LinkedList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int size = q.size();
            ArrayList<Integer> level = new ArrayList<>();

            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                level.add(curr.data);
                
                if (curr.left != null)
                    q.add(curr.left);
                if (curr.right != null)
                    q.add(curr.right);
            }
            res.add(level);
        }
        return res;
    }
}
