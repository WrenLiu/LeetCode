

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {7,7,7,7,7,7,7};

        System.out.println(lengthOfLIS(nums));

    }

    public static int lengthOfLIS(int[] nums) {

        if(nums == null && nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }


        for (int i = 1; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {

                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

        }


        Arrays.sort(dp);





        return dp[dp.length-1];

    }


}
