

public class Solution {

    public static void main(String[] args) {

        String text1 = "abc";
        String text2 = "def";

        System.out.println(longestCommonSubsequence(text1,text2));

    }

    public static int longestCommonSubsequence(String text1, String text2) {

        if(text1 == null || text2 == null){
            return 0;
        }

        // dp[i][j] 表示 text1[0:i-1] 和 text2[0:j-1] 的最长公共子序列
        int[][] dp = new int[text1.length()+1][text2.length()+1];

        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {

                if(text1.charAt(i-1) == text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }


            }
        }

//        for (int i = 0; i <= text1.length(); i++) {
//            for (int j = 0; j <= text2.length(); j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//
//
//        }


        return dp[text1.length()][text2.length()];

    }



}
