package SortingAlgorithms;

/*
Implementation of Quick Sort Algorithm
Time complexity : worst case is o(n^2) average case o(nlogn)
Sorts array in place no new dsa has to be created for sorting.

Approach : A pivot point is picked elements smaller than pivot is moved to the left and
elements greater than pivot is moved to the right after the partition is done it moves to a smaller array and
does the same thing till there is only one element there p == r and when that is done it starts returning

it is also a comparitive algorithm.
 */

public class quickSort {
    public static void main(String[] args) {
        int[] arr = {2,4,5,6,2,4,2,1,2,3,2,5,6,2,4,6,7,3,6,8,5,3,5,8,2,0,3,0,0,7};
        QuickSort(arr, 0, arr.length - 1);

        for(int i: arr){
            System.out.print(i + " ");
        }
    }

    private static void QuickSort(int[] arr, int low, int high ){
        if(low < high){
            int q = partition(arr, low, high);
            QuickSort(arr, low, q - 1);
            QuickSort(arr, q + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high){
        int x = arr[high];
        int i = low - 1;

        for(int j = low; j < high; j++){
            if(arr[j] < x){
                i = i + 1;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
            int t2 = arr[i + 1];
            arr[i + 1] =x;
            arr[high] = t2;
       return i + 1;
    }
}
