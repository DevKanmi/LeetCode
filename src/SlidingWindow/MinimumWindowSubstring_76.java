package SlidingWindow;

/*Link to question: https://leetcode.com/problems/minimum-window-substring/  difficulty: Hard */
public class MinimumWindowSubstring_76 {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        int[] hash = new int[256];  // Store the frequency of characters in t

        // Populate the hash table with the frequency of characters in t
        for (int i = 0; i < t.length(); i++) {
            hash[t.charAt(i)]++;
        }

        int l = 0, r = 0, count = t.length(), minLen = Integer.MAX_VALUE;
        int startIndex = -1;

        while (r < s.length()) {
            // If the character at 'r' is needed, decrement the count
            if (hash[s.charAt(r)] > 0) {
                count--;
            }
            hash[s.charAt(r)]--;
            r++;

            // When all characters are matched, minimize the window
            while (count == 0) {
                if (r - l < minLen) {
                    minLen = r - l;
                    startIndex = l;
                }

                // Move left pointer to shrink the window
                hash[s.charAt(l)]++;

                // If the character is part of t and now out of the window
                if (hash[s.charAt(l)] > 0) {
                    count++;
                }
                l++;
            }
        }

        return (startIndex == -1) ? "" : s.substring(startIndex, startIndex + minLen);
    }
}
