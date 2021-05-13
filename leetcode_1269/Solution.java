

public class Solution {

    public static void main(String[] args) {

        int steps = 4, arrLen = 2;
        System.out.println(numWays(steps,arrLen));
    }



    public static int numWays(int steps, int arrLen) {
        final int MODULO = 1000000007;

        if(arrLen == 0 || steps == 0){
            return 0;
        }

//        用 dp[i][j] 表示在 i 步操作之后，指针位于下标 j 的方案数。
//        其中，i 的取值范围是 0≤i≤steps，j 的取值范围是 0≤j≤arrLen−1。

        int maxColumn = Math.min(arrLen-1, steps);
        int[][] dp = new int[steps+1][maxColumn+1];

        dp[1][0] = 1;
        dp[1][1] = 1;


        for (int i = 2; i <= steps; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                
                if(j == 0){
                    dp[i][j] = (dp[i-1][j] + dp[i-1][j+1]) % MODULO;
                }else if(j == dp[0].length - 1){
                    dp[i][j] = (dp[i-1][j-1] + dp[i-1][j]) % MODULO;
                }else{
                    dp[i][j] = ( (dp[i-1][j-1] + dp[i-1][j]  ) % MODULO + dp[i-1][j+1] ) % MODULO;
                }

            }
        }
        return dp[steps][0] % MODULO;

    }



}
