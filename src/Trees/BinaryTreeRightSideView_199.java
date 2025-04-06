package Trees;
/*
Link: https://leetcode.com/problems/binary-tree-right-side-view/
Difficulty: Medium
Approach: Keep track of the rightmost side at each level with a variable rightNode at the end of traversing
each leve, the node still in the rightNode can be said to be our rightmost node hence we can add that to a list
to store it.
 */
public class BinaryTreeRightSideView_199 {
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        List<Integer> res = new ArrayList<Integer>();
        if(root == null){
            return res;
        }
        q.offer(root);

        while(!q.isEmpty()){
            int length = q.size();
            TreeNode rightNode = null;

            for(int i = 0; i< length; i++){
                TreeNode node = q.poll();
                if(node != null){
                    rightNode = node;
                    if(node.left != null) q.offer(node.left);
                    if(node.right != null) q.offer(node.right);
                }
            }
            if(rightNode != null){
                res.add(rightNode.val);
            }

        }
        return res;
    }
}
