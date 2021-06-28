
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {


        int[] nums = {7,1,1,2,4};

        System.out.println(maxAlternatingSum(nums));



    }


    public static long maxAlternatingSum(int[] nums) {

        if(nums == null ){
            return 0;
        }

        int[] arr = new int[nums.length+2];

        //
        //

        /**
         * 两侧补0
         * 贪心思路： 加的时候加波峰，减的时候减波谷
         * arr：
         *      6                       5
         *                         4
         *          2         2
         *               1
         *   0                              0
         *   结论 ： [6 , 5]是波峰 符号为 + , [0,1,0]是波谷 符号为 -
         */

        System.arraycopy(nums, 0, arr, 1, nums.length);
        boolean isPlus = true;
        long res = 0;

//        System.out.println(Arrays.toString(arr));

        for (int i = 1; i < arr.length-1; i++) {

            if( isPlus && arr[i] >= arr[i+1] && arr[i] >= arr[i-1] ){
//                System.out.println("++++  "+arr[i]);
                res += arr[i];
                isPlus = !isPlus;
            }

            if( !isPlus && arr[i] <= arr[i+1] && arr[i] <= arr[i-1]){
//                System.out.println("----  "+arr[i]);
                res -= arr[i];
                isPlus = !isPlus;
            }
        }


        


        

        return res;



    }

}
