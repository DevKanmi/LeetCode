package Arrays;

import java.util.HashSet;

/*
        The idea here was first eliminate the duplicates throught the set and the next thing we needed was a way to
         search elements in o(1) tc, and using a hashset was perfect for me so basically the idea for me was to pick
         each element in the hashset and basically i check if we find an element bigger by 1 instead of using the
         while loop to waste time we can just skip it becuase in the future we are going to get somethig longer,
         so now if we get to an element that we could not longer increase by 1 we use the while loop to run a condition
          whereby if we keep finding elements smaller by 1 we increment the longest we have found so far and after that
           is done we comapre with the max found so far.

        This is a TC of o(N) and a SC of o(N)
        */

public class LongestConsecutiveSequence_128 {
    public int longestConsecutive(int[] nums) {

        if(nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int i : nums){
            set.add(i);
        }

        int longest = 1;
        for(int i : set){
            int n = i;
            int curr = 1;
            if(set.contains(n + 1)) continue;

            while(set.contains(n - 1)){
                curr++;
                longest = Math.max(longest, curr);
                n--;
            }
        }
        return longest;
    }
}
