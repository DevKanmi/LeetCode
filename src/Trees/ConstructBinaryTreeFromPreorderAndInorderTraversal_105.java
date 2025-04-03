package Trees;

import java.util.HashMap;

/*
Link:https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
Difficulty: Medium

Approach:
Build a hashmap for inorder {value:index} , so that we can find the position of root in constant time.
Initialize an integer variable preorderIndex to keep track of the element that will be used to construct the root.
Implement the recursion function buildTree which takes a range of inorder and returns the constructed binary tree:
if the range is empty, return null;
initialize the root with preorder[preorderIndex] and then increment preorderIndex;
recursively use the left and right portions of inorder to construct the left and right subtrees.
Simply call the recursion function with the entire range of inorder.

 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal_105 {
    class Solution {
        int preorderIndex;
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        public TreeNode buildTree(int[] preorder, int[] inorder) {
            preorderIndex = 0;
            // build a hashmap to store value -> its index relations
            for (int i = 0; i < inorder.length; i++) {
                map.put(inorder[i], i);
            }

            return build(preorder, 0, preorder.length - 1);
        }

        private TreeNode build(int[] preorder, int left, int right) {
            // if there are no elements to construct the tree
            if (left > right) return null;

            // select the preorder_index element as the root and increment it
            int rootValue = preorder[preorderIndex++];
            TreeNode root = new TreeNode(rootValue);

            // build left and right subtree
            // excluding map[rootValue] element because it's the root
            root.left = build(
                    preorder,
                    left,
                    map.get(rootValue) - 1
            );
            root.right = build(
                    preorder,
                    map.get(rootValue) + 1,
                    right
            );
            return root;
        }
    }
}
