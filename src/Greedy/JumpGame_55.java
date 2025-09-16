package Greedy;

/*
TC: o(n)
SC : o(1)

Approach : at a particular index if it is exist within the farthest, for example
if we started at index 0 and it can jump to index 4, we go on to index 1, index 1 is between 0...4 so we can
check that particular index and check how far we can go from that index, we get how far it can go by adding the
index and the value at that index i + nums[i] and if we end up getting to the last index in the array we can return
true but if we are at a particular index and it is not within the current farthest it means there is no way we can ever
reach that index and we can return false then.
 */

public class JumpGame_55 {
    public boolean canJump(int[] nums) {

        int farthest = 0;

        for(int i = 0; i < nums.length; i++){
            //IF the current index exist in the current farthest we can update farthest then;
            if(i <= farthest) farthest = Math.max(farthest, i + nums[i]);

            //Else end the loop, we can't reach that index from previous computations so we would likely not reach the
            //last index
            else return false;

        }
        return true;
    }
}
