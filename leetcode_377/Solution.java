
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class Solution {


    private static int res;
    public static void main(String[] args) {
        int[] nums = {1,2,3};

        System.out.println(combinationSum4_dp(nums,4));
//        System.out.println(combinationSum4_dfs(nums,32));

    }

    public static int combinationSum4_dp(int[] nums, int target) {

        if(nums == null || nums.length == 0){
            return 0;
        }

        int[] dp = new int[target+1];
        dp[0] = 1;

        for (int i = 0; i < target+1; i++) {

            for (int j = 0; j < nums.length; j++) {

                if (i >= nums[j]) {
                    dp[i] += dp[i - nums[j]];
                }
            }
        }



        return dp[target];

    }



    // 超时
    public static int combinationSum4_dfs(int[] nums, int target) {


        if(nums == null || nums.length == 0){
            return 0;
        }


        res = 0;

        ArrayList<Integer> arrayList = new ArrayList<>();



        dfs(nums, target, arrayList );



        return res;

    }

    private static void dfs(int[] nums , int total , ArrayList<Integer> arrayList ){

        if(total < 0){
            return;
        }

        if(total == 0){
            res++;
            return ;
        }

        for (int i = 0; i < nums.length; i++) {

            arrayList.add(nums[i]);
            dfs(nums, total - nums[i] , arrayList);
            arrayList.remove(arrayList.size()-1);

        }



    }




}
