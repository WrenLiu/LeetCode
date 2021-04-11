

import java.util.Arrays;

public class Solution {


    private static int res ;
    public static void main(String[] args) {
        int[] nums = {0,1,2,3,0};

        System.out.println(minSideJumps_mine(nums));

    }

    public static int minSideJumps(int[] obstacles){
        if(obstacles == null || obstacles.length == 0){
            return 0;
        }

        int len = obstacles.length;

        // 定义状态：dp[i][j]：到达第i个结点且在第j条道路所需要的最少侧跳数量
        int[][] dp = new int[len+1][4];

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i] , Integer.MAX_VALUE);
        }



        dp[1][1] = 1;
        dp[1][3] = 1;
        dp[1][2] = 0;

        for (int i = 2; i <= len; i++) {

            // 当前节点上没有石头，从上一个位置不换赛道的过来
            if(obstacles[i-1] != 1) dp[i][1] = dp[i-1][1];
            if(obstacles[i-1] != 2) dp[i][2] = dp[i-1][2];
            if(obstacles[i-1] != 3) dp[i][3] = dp[i-1][3];

            // 除了可以从同一跑道的前一个结点跳过来, 还可以从其他另外两个跑道侧跳过来
            if(obstacles[i-1] != 1) dp[i][1] = Math.min(dp[i][1], Math.min(dp[i][2],dp[i][3])+1);
            if(obstacles[i-1] != 2) dp[i][2] = Math.min(dp[i][2], Math.min(dp[i][1],dp[i][3])+1);
            if(obstacles[i-1] != 3) dp[i][3] = Math.min(dp[i][3], Math.min(dp[i][1],dp[i][2])+1);

        }


        return Math.min(dp[len][1],Math.min(dp[len][2], dp[len][3]));



    }



    public static int minSideJumps_mine(int[] obstacles) {

        if(obstacles == null || obstacles.length == 0){
            return 0;
        }


        res = Integer.MAX_VALUE;

        dfs(obstacles,0,2, 0);

        return res;

    }

    private static void dfs(int[] obstacles, int curIndex , int curTrack ,int curRes){

        if(obstacles[curIndex] == curTrack){
            return;
        }

        if(curIndex == obstacles.length-1){
            res = Math.min(res,curRes);
            return ;
        }

        for (int i = 1; i <= 3; i++) {

            if( i != obstacles[curIndex] && obstacles[curIndex + 1] != i){

                if(i != curTrack) {

                    curRes++;
                    dfs(obstacles,curIndex+1, i,curRes);
                    curRes--;

                }else{
                    dfs(obstacles,curIndex+1, curTrack,curRes);
                }

            }
        }


    }

    private static int helper(int num1 , int num2){
        return 6 - num1 - num2;
    }


}
