

public class Solution {

    private static int res ;
    public static void main(String[] args) {


        int[] nums = {1,1,1,1,1};
        int target = 3;

        System.out.println(findTargetSumWays_DP(nums,target));


    }

    public static int findTargetSumWays_DP(int[] nums , int target){

        if(nums == null) return 0;

        int sum = 0;
        for (int num : nums) sum += num;


//        f[i][j] 代表考虑前 i 个数，当前计算结果为 j 的方案数，令 nums 下标从 1 开始。
        int len = nums.length;
        // [0,sum) 代表负数 (sum+1,2*sum]代表正数
        int[][] dp = new int[len+1][2 * sum + 1]; // 有可能是 负数 或者 0

        if(target > sum) return 0;

        // 因为还没有任何一个数，所以总和是 0
        dp[0][sum] = 1;

        for (int i = 1; i <= len; i++) {
            int x = nums[i-1];
            for (int j = -sum; j <= sum; j++) {
                // 之前的和是正数
                if(j + sum - x >= 0) dp[i][j + sum] += dp[i-1][j-x+sum];
                // 之前的和是负数
                if(j + x <= sum)  dp[i][j+sum] += dp[i-1][j+x+sum];
            }
        }

        return dp[len][target + sum];

    }

    public static int findTargetSumWays(int[] nums, int target) {

        if(nums == null){
            return 0;
        }
        res = 0;


        helper(nums , 0 , target , 0);
        
        return res;
    }

    private static void helper(int[] nums , int index ,int target , int curNum){

        if(index == nums.length && target == curNum){
            res++;
            return ;
        }else if(index == nums.length){
            return ;
        }

        helper(nums , index+1 , target , curNum + nums[index]);

        helper(nums , index+1 , target , curNum - nums[index]);


    }


}
