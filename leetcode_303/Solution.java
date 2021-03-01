
import java.lang.reflect.Array;
import java.util.Arrays;

public class Solution {

    private static int[] preSum;

    public static void main(String[] args) {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        preSum = new int[nums.length];
        
        
        if (nums.length == 0) {
            return;
        }
        preSum[0] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            preSum[i] = preSum[i-1] + nums[i];
        }

        System.out.println(Arrays.toString(preSum));



        System.out.println(sumRange(2,5));
    }

    public static int sumRange(int i, int j) {

        if(i == 0){
            return preSum[j];
        }else {
            return preSum[j] - preSum[i-1];
        }


    }


}
