package SortingAlgorithms;
/*
Time complexity: o(n + k)
Space complexity: o(n + k)

It's a non comparison sorting algorithm.

Assumptions of
1. All numbers being positive must be made
2. The range of the numbers must be known also.
 */
public class countingSort {
    public static void main(String[] args) {
        int[] arr = {2,4,5,6,2,4,2,1,2,3,2,5,6,2,4,6,7,3,6,8,5,3,5,8,2,0,3,0,0,7};
        countingSort(arr);
    }

    private static int[] countingSort(int[] input){
        int max = input[0];

        //Find Maximum value
        for(int i = 1; i < input.length; i++){
            if(input[i] > max){
                max = input[i];
            }
        }
        //Create count array
        int[] count = new int[max + 1];


        //Populate count array
        for(int i = 0; i < input.length; i++){
            count[input[i]]++;
        }

        //Get prefix sum of count array
        for(int i = 1; i < count.length; i++){
            count[i] = count[i] + count[i - 1];
        }

        //Now create output array
        int[] output = new int[input.length];

        for(int i = output.length- 1; i >=0; i--){
            output[count[input[i]] - 1] = input[i];
            count[input[i]]--;
        }
        return output;
    }
}
