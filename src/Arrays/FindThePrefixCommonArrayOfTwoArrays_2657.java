package Arrays;
/*
Link: https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/
Difficulty: Medium

Approach/Hint:
 */
public class FindThePrefixCommonArrayOfTwoArrays_2657 {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {

        int[] freq = new int[A.length + 1];
        int[] res = new int[A.length];

        for(int i = 0; i< A.length; i++){
            freq[A[i]]++;
            freq[B[i]]++;

            int count = 0;
            for(int j : freq){
                if( j == 2){
                    count++;
                }
            }
            res[i] = count;
        }
        return res;
    }
}
