
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {


        int[] cost = {4,3,2,5,6,7,2,5,5};
        int target = 9;
        System.out.println(largestNumber(cost , target));


    }

    public static String largestNumber(int[] cost, int target) {

        if(cost == null)
            return "";

        int minNum = 0x3f3f3f3f;
        for (int i : cost) {
            minNum = Math.min(i , minNum);
        }

        int[][] dp = new int[10][target + 1];

        for (int i = 0; i < 10; i++) {
            Arrays.fill(dp[i] , Integer.MIN_VALUE);
        }

        // 为了生成最终的结果,记录状态转移来源
        int[][] from = new int[10][target + 1];

        dp[0][0] = 0;

        for (int i = 0; i < 9; i++) {
            int c = cost[i];

            for (int j = 0; j <= target; j++) {


/**
 * - 若 j < cost[i],则无法选择第i个数位,此时有 dp[i+1][j] = dp[i][j]
 * - 若 j ≥ cost[i],存在选或不选两种决策,不选时就是 dp[i+1][j] = dp[i][j], 选时由于第 i 个数位可以重复选择,可以从使用之前 i 个数位且
 *      且花费总成本恰好为 j-cost[i]的状态转移过来,即dp[i+1][j] = dp[i+1][j - cost[i]] + 1
 */
                if(j < c){
                    dp[i+1][j] = dp[i][j];
                    from[i + 1][j] = j;
                }else{

                    if(dp[i][j] > dp[i+1][j - cost[i]] + 1){
                        dp[i+1][j] = dp[i][j];
                        from[i+1][j] = j;
                    }else{
                        dp[i+1][j] = dp[i+1][j - cost[i]] + 1;
                        from[i+1][j] = j - c;
                    }
                }


            }


        }


        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {

                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }

        System.out.println("---------");
        for (int i = 0; i < from.length; i++) {
            for (int j = 0; j < from[0].length; j++) {

                System.out.print(from[i][j]+" ");
            }
            System.out.println();
        }


        if (dp[9][target] < 0) {
            return "0";
        }
        StringBuffer sb = new StringBuffer();
        int i = 9, j = target;
        while (i > 0) {
            if (j == from[i][j]) {
                --i;
            } else {
                sb.append(i);
                j = from[i][j];
            }
        }
        return sb.toString();


    }



}
