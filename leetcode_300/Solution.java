

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,3,6,7,9,4,10,5,6};

        System.out.println(lengthOfLIS_BinarySearch(nums));

    }

    public static int lengthOfLIS_BinarySearch(int[] nums){

        int maxL = 0;
        int[] dp = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {

            int left = 0,right = maxL;

            while(left < right) {
                int mid = left + (right - left) / 2;
                if (dp[mid] < nums[i]) {
                    left = mid + 1;
                } else {
                    right = mid;
                }

            }

            dp[left] = nums[i];
            if (left == maxL) {
                maxL++;
            }
        }

        System.out.println(Arrays.toString(dp));
        return maxL;


    }

    public static int lengthOfLIS(int[] nums) {

        if(nums == null && nums.length == 0){
            return 0;
        }

        int[] dp = new int[nums.length];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = 1;
        }
        int maxLen = 1;


        for (int i = 1; i < nums.length; i++) {

            for (int j = 0; j < i; j++) {

                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            maxLen = Math.max(maxLen,dp[i]);

        }

        Arrays.sort(dp);







        return maxLen;

    }


}
