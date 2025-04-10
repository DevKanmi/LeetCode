package BackTracking;
/*
Link: https://leetcode.com/problems/letter-combinations-of-a-phone-number/
Difficulty: Medium

Approach: The first thing I did was to convert the digits string to a character arrays,
and map each possible digit value to the string characters in the hashmap

then I created my backtrackting function with a base case of whenever the index(idx) gets to digits.length
we have gotten to the end of the string so add whatever string we had gotten so far to the list and return,
basically what return does is it enables the function to use .remove to get rid of the last element so a new one
can come in and recursion can be applied on it.

so the value was used to get the string of that digit from the hashmap eg = value = abc
then we start at a, add it to the string builder call the function to increment index so then idx is 1,
it then adds string there now, value is = "def", same thing it adds to the string builder (a,d) now once we reach the base
case idx == 2 we now remove d but still in our for Loop we now add e so our new string is (a,e) so on till we are done
with the value = def then we go back to abc and move on to b being in the string builder so now it is (b, ..) repeating
the same process till we have taken care of everything.

TC => O(4^N * N)
SC => O(N)

 */
public class LetterCombinationsOfAPhoneNumber_17 {
    List<String> comb = new ArrayList<String>();

    public List<String> letterCombinations(String digits) {
        char[] digit = digits.toCharArray();
        if (digit.length == 0) {
            return comb;
        }
        HashMap<Character, String> map = new HashMap<>();
        map.put('2', "abc");
        map.put('3', "def");
        map.put('4', "ghi");
        map.put('5', "jkl");
        map.put('6', "mno");
        map.put('7', "pqrs");
        map.put('8', "tuv");
        map.put('9', "wxyz");

        backtrack(0, digit, map, new StringBuilder());
        return comb;
    }

    private void backtrack(int idx, char[] digit, HashMap<Character, String> map, StringBuilder sb) {
        if (idx == digit.length) {
            comb.add(sb.toString())); //We can simply just convert sb to string without putting it in new SB constructor
            return;
        }

        String value = map.get(digit[idx]);

        for (int i = 0; i < value.length(); i++) {
            sb.append(value.charAt(i));
            backtrack(idx + 1, digit, map, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}
