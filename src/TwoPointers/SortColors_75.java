package TwoPointers;

/*
Medium Leetcode --> https://leetcode.com/problems/sort-colors/description/?envType=problem-list-v2&envId=two-pointers

TWO METHODS COULD BE USED
1. USING HASHMAPS TO STOR THE NUMBERS AND THEIR FREQUENCY TO ENSURE IT IS IN ASCENDING ORDER
MANUALLY PUSH KEYS (O, 1 ,2) IN THAT FORMAT USING
 MAP.PUT(0,0)
 MAP.PUT(1,0)
 MAP.PUT(2,0)
 THEN YOU CAN EASILY PUSH VALUES FROM THE ARRAY AND ANOTHER FOR LOOP TO GO THROUGH THE HASHMAP
 TO POPULATE A RESULT ARRAY THAT CONTAINS THE SORTED COLORS.

 2. THE USE OF DNF ALGORTIHM, 3 POINTERS IS EMPLOYED IN THIS CASE,
 THE LOW , HIGH AND THE MOVING POINTER, WE SWAP MOVING POINTER WITH LOW OR HIGH AND EITHER INCREASE OR DECREASE BASED
 ON THEIR VALUE
 */

public class SortColors_75 {
    public void sort(int[] nums){
        int l = 0;
        int r = nums.length -1;
        int i =0;
        int temp;

        while(l <= r){
            if(nums[i] == 0){
                temp = nums[l];
                nums[l] = nums[i];
                nums[i] = temp;
                l++;
                i++; // we can increase the pointer in this case, because we know the lowend is sorted.
            } else if (nums[i] == 2) {
                temp = nums[r];
                nums[r] = nums[i];
                nums[i] = temp;
                r--;
            }
            else {
                i++;
            }
        }
    }
}
