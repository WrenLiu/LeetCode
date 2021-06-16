
public class Solution {


    public static void main(String[] args) {

        int[] piles = {5,3,4,5};

        System.out.println(stoneGame(piles));
        // 最优解直接 return true;

    }

    public static boolean stoneGame(int[] piles) {

        if(piles == null){
            return false;
        }

        int len = piles.length;


        // dp[i][j] 表示当剩下的石子堆为下标 i 到下标 j 时(i,j 为石头堆的索引)，当前玩家与另一个玩家的石子数量之差的最大值
        // 所以 i == j 的时候，必然是 piles[i]
        int[][] dp = new int[len][len];

        for (int i = 0; i < len; i++) {
            dp[i][i] = piles[i];
        }

        // 只有当 i ≤j 时，剩下的石子堆才有意义(左侧索引小于等于右侧索引)，因此当 i>j 时，dp[i][j]=0
        for (int i = len - 2; i >= 0; i--) {
            for (int j = i + 1; j < len; j++) {
                // 即选择左侧 或者 选择右侧,来让自己的石头数量最大化
                dp[i][j] = Math.max(piles[i] - dp[i + 1][j], piles[j] - dp[i][j - 1]);
            }
        }




        return dp[0][len - 1] > 0;

    }



}
