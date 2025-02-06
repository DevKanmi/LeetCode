package Arrays;
import

import java.util.HashMap;

/*
Difficulty : Medium
Link: https://leetcode.com/problems/tuple-with-same-product/
Concepts used here: Permutations, sliding window, two pointers and hashtable

Approach: I used the hashtable to store each product and each frequency, since each
integer in the array was unique, It was easy to traverse without having to worry about duplicate
products I set my 2 pointers to index 0 and 1, and when my second pointer had reached the last index
i updated my left pointer to point to the next element and brought back my right pointer to l+1
after i stored each product and their frequency in the array

To count how many times they can be rearranged you initialize a count variable
and add to it  4 * (freq) * (freq - 1) you do it for every freq count.

 */

public class TupleWithSameProduct_1726 {
    public int tupleSameProduct(int[] nums) {
        int l = 0, r = l + 1, count = 0;

        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        while(r < nums.length){
            int product = nums[l] * nums[r];
            map.put(product, map.getOrDefault(product, 0) + 1);
            if( r == nums.length - 1){
                l++;
                r = l+1;
            }
            else{
                r++;
            }
        }
        for(int i : map.values()){
            count = count + (4 * i * (i - 1));
        }
        return count;
    }
}
