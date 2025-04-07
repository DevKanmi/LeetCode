package BackTracking;

/*
Link: https://leetcode.com/problems/subsets/description/
Difficulty: Medium
Approach: This involves the use of recursion and backtracking, so basically, we have a rule : take or not take
for example [1,2,3] a length of 3
so basically at index 0  we can choose to take  0,1,2 or take 0, not take 1 and take 2, or take 0 , take 1 and not take 2
or not take 0,  take 1 and take 2 so as we move through the index this is the main idea, we have 2 options take the
element at the previous index with you to the next index or don't take it

so this is a Tc of o(2^n) we are taking each index twice
a sc of o(n) we have an array list to store the subsets
 */

public class SubSets_78 {
    List<List<Integer>> subset =  new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> list = new ArrayList<>();
        addSubSet(0, list, nums);

        return subset;
    }

    private void addSubSet(int idx, List<Integer> list, int[] nums){
        //Base case
        if(idx == nums.length){
            subset.add(new ArrayList<>(list));
            return;
        }

        //Take Element at that index with you to the next index
        list.add(nums[idx]);
        addSubSet(idx + 1, list, nums);

        //Do Not Take that element at the current index with you to the next index
        list.remove(list.size() - 1);
        addSubSet(idx + 1, list, nums);
    }
}
