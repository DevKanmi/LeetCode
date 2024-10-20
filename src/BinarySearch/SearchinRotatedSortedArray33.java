package BinarySearch;

public class SearchinRotatedSortedArray33 {
    public int search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;

        while(l<=r){
            int m = (l+r)/2; //Middle Index

            if(nums[m] == target) return m;

                //Checking if L-> M is the sorted part.
            else if(nums[l]<= nums[m]){

                //If true Checking if target is between L <--> M.
                if(nums[l]<= target && target <= nums[m]){
                    //Move right Pointer to M-1
                    r = m - 1;
                }
                else{
                    //So target does not exist between  L --> M, Move L to the right half.
                    l = m + 1;
                }
            }
            else{
                //Entering this else statement means the L > M, hence current L <--> M is not currently the sorted part.

                //Let's check if target exists.
                if(nums[m]<=target && target <= nums[r]){
                    //if true Let's move L to the right of the Middle pointer
                    l = m + 1;
                }
                else{
                    //Move R to left of the middle Pointer and we check again if L <---> M is sorted now.
                    r = m - 1;
                }
            }
        }

        return -1;
    }
}
