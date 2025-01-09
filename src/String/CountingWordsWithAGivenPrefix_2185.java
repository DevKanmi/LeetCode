package String;

/*
Link: https://leetcode.com/problems/counting-words-with-a-given-prefix/
Difficulty: Easy

Approach: Pretty Straightforward question, just needed to loop through a given array use a built in method
to compare if the whatever word in that array starts with that prefix and keep a count variable to be
incremented if that condition is true, after the array has been looped through and we have accounted
for all words that start with that prefix we can return the count.
 */
public class CountingWordsWithAGivenPrefix_2185 {
    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for(int i = 0; i< words.length; i++){
            if(words[i].startsWith(pref)){
                count++;
            }
        }
        return count;
    }
}
