package SortingAlgorithms;

/* TC => o(n^2)
Approach : The idea is starting at the second element store it in the key variable, compare it to
elements that are before that index and if such elements are greater than the key, keep shifting them
forward till the element at index J is smaller than the key, which means all elements before that index j
are all smaller than the key and then we can now insert the key into j + 1 or if we get to -1 it means all the
elements to the left are greater than the key and then we can insert the key into the first index.

Then we move to the next element that is why it is o(n^2) we have to go through the array once then at each index in the
worst case compare with all elements in the array. so the key is always moving.
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr1 = {6,3,4,7,9,10,32,1,5,2};
        sort(arr1);
    }

    private static void sort(int[] arr){
        for(int i = 1; i < arr.length; i++){
            int key = arr[i];
            int j = i - 1;

            while( j > -1 && arr[j] > key){
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
        for(int i  = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
