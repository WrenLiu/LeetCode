

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {

        int[] coins = { 1, 2, 5};

        System.out.println(coinChange_Mine(coins,11));

        System.out.println(coinChange(coins,11));

    }

    public static int coinChange(int[] coins, int amount){

        if(coins == null || coins.length == 0 || amount <= 0){
            return 0;
        }

        int[] dp = new int[amount + 1];

        Arrays.fill(dp , amount+666);

        dp[0] = 0;

        for (int i = 1; i < dp.length; i++) {

            for (int coin : coins) {
                if(i - coin < 0){
                    continue;
                }

                dp[i] = Math.min(dp[i] , 1 + dp[i - coin]);
            }

        }

        System.out.println(Arrays.toString(dp));

        return (dp[amount] == -666) ? -1 : dp[amount];



    }

    public static int coinChange_Mine(int[] coins, int amount) {

        if(coins == null || coins.length == 0 || amount <= 0){
            return 0;
        }

        if(coins.length == 1){
            if(amount % coins[0] == 0){
                return amount / coins[0];
            }else{
                return -1;
            }
        }

        int[] dp = new int[amount+1];
        Arrays.fill(dp,-1);


        dp[0] = 0;
        for (int i = 0; i < coins.length; i++) {
            if(coins[i] <= amount){
                dp[coins[i]] = 1;
            }
        }

        for (int i = 1; i <= amount ; i++) {

            for (int j = 0; j < coins.length; j++) {

                if(i- coins[j] >= 0 && dp[i - coins[j]] != -1){
                    if(dp[i] != -1){
                        dp[i] = Math.min(dp[i],dp[i - coins[j]] + dp[coins[j]]);
                    }else{
                        dp[i] = dp[i - coins[j]] + dp[coins[j]];
                    }
                }

            }
        }

        return dp[amount];


    }


}
