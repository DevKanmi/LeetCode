package Greedy;
import java.util.*;

/*
TC: o(n) + o(n) + o(n) => o(n)
SC: o(n) => candy array

Approach : Key Idea (Greedy, 2 passes)
       Local constraints → can be fixed with two directional scans.
       Always give 1 candy initially.(Use Array.fill to do that)

Pass 1 (Left → Right)
        If ratings[i] > ratings[i-1], then
        candies[i] = candies[i-1] + 1.
Pass 2 (Right → Left)
        If ratings[i] > ratings[i+1], then
        candies[i] = max(candies[i], candies[i+1] + 1).
 */

public class Candy_135 {
    public int candy(int[] ratings) {

        int[] candyArr = new int[ratings.length];
        //Every child is guaranteed at least one sweet
        Arrays.fill(candyArr, 1);

        //If child has higher rating than left neighbor, give them 1 more candy.
        for(int i = 1; i < ratings.length; i++){
            if(ratings[i] > ratings[i - 1]){
                candyArr[i] = candyArr[i - 1] + 1;
            }
        }

        //If child has higher rating than right neighbor, give them 1 more candy.
        for(int i = ratings.length - 2; i >= 0; i--){
            if(ratings[i] > ratings[i + 1]){
                //Use Math.max to avoid breaking what left→right already set.
                candyArr[i]  = Math.max(candyArr[i], candyArr[i + 1] + 1);
            }
        }

        int total = 0;
        for(int i : candyArr) total+=i;

        return total;

    }
}
