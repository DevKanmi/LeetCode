package Arrays;
/*
Link: https://leetcode.com/problems/find-the-prefix-common-array-of-two-arrays/
Difficulty: Medium

Approach/Hint:
    keep a frequency array that stores the count of occurrences of each number till index i, so we are trying to
    compare the all the elements at a particular index and the one before so we want to check if any of the elements of
    one exists in the other and we can do that by keeping track of frequency before we reach the index
    so if the element is present in both array, it means at a particualar index the element should read a freq
    count of 2 in our frequency array meaning if there is no 2 occurance of such element it does not exist in the
    other so that was what i basically did and checked
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
