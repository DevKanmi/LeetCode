package SortingAlgorithms;

import java.util.*;

public class BucketSort {
    public static void bucketSort(float[] arr){
        int n =arr.length;
        if(n <= 0) return;

        //1. create n empty buckets
        @suppressWarnings("unchecked")
        List<Float>[] buckets  = new ArrayList[n];
        for(int i = 0; i < n; i++){
            buckets[i] = new ArrayList<>();
        }

        // 2. put array elements into buckets
        for(int i = 0; i < n; i++){
            int index = (int)(arr[i] * n); // index = floor(n * arr[i]
            buckets[index].add(arr[i]);
        }

        //3.sort individual buckets

        for(int i = 0; i < n; i++){
            Collections.sort(buckets[i]);
        }

        // 4. concatenate all buckets into arr[]
        int idx = 0;
        for(int i = 0; i < n; i++){
            for(float val : buckets[i]){
                arr[idx++] = val;
            }
        }
    }
    public static void main(String[] args) {
        float[] arr = {0.42f, 0.32f, 0.23f, 0.52f, 0.25f, 0.47f, 0.51f};
        bucketSort(arr);
        System.out.println("Sorted array: ");
        for(float num: arr){
            System.out.print(num + " ");
        }
    }
}
