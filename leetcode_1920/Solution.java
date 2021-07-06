
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] arr = {5,0,1,2,3,4};

        System.out.println(Arrays.toString(buildArray(arr)));




    }

    public static int[] buildArray(int[] nums) {

        if(nums == null){
            return null;
        }

        int[] res = new int[nums.length];
        int len = nums.length;


        for (int i = 0; i < len; i++) {
            res[i] = nums[nums[i]];
        }

        return res;

    }

}
