package String;
import java.util.*;
/*
 Link:
 Difficulty:

Hint explains Approach:
 If the s.length < k we cannot construct k strings from s and answer is false.
 If the number of characters that have odd counts is > k then the minimum number of palindrome strings we can
 construct is > k and answer is false
 Otherwise you can construct exactly k palindrome strings and answer is true
 */
public class constructKPalindromesStrings_1400 {
    public boolean canConstruct(String s, int k) {

        if(s.length() < k){
            return false;
        }
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c , 0) + 1);
        }
        int count = 0;

        for(int val : map.values()){
            if(val % 2 == 1){
                count++;
            }
        }
        if(count > k){
            return false;
        }

        return true;
    }

}
