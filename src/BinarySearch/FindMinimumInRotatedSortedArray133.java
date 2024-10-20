package BinarySearch;
/* https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/ */
public class FindMinimumInRotatedSortedArray133 {
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }

        int l = 0;
        int h = nums.length - 1;

        while(l<=h) {
            int middle = (l+h)/2;

            if(nums[l] < nums[h] || l == h){
                return nums[l];
            }
            if(nums[l] > nums[h] && nums[middle] > nums[h]){
                l = middle + 1;
            }

            if(nums[l] > nums[h] && nums[middle] < nums[h]){
                h = middle;
            }

        }
        return -1;
    }
}
