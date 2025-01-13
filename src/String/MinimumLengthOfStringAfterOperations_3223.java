package String;

import java.util.*;

/*
Link: https://leetcode.com/problems/minimum-length-of-string-after-operations/description/
Difficulty: Medium

Approach/Hint : Use a hashmap to store the frequency of each character
If a character occurs less than 3 times, we cannot perform any process with it.
Suppose there is a character that occurs at least 3 times in the string, we can repeatedly
delete two of these characters until there are at most 2 occurrences left of it.

 */
public class MinimumLengthOfStringAfterOperations_3223 {
    public int minimumLength(String s) {
        HashMap< Character, Integer> map = new HashMap<Character, Integer>();

        for (char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c , 0) + 1);
        }

        int length = s.length();

        for(char c : map.keySet()){
            while(map.get(c) >= 3){
                map.put(c, map.get(c) - 2);
                length = length - 2;
            }
        }

        return length;
    }
}
