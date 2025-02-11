class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        if(root==null){
            return list;
        }

        Queue <TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int count = queue.size();
            for (int i = 1; i<=count;i++){
                TreeNode Node = queue.poll();
                if(i==1){ //for left view           <<<------------------------------------------------------------------------------
                    list.add(Node.val);
                }
                if(Node.left!=null)
                    queue.add(Node.left);
                if(Node.right!=null)
                    queue.add(Node.right);
            }
        }
        return list;
    }
}
