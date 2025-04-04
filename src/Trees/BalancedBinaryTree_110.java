package Trees;

/*
LInk: https://leetcode.com/problems/balanced-binary-tree/
Difficulty: Easy
Approach: The idea to this is simple, we are using finding the height of a binary tree with a twist
we are not going to have conditonal statements at certain places to return a value eg -1 if we have the left - right
subtree > 1, and then we can now check each individal recursive call if we have -1 being returned, you return -1 to the
main method and now use it to form a boolean expression that as long as we don't see -1 the tree is balanced and true is
returned
 */

public class BalancedBinaryTree_110 {
    public boolean isBalanced(TreeNode root) {
        return check(root) != -1;
    }
    private int check(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = check(root.left);
        if (left == -1)
            return -1;
        int right = check(root.right);
        if (right == -1)
            return -1;
        if (Math.abs(left - right) > 1){
            System.out.println(root.val);
            return -1;
        }
        return Math.max(left, right) + 1;
    }
}
