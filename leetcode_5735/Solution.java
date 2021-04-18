

import java.util.Arrays;

public class Solution {


    private static int count;
    public static void main(String[] args) {
        int[] nums = {27,23,33,26,46,86,70,85,89,82,57,66,42,18,18,5,46,56,42,82,52,78,4,27,96,74,74,52,2,24,78,18,42,10,12,10,80,30,60,38,32,7,98,26,18,62,50,42,15,14,32,86,93,98,47,46,58,42,74,69,51,53,58,40,66,46,65,2,10,82,94,26,6,78,2,101,97,16,12,18,71,5,46,22,58,12,18,62,61,51,2,18,34,12,36,58,20,12,17,70};

//        int[] nums = {10,6,8,7,7,8};

        System.out.println(maxIceCream(nums,241));
    }

    public static int maxIceCream(int[] costs, int coins) {

        if(coins == 0 || costs == null){
            return 0;
        }

        Arrays.sort(costs);

        int res = 0;
        for (int i = 0; i < costs.length; i++) {

            if(coins - costs[i] >= 0){
                res++;
                coins -= costs[i];
            }


        }




        return res;



    }

    public static int maxIceCream_leetcode(int[] costs, int coins) {

        if(coins == 0 || costs == null){
            return 0;
        }

        count = 0;
        dfs(costs,coins, 0,0 );

        return count;

    }

    private static void dfs(int[] costs , int curCoins ,int index,int curCount){


        if(curCoins == 0 || index >= costs.length){

            count = Math.max(count , curCount);
            return;
        }


        for (int i = index; i < costs.length; i++) {

            if(curCoins - costs[i] >= 0){

                dfs(costs,curCoins - costs[i], i+1,curCount+1);
            }


        }



    }


}
