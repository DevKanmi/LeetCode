package Arrays;

public class ProductOfArrayExceptSelf_238 {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int[] result = new int[n];

        for(int i = 0; i < nums.length; i++){
            if(i == 0) prefix[0] = 1;
            else{
                prefix[i] = prefix[i - 1] * nums[i - 1];
            }
        }
        int no = 1;
        for(int i = n - 1; i >= 0; i--){
            if(i == n - 1) result[n - 1] = prefix[i] * 1;
            else{
                //"no" keeps track of the suffix found from nums[i + 1 ..n] and we simply just multiply it to the prefix to get our prefix * suffix
                no = no * nums[i + 1];
                result[i] = no * prefix[i];
            }
        }
        return result;
    }
}
