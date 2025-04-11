package BackTracking;

/*
Link:
Difficulty:
Approach: The Approach here is having a backtracking function where now our take call is repeatedly calling a single
index till the value at that index is greater than the target after continuously subracting then we remove that index
and move on to the other indexes in our not take function till we reach the end where we start returning and taking care
of things along the way

Time Complexity: O(N^T/M + 1)

As we illustrated before, the execution of the backtracking is unfolded as a DFS traversal in a n-ary tree.
The total number of steps during the backtracking would be the number of nodes in the tree.

At each node, it takes a constant time to process, except the leaf nodes which could take a linear time to make a copy of combination. So we can say that the time complexity is linear to the number of nodes of the execution tree.

Here we provide a loose upper bound on the number of nodes.

First of all, the fan-out of each node would be bounded to N, i.e. the total number of candidates.

The maximal depth of the tree, would be T/M

 , where we keep on adding the smallest element to the combination.

As we know, the maximal number of nodes in N-ary tree of
T/M
  height would be N
(N^T/M + 1)

Note that, the actual number of nodes in the execution tree would be much smaller than the upper bound, since the fan-out of the nodes are decreasing level by level.

Space Complexity: O(T/M)

We implement the algorithm in recursion, which consumes some additional memory in the function call stack.

The number of recursive calls can pile up to
T/M
 , where we keep on adding the smallest element to the combination.
As a result, the space overhead of the recursion is O(
O(T/M)

In addition, we keep a combination of numbers during the execution, which requires at most O(
O(T/M)
 ) space as well.

To sum up, the total space complexity of the algorithm would be O(
O(T/M)
 */
public class CombnationSum_39 {

    List<List<Integer>> comb = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        backtracking(0, list, target, candidates);

        return comb;
    }

    private void backtracking(int idx, List<Integer> list, int target, int[] candidates){
        //Base case
        if(idx == candidates.length){
            if(target == 0){
                comb.add(new ArrayList<>(list));
                return;
            }
            else{
                return;
            }
        }

        // Take -> This is where we repeatedly take the number at a single index
        list.add(candidates[idx]);
        if(candidates[idx] <= target) backtracking(idx, list, target - candidates[idx], candidates);

        //Not take -> We move on to the next index now
        list.remove(list.size() - 1);
        backtracking(idx + 1, list, target, candidates);
    }

}
