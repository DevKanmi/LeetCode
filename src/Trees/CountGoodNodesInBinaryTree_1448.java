package Trees;

/*
Link: https://leetcode.com/problems/count-good-nodes-in-binary-tree/
difficulty: Medium

Approach:
The approach taken is to keep track of the max value found in a particular path, if the node we are
at is greater then increment our result by initializing 1 to our res variable so the 1 is propagated and keeps
being added till we arrive at the root node then everything is added all together to get the no of good nodes.
 */

public class CountGoodNodesInBinaryTree_1448 {
    public int goodNodes(TreeNode root) {
        //Start max with value at root.
        int max = root.val;
        return good(root, max);

    }

    private int good(TreeNode root, int max) {
        //What is Base Case?
        if (root == null) {
            return 0;
        }

        int res;
        //Set result to  1 whenever a node is greater than max and update the max var
        //What does the recursive function do? => Updates result base on the max variable and root value
        if (root.val >= max) {
            res = 1;
        } else {
            res = 0;
        }

        max = Math.max(root.val, max);

        //What changes in each recursive call? => Result value
        res += good(root.left, max);
        res += good(root.right, max);

        //What is returned? => Result
        return res;
    }
}
