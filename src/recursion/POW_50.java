package recursion;

/*
Link: https://leetcode.com/problems/powx-n/
difficulty: Medium

Approach: we used recursion here with a base case of if n==0 return 1
so the constraints had n to be either negative or a positive number so we
had to handle both scenarios

if n is a negative no it simply means we had to turn x to a fraction
eg n = -3 x = 4 simply means 1/4^3 hence we had to manipulate x and also take the absolute of y.
 */

public class POW_50 {
    public double myPow(double x, int n) {
        long nlong = (long)(n); // handles edge case when n overflows
        if(n < 0){
            x = 1/x;
            nlong = Math.abs(nlong);
        }
        /*
        This testcase fails "n = -2147483648" because in our first if condition we are
        converting all negative ints to positive, if you recall max int is 2147483647
        so to handle it we had to cast int values to long so it can be contained.
        */

        if(nlong == 0) return 1;

        if(nlong % 2 == 0) return myPow(x * x, (int)(nlong/2)); // => eg 2^4 = (2*2) ^ 2

        return x * myPow(x, (int)(nlong-1));
        // 2^5 (odd) => 2 * 2^4 ==> 2 *(2*2)^2 => 2* (4)^2 => 2 * 4 *4 * (4)^0 => 2*16*1 => 32
    }
}
