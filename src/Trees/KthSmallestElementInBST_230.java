package Trees;
/*
Link:
Difficulty: Medium

Approach: There are 3 approaches

#Approach 1
Use of a dfs traversal algrorithm postorder and preorder
in this approach you create a list populate it with the value at each node in the tree and then
sort the list when done and return the list[k-1] element to get the list.

this is the naive approach as the time complexity is o(nlogn) due to the sorting on the list,

#Approach 2
In approach 2 we could make use of inorder traversal, since it is a bst, in order traversal will produce a
sorted list and you would not need to sort it again, converting it to o(n) but still a list is needed
then we can return list[k-1]

#Approach 3
Third approach eliminates the use of list, we would still be making use of the inorder traversal to keep track
as inorder recursively goes through the tree in sorted form so we have a count and a result variable as a class
variable(IMPORTANT) then we can adjust it in our helper function, so whenever we are done with the
root.left we increment our count variable and now check if count == k, if so we assign the val of that node to result
and we can return (our helper function is going to be void) if it is not equals to k when done with left, we go to right
and do the same thing, then in our main method we just simply return the result variable.

time => o(n)
space => o(1) auxillary recursive stack is there also.

 */
public class KthSmallestElementInBST_230 {
    int result = 0, count = 0; // Class Variable accessible across all methods
    public int kthSmallest(TreeNode root, int k) {
        smallest(root, k);
        return res;
    }

    private void smallest(TreeNode root, int k){
        if(root == null){
            return;
        }
        smallest(root.left, k);
        count++;
        if(count == k){
            res = root.val;
            return;
        }

        smallest(root.right, k);
    }
}
