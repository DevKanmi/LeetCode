package SlidingWindow;

/* https://leetcode.com/problems/take-k-of-each-character-from-left-and-right/?envType=daily-question&envId=2024-11-20*/
public class TakeKofEachCharacterFromLeftandRight_2516 {
    public int takeCharacters(String s, int k) {

        int[] hash = new int[3];

        for(char c : s.toCharArray()){
            hash[c - 'a']++;
        }

        //The minimum out of all is less than k
        if(Math.min(Math.min(hash[0], hash[1]), hash[2]) < k){
            return -1;
        }

        int l = 0;
        int res = Integer.MAX_VALUE;

        for(int r = 0; r< s.length(); r++){
            hash[s.charAt(r) - 'a']--;

            while(Math.min(Math.min(hash[0], hash[1]), hash[2]) < k){
                hash[s.charAt(l) - 'a']++;
                l++;
            }
            res = Math.min(res, s.length() - (r-l+1));
        }
        return res;
    }
}
