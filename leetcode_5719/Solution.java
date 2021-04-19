
import java.util.Arrays;

// 5719. 每个查询的最大异或值
public class Solution {

    public static void main(String[] args) {

        int[] nums = {0,1,2,2,5,7};

        System.out.println(Arrays.toString(getMaximumXor(nums , 3)));

    }


    public static int[] getMaximumXor(int[] nums, int maximumBit) {

        if(nums == null ){
            return null;
        }



        int[] res = new int[nums.length];

        int tmp = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tmp ^= nums[i];
        }

        int savedNum = 0 , maxNum = 0;

        for (int i = 0; i < Math.pow(2,maximumBit); i++) {

            if((tmp ^ i) > maxNum){
                res[0] = i;
                maxNum = tmp ^ i;
            }


        }

        for (int i = 1; i < nums.length; i++) {

            res[i] =  nums[nums.length  - i ] ^ res[i-1];

        }



        return res;

    }

}
