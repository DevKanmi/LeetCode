package Trees;

/*
Link: https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/editorial/
Difficulty: Medium

Approach: The Simple approach is to just check in two if statements if we have the root.val to be
greater than(>) both p.val and q.val, apply recursion to the root.left
else if less than(<) both p.val and q.val apply recursion to root.right
finally return root in an else statement
 */

public class LowestCommonAncestorOfABinarySearchTree_235 {
    /*
    My Approach

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return root;
        }

        if(p.val <= root.val && q.val >= root.val){
            return root;
        }

        if(p.val >= root.val && q.val <= root.val && p.val > q.val){
            return root;
        }

        if(p.val <= root.val && root.left != null){
            return lowestCommonAncestor(root.left, p, q);
        }

        if(q.val >= root.val && root.right != null){
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }
     */

    //Best Approach

    class Solution {
        public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
            if(root == null){
                return root;
            }
            if (p.val > root.val && q.val > root.val) {
                // If both p and q are greater than parent
                return lowestCommonAncestor(root.right, p, q);
            } else if (p.val < root.val && q.val < root.val) {
                // If both p and q are lesser than parent
                return lowestCommonAncestor(root.left, p, q);
            } else {
                // We have found the split point, i.e. the LCA node.
                return root;
            }
        }
    }
}
