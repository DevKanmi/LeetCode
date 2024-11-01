package TwoPointers;

/*
Link --> https://leetcode.com/problems/longest-palindromic-substring/description/

This Leetcode Problem makes use of two pointers to find the longest palindromic sustring.
time complexity of O(n^2)
space complexity of O(1)

we make use of helper function to find the palindromic substring for every
character, palidromes expands from the middle so for every character we
assume it is at the middle of a "possible palindrome" and we expand out to the left and right and
if a palindrome is found, we return back to the main function and calculate the lenght
 */

public class LongestPalindromicSubstring_5 {
    public String Longest( String s){
        if(s == null || s.length() == 0){
            return "";
        }

        int start = 0;
        int end = 0; // Possible start and end of string is initialized

        //Initialize a for loop to go through evey character acting as a possible middle character
        for(int i = 0; i< s.length(); i++){
            int odd = isPalindrome(s, i, i); // if we have an odd string
            int even = isPalindrome(s, i, i+1); // if we have an even string

            int max_length = Math.max(odd, even);

            //Checks if the current max_length is greater than length of the current substring
            if(max_length > end - start){
                start = i - (max_length - 1)/2;
                end = i + max_length/2;
            }
        }
        return s.substring(start, end+1);
    }

    private int isPalindrome(String s, int l, int r){
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
        }
        return r - l - 1;
    }
}
