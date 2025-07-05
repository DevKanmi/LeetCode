package DynamicProgramming;

/*
Approach:
So we can first use recursion to pick one number in the subset and not pick that would lead to time limit issues
for large numbers so we can make use of dynamic programming, the bottom up approach

we want to reduce the problem to a subset sum problem but first we are finding subsets tha are equal to each
other but that is not possible if the sum of all elements is odd so we can just return false immediately

create a dp array
I initialize dp[0] = true because we can always make sum 0 by using no elements.
Then for each number in the array, I update the dp[] array from right to left.
This is important because we want to make sure each number is only used once —
which matches the 'subset' idea."

so if we find dp[i] to be true it means a sum we had previously done formed a subset and if we add the num
we are at to it, we update it to true because a new subset has formed, the idea is at the end the target must be true
that means all subsets must build toward the target being true

time complexity: o(n * target)
space complexity : dp => o(target)
 */
public class PartitionEqualSubsetSum_416 {
    public boolean canPartition(int[] nums) {
        int total = 0;
        for(int num : nums) total+=num;

        if(total % 2 != 0) return false;

        int target = total/ 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;

        for(int num : nums){
            for(int i = target; i>= num; i--){
                //We are checking here if target eg 11 - num eg 5 = 6 if dp[6] is true then we can update dp[11] = true
                //meaning we found a subset that can get us our target
                if(dp[i - num]){
                    dp[i] = true;
                }
            }
        }
        return dp[target];
    }
}
