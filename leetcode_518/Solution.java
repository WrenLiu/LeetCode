
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int amount  = 5;
        int[] coins = {1, 2, 5};

        System.out.println(change(amount , coins));

    }

    public static int change(int amount, int[] coins) {

        if(amount <= 0 || coins == null || coins.length == 0){
            return 0;
        }

        int[] dp = new int[amount+1];

        // 当不选取任何硬币时,总金额0的硬币组合数是1
        dp[0] = 1;

        for (int coin : coins) {
            for (int i = 1; i <= amount; i++) {

                if(i >= coin){
                    // 将 j - coin
                    dp[i] += dp[i -coin];
                }
            }

            System.out.println(Arrays.toString(dp));
        }

        return dp[amount];

    }



}
