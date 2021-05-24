public class Solution {

    public static void main(String[] args) {

        String s = "aaabbb";
        System.out.println(strangePrinter(s));
    }

    public static int strangePrinter(String s) {

        if(s == null){
            return 0;
        }

        int len = s.length();

        // 令 dp[i][j] 表示打印完成区间 [i,j] 的最少操作数。
        int[][] dp = new int[len][len];

        for (int i = len-1; i >= 0; i--) {

            dp[i][i] = 1;
            for (int j = i+1; j < len; j++) {

                // 字符相同时，可以一次打印出来
                if(s.charAt(i) == s.charAt(j)){

                    dp[i][j] = dp[i][j-1];
                }else{

                    // 区间两端的字符不同
                    int minn = Integer.MAX_VALUE;
                    
                    // [i,j]区间分成两段后，两段dp结果相加的最小结果
                    for (int k = i; k < j; k++) {
                        minn = Math.min(minn, dp[i][k] + dp[k + 1][j]);
                    }
                    dp[i][j] = minn;
                }

            }
        }

        return dp[0][len-1];

    }


}
