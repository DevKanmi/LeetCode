package Trees;

/*
Three types
1. Inorder Traversal => left -> parent -> right link: https://leetcode.com/problems/binary-tree-inorder-traversal/
2. Preorder Traversal => parent -> left -> right link: https://leetcode.com/problems/binary-tree-preorder-traversal/
3. Postorder Traversal => left -> right -> parent link: https://leetcode.com/problems/binary-tree-postorder-traversal


two approach
1. Recursion with the use of a helper function that does the recursive call: all three have a similar apprach
you just need to follow their rules, it is all about how you arrange them
2. iterative with the use of a stack
 */

import javax.swing.tree.TreeNode;
import java.util.ArrayList;
import java.util.List;

public class DepthFirstTraversal {
    public List<Integer> DFTraversal(TreeNode root) {

        ArrayList<Integer> result = new ArrayList<>();
        helper(root, result);
        return result;
    }

    private static void helper(TreeNode root, List<Integer> result){
        // Base case
        if(root == null){
            return;
        }
        // Postorder => left -> right -> parent
        helper(root.left, result); //left
        helper(root.right, result); //right
        result.add(root.val); //parent

        // Preorder => parent -> left -> right
        result.add(root.val);  //parent
        helper(root.left, result);  //left
        helper(root.right, result); // right

        // Inorder => left -> parent -> right
        helper(root.left, result); //left
        result.add(root.val);  //parent
        helper(root.right, result);  //right

    }
}
