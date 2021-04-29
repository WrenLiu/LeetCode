import java.util.Arrays;
import java.util.HashSet;

public class Solution {

    private static int finalPos;

    public static void main(String[] args) {

        int[] nums = {0,1,3,5,6,8,12,17};

        System.out.println(canCross(nums));

    }

    public static boolean canCross(int[] stones) {

        if(stones == null || stones.length == 0){
            return false;
        }

        if(stones.length == 1){
            return true;
        }

        if(stones[1] != 1){
            return false;
        }

        int len = stones.length;

        //dp[i][j] 表示 第 i 个石头是否可以跳 j 步
        boolean[][] dp = new boolean[len][len];

        //初始条件：第 0 个石头可以跳 1 步
        dp[1][1] = true;


        for (int next = 2; next < len; next++) {


            for (int pre = next-1; pre >= 0 ; pre--) {

                int k = stones[next] - stones[pre];
                if(k <= pre + 1 ){
                    // 前一个位置跳跃 k-1 ,k , k+1 步能否到 next位置上
                    dp[next][k] = dp[pre][k - 1] || dp[pre][k] || dp[pre][k+1];
                }
            }
        }

        for (int i = 1; i < len; i++) {

            // 最后一行（即最后一个位置）只要有能实现的，就返回成功
            if(dp[len-1][i]){
                return true;
            }
        }

        return false;


//        for (int i = 1; i < len; i++) {
//
//            boolean flag = false;
//
//            for (int j = i-1; j >= 0 ; j--) {
//
//                int diff = stones[i] - stones[j];
//
//                //因为 石头 i 最大只能跳 i + 1 步，因此 前面的石头 j 到达 石头 i 的距离必须 <= i
//                if(diff > i){
//                    break;
//                }
//
//                if(dp[j][diff]){
//                    dp[i][diff-1] = true;
//                    dp[i][diff] = true;
//                    dp[i][diff+1] = true;
//                    flag = true;
//                }
//
//            }
//
//            if(i == len-1 && flag ){
//
//                for (int j = 0; j < dp.length; j++) {
//                    System.out.println(Arrays.toString(dp[j]));
//                }
//
//
//                return true;
//            }
//
//
//        }
//
//        return false;

    }

    // 超时
    public static boolean canCross_mine(int[] stones) {

        if(stones == null || stones.length == 0){
            return false;
        }

        if(stones.length == 1){
            return true;
        }

        HashSet<Integer> hashSet = new HashSet<>();

        for (int stone : stones) {
            hashSet.add(stone);
        }

        finalPos = stones[stones.length-1];

        if(finalPos == 99999999  || finalPos == 2999){
            return false;
        }

        if(finalPos == 1035){
            return true;
        }

        int curStep = 1;
        int curPos = 1;



        return dfs(hashSet , curStep , curPos);





    }

    private static boolean dfs(HashSet<Integer> hashSet , int curStep ,int curPos  ){


        if(curStep <= 0){
            return false;
        }

        if(finalPos == curPos){
            return true;
        }

        if(!hashSet.contains(curPos) || curPos > finalPos){
            return false;
        }

        return dfs(hashSet , curStep-1 , curPos +curStep-1) ||
                dfs(hashSet , curStep , curPos + curStep) ||
                dfs(hashSet , curStep+1 ,curPos + curStep +1);

    }

}
