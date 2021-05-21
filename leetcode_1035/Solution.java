

public class Solution {

    public static void main(String[] args) {

//        int[] nums1 = {1,3,7,1,7,5};
//        int[] nums2 = {1,9,2,5,1};


        int[] nums1 = {3};
        int[] nums2 = {3,3,2};
        System.out.println(maxUncrossedLines(nums1,nums2));
    }

    public static int maxUncrossedLines(int[] nums1, int[] nums2) {

        if(nums1 == null || nums2 == null){
            return 0;
        }

        int len01 = nums1.length;
        int len02 = nums2.length;
        int[][] dp = new int[len01+1][len02+1];

        for (int i = 1; i <= len01; i++) {
            for (int j = 1; j <= len02 ; j++) {
//              其中dp[i][j] 表示 nums1[0:i] 和 nums2[0:j] 的最长公共子序列的长度

                if(nums1[i-1] == nums2[j-1]){
                    dp[i][j] = dp[i-1][j-1]+1 ;
                }else{
                    dp[i][j] = Math.max(dp[i][j-1] , dp[i-1][j] );
                }

            }
        }

        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        return dp[len01][len02];





    }



}
