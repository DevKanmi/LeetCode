package Trees;

/*
Link: https://leetcode.com/problems/validate-binary-search-tree/description/
Difficulty: Medium

Approach : The Idea is having a min and max value to compare each node we are at, so at the left node we are comparing
 it to (min, root value) if it is the right of the left subtree it's min value is typically the preceding parent and max
 the root node,so our node must fall within this range for valid bst and for right nodes we are comparing
 it with (root value, max) meaning every value at right must always be greater than the root node value but less
  than the max which could be the parent node if we are at the left of right sub tree of a generic max value if
  we are the right of a right subtree.
 */
public class ValidateBinarySearchTree_98 {



    private static boolean ValidateBST(TreeNode root, long left, long right){
        if(root == null){
            return true;
        }

        //In bst root must always be greater than left and less than right, this checks if that still holds
        if(root.val <= left || root.val >= right){
            return false;
        }
        //left -> minimum value, right -> Maximum value
        //So at root.left all nodes must be lesser than the value at the root node
        // at root.right all nodes must be greater than value at root node
        return validateBST(root.left, left, root.val) && validateBST(root.right, root.val, right);
        //                  [val , minRange, maxRange]
        //                 eg[4, 5, 6] => Valid node it is greater than 5 and less than 6
        //                 eg[7, 5, 6] => Invalid Node, it is not less than 5 and greater than 7
    }
}
