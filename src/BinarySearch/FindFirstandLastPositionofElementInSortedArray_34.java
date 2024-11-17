package BinarySearch;

/* Link to Question: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=problem-list-v2&envId=binary-search */
public class FindFirstandLastPositionofElementInSortedArray_34 {
    public int[] searchRange(int[] nums, int target) {

        int left = binarySearch(nums, target, true);
        int right = binarySearch(nums, target, false);

        return new int[] {left, right};
    }

    //helper function
    private int binarySearch(int[] nums ,int target, boolean searchingLeft){
        int l =  0;
        int r = nums.length - 1;
        int index = -1;

        //Implement Binary Search
        while(l<=r){
            int mid = l + (r-l) / 2;

            if(target > nums[mid]){
                l = mid + 1;
            }

            else if(target < nums[mid]){
                r = mid - 1;
            }

            else{
                index = mid;
                //We want to look for the left most occurence of number if true
                if(searchingLeft){
                    r = mid - 1;
                }
                else{
                    l = mid + 1;
                }
            }
        }
        return index;
    }
}
