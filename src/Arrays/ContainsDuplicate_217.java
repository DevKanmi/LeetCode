package Arrays;

import java.util.HashSet;

public class ContainsDuplicate_217 {
    public boolean containsDuplicate(int[] nums) {
        //O(n2)
        /*
        What we would do in this take 2 for loops the first for loop is at an index and the inner for loop will move through and check if there are any elements that appear in the array, we return true if not return false

       //o(nlogn)
        We can sort the array then make use of 2 pointers, since when we sort the arrray elements that appear twice will follow each other so we set the first pointer to i and next one to i + 1 and if we find both being ewual we return true

        //o(n) and a space complexity of o(n)
        We can create a hashset and we push the elements into the set and the have a check that runs in o(1) and checks if whatever element we want to push into the set is present then we can return true if the element is already present
        */
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }
}
