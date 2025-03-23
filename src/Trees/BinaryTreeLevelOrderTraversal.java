package Trees;
/*
Link: https://leetcode.com/problems/binary-tree-level-order-traversal/
difficulty: Medium
Approach : Use of queues checking each level if it has a left or right child add to queue
 */
public class BinaryTreeLevelOrderTraversal {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }

        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> bfs = new LinkedList<List<Integer>>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int levelLength = queue.size();
            List<Integer> eachLevel = new LinkedList<Integer>();
            for(int i = 0; i < levelLength; i++){
                if(queue.peek().left != null)queue.offer(queue.peek().left);
                if(queue.peek().right != null)queue.offer(queue.peek().right);
                eachLevel.add(queue.poll().val);
            }
            bfs.add(eachLevel);
        }
        return bfs;
    }
}
