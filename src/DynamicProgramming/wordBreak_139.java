package DynamicProgramming;

/*
Link:
Approach:
/**

 * RECURSIVE THOUGHT PROCESS (base idea):
 * - Start from the first character in the string.
 * - Try to cut the string at every possible point.
 * - If the left part (prefix) is a word in the dictionary,
 *   then check if the right part (rest of the string) can also be broken down the same way.
 * - Keep doing this until:
 *     → You reach the end of the string (success).
 *     → Or you run out of valid splits (failure).
 * - This works, but it's very slow — because it repeats a lot of the same checks again and again.
 *
 * OPTIMIZED VERSION (Dynamic Programming – Bottom-Up):
 * - Instead of rechecking the same things over and over,
 *   we build up an answer using a dp[] array where:
 *   → dp[i] is true if s[0...i-1] can be split into valid words.
 * - Start with dp[0] = true (an empty string is always valid).
 * - Then for each position i in the string:
 *   → Look back at every position j < i.
 *   → If dp[j] is true, and s[j...i] is in the dictionary,
 *      it means s[0...i] can be split → so set dp[i] = true.
 *   → Break early when you find the first valid split (no need to keep checking).
 *
 *
 * Time: O(n^2) for the nested loops
 * Space: O(n) for the dp array
 */


public class wordBreak_139 {
    // USING RECURSION AND MEMOIZATION
    public boolean wordBreak(String s, List<String> wordDict) {
        Boolean[] memo = new Boolean[s.length()];
        HashSet<String> set = new HashSet<>(wordDict);
        return canbreak(s, wordDict, 0, memo, set);
    }

    private boolean canbreak(String s, List<String> wordDict, int start, Boolean[] memo, HashSet<String> set){
        // Base case
        if(start == s.length()) return true;

        if(memo[start] != null) return memo[start];

        for(int end = start + 1; end <= s.length(); end++){
            String word = s.substring(start, end);
            //check if the current substring we are at is valid word in the set and then recursively call the rest of
            // the string to do the same thing, till we get to the base case
            if(set.contains(word) && canbreak(s, wordDict, end, memo, set)){
                return memo[start] = true;
            }
        }

        //Memoize the start index so anytime are at that index if true or false we return straight up
        return memo[start] = false;
    }

    //USING DYNAMIC PROGRAMMING AND A DP ARRAY
    Set<String> set = new HashSet<>(wordDict);
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;

        for(int i = 1; i <= s.length(); i++){
            /* so we are going from j - i s[j : i] and checking if that substring is valid if it is update
        dp[i] to true and break, why break?(we already tried those substrings before and they did not work so j
        does not need to get to i, now to enter the if condition dp[j must be true meaning at maybe index 0-4 we found
        a valid word mark it to be true so whenever we check it back we see that we already found a valid word there and
        we can now update this one also.

        */
        for(int j = 0; j < i; j++){
            if(dp[j] && set.contains(s.substring(j, i))){
                dp[i] = true;
                break;
            }
        }
    }
        return dp[s.length()];
}
}

}
