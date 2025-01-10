package String;

/*
Link: https://leetcode.com/problems/word-subsets/description/
Difficulty: Medium
 */
import java.util.*;

public class WordsSubsets_916 {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        HashMap<Character, Integer> maxFreq = new HashMap<>();
        ArrayList<String> universal = new ArrayList<>();

        // Find max frequencies for words2
        for (String word : words2) {
            HashMap<Character, Integer> wordFreq = new HashMap<>(); // Frequency for current word2
            for (char letter : word.toCharArray()) {
                wordFreq.put(letter, wordFreq.getOrDefault(letter, 0) + 1);
            }
            // Update maxFreq with the maximum seen so far
            for (Map.Entry<Character, Integer> entry : wordFreq.entrySet()) {
                char c = entry.getKey();
                int count = entry.getValue();
                maxFreq.put(c, Math.max(maxFreq.getOrDefault(c, 0), count));
            }
        }

        for (String word : words1) {
            HashMap<Character, Integer> wordFreq = new HashMap<>(); // Frequency for current word1
            for (char letter : word.toCharArray()) {
                wordFreq.put(letter, wordFreq.getOrDefault(letter, 0) + 1);
            }

            boolean valid = true;
            for (Map.Entry<Character, Integer> entry : maxFreq.entrySet()) { // Iterate over maxFreq
                char c = entry.getKey();
                int requiredCount = entry.getValue();
                if (wordFreq.getOrDefault(c, 0) < requiredCount) {
                    valid = false;
                    break;
                }
            }

            if (valid) {
                universal.add(word);
            }
        }

        return universal;
    }
}
